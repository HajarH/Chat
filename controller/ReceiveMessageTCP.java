/*
 * Nom de classe : ReceiveMessageTCP
 *
 * Description   : Permet la reception de paquets TCP avec un numero de port = Id du user local
 *
 * Version       : final
 *
 * Date          : 05/02/2020
 * 
 */

package controller;

import java.net.*;
import java.util.concurrent.LinkedBlockingQueue;

import view.*;
import model.User;

import java.io.*;


public class ReceiveMessageTCP extends Thread{
	
	//Variables 
    private int port;
    private User local;
    private LinkedBlockingQueue<String> bufTCP;
    private ServerSocket servSock;
    
    //Constructeurs 
    public ReceiveMessageTCP(LinkedBlockingQueue<String> buf ,int port, User local){ 
    	
        this.bufTCP =buf;
    	this.port = port;
        this.local = local;
        
        try {
			this.servSock = new ServerSocket(this.port,50,this.local.getIPAddr());
		} catch (IOException e) {
			System.out.println("ERROR TCP RCV");
		}  
        
        this.start();
    }
    
    
    public ReceiveMessageTCP(int port, User local){ 

    	this.port = port;
        this.local = local;
        
        try {
			this.servSock = new ServerSocket(this.port);
		} catch (IOException e) {
			System.out.println("ERROR TCP RCV");
		}  
        
        this.start();
    }
	
    
    public void run(){
    	
		try{  
			
		  while(Profile.localUser.getEtat().equals("CONNECTED")){
			  
		        Socket link = this.servSock.accept();
		        BufferedReader in ;
		    	in = new BufferedReader(new InputStreamReader(link.getInputStream()));
		    	String input = in.readLine();
		    	
		    	if(input != null ) {
		    		
		    		Thread oo = new Traiter(input,this.local, this.bufTCP);
		    		oo.join();
		    	}
		  }
		this.servSock.close();
		}catch(IOException e){
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}       
    }
    
    
    public static void closeSocket(ReceiveMessageTCP rcv) { //permet de fermer le socket en cas de depart imprevu
    	
    	try {
    		
			rcv.getSocket().close();
		} catch (IOException e) {
			System.out.println("SOCKET PAS FERME");
		}
    } 
    
    
    public ServerSocket getSocket() {
    	
    	return this.servSock;
    }
}
