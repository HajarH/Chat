/*
 * Nom de classe : ReceiveFile
 *
 * Description   : Permet la reception de Fichier 
 * 				   Non complet
 *
 * Version       : finale
 *
 * Date          : 05/02/2020
 * 
 */

/***
 * @author hajar
 */


/*
package controller;
import java.lang.System;
import java.net.*;
import model.User;

import java.io.*;
import java.lang.System;
import java.sql.SQLException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.*;
// on recoit les messages TCP sur le port = id de l'utilisateur local
// on envoi les messages TCP sur le port = id de l'utilisateur distant
class receiveFile extends Thread implements Serializable{
    private int socketPort;
    private User distant;
    private User local;
    private String FILE_NAME;

    public receiveFile(User distant, User local, String name){ // A recuperer dans le chatsession
        this.local = local;
    	System.out.println(this.local.getId());
    	this.socketPort = this.local.getId();
    	System.out.println("3 FILE");
        this.distant = distant;
    	System.out.println("4 FILE");
    	System.out.println("5 FILE");
        this.FILE_NAME = name;
        this.start();
    }
   
	    public void run(){
	        try{
	        	System.out.println("RECEIPTON FILE");
	        	
	        	File rec = new File(this.FILE_NAME);			
					DatagramSocket socketUDP = new DatagramSocket(this.socketPort);
					while(true) {
						System.out.println("RCV FILE 1");
					byte[] buffer = new byte[10000000];
					System.out.println("RCV FILE 2");

					DatagramPacket inPacket = new DatagramPacket(buffer, buffer.length);
					System.out.println("RCV FILE 3");

					socketUDP.receive(inPacket);
					System.out.println("RCV FILE 4");

					this.socketPort = inPacket.getPort();
					System.out.println("RCV FILE 5");

						System.out.println("4");
					if(inPacket.getAddress().getHostAddress().matches(User.setIPAddr().getHostAddress())== false) {
						String message = new String(inPacket.getData(), 0, inPacket.getLength());
							System.out.println("5 : " + User.setIPAddr().getHostAddress() + " "+ inPacket.getAddress().getHostAddress());	
							BufferedWriter fp = new BufferedWriter(new FileWriter(this.FILE_NAME,true));  
							 fp.append(message);
							 fp.append("\n");	
						}
					}
				
	        }catch ( IOException e) {
				System.out.println("Something went wrong in the server side. RCV_UDP");
			}   
	        }	        	/*
	        	ServerSocket servSock = new ServerSocket(this.port);    
	          while(this.local.getEtat().equals("CONNECTED")){
	                Socket link = servSock.accept();
	                
	                InputStream in = link.getInputStream();
			        DataInputStream dis = new DataInputStream(in);
			        try {
			        FileInputStream fis = new FileInputStream(this.FILE_NAME);
			        ObjectInputStream ois = new ObjectInputStream(fis);
			            rec = (File) ois.readObject();
			            ois.close();
			        } catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}      
	          }     
	          
	      	//servSock.close();
	        //link.close();
	        } catch (IOException e) {
				e.printStackTrace();
			 }
			 
	        }
	        
}
*/
