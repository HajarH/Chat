/*
 * Nom de classe : Send
 *
 * Description   : Regroupe differentes methodes permettant l'envoi via TCP ou UDP avec un format de message different
 * 				   selon la situation: String, Message, ... 
 * 				   Contient egalement des methodes tel que broadcast(), necessaires a l'envoi de messages
 *
 * Version       : finale
 *
 * Date          : 05/02/2020
 * 
 */

package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.System;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.Socket;
import java.net.SocketException;
import java.sql.SQLException;
import java.util.Enumeration;

import model.Message;
import model.User;

public class Send{
	
	//Methodes
	
// Renvoi l'addresse de broadcast du réseau 
    public static InetAddress broadcast() {
    	
    	InetAddress broad = null;
    	
    	try{
    		Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
    		
    		while (interfaces.hasMoreElements()){
    			
    			NetworkInterface networkInterface = interfaces.nextElement();
    			
                if (networkInterface.isLoopback())
                	continue;    // On n'utilise pas le loopback
                
                for (InterfaceAddress interfaceAddress : networkInterface.getInterfaceAddresses()){
                	
                	InetAddress broadcast = interfaceAddress.getBroadcast();
                	
                	if (broadcast == null)
                		continue;
                	
                	broad = broadcast;
                }
    		}
    		
    	}catch(SocketException e){
    		System.out.println("ERROR SEND BROADCAST");
    	}
    	
    	return broad;
    }
    
    
//Envoi d'un message avec UDP: sous format String 
    public static void sendMessageUDP(String msg) { // Broadcast lors de l'arrivee sur le reseau Pour verifier l'unicite du pseudo et de l'id ou quand on a change de pseudo ou quand on met fin a la session
    	
    	int socketPort = 2511; // port par defaut depuis lequel on envoi tout le temps et sur lequel on envoi tous les UDP
        int serverPort = 2521; // port par defaut sur lequel on ecoute tout le temps et sur lequel on envoi tous les UDP
        byte[] message;
        InetAddress serverIPAddr = null; // distant
        serverIPAddr = broadcast();
        message = new byte[msg.length()];
        message = msg.getBytes();
        
        try {
        	
        	DatagramSocket socketUDP = new DatagramSocket(socketPort);
        	DatagramPacket outPacket = new DatagramPacket(message, message.length,serverIPAddr,serverPort);        
            socketUDP.send(outPacket); 
            System.out.println("Envoi UDP:"+message.toString());
            socketUDP.close();
            
        } catch (IOException e) {
            System.out.println("ERROR SEND SEND_UDP STRING");
        }
    }
    
    
 //Notification envoyee pour prevenir l'etablissement de connexion : particularite = envoye au destinataire concerne 
    public static void sendMessageUDP(Message msg, User distant) {
    	
        int socketPort = 2511; // port par defaut depuis lequel on envoi tout le temps et sur lequel on envoi tous les UDP
        int serverPort = 2521; // port par defaut sur lequel on ecoute tout le temps et sur lequel on envoi tous les UDP
        byte[] message;
        InetAddress serverIPAddr = null; // distant
        serverIPAddr = distant.getIPAddr();
        String mesg= msg.toString();
        message = new byte[mesg.length()];
        message = mesg.getBytes();
    
        try {
        	DatagramSocket socketUDP = new DatagramSocket(socketPort);
       	 	DatagramPacket outPacket = new DatagramPacket(message, message.length,serverIPAddr,serverPort);			
       	 	socketUDP.send(outPacket);
       	 	System.out.println("message envoye UDP:"+msg.toString());
			socketUDP.close();

        } catch (IOException e) {
       	 System.out.println("ERROR SEND SEND_UDP MESSAGE USER");
        }  
   }
    
    
  //Envoi d'un message avec UDP: sous format Message 
    public static void sendMessageUDP(Message msg) {
    	
         int socketPort = 2511; // port par defaut depuis lequel on envoi tout le temps et sur lequel on envoi tous les UDP
         int serverPort = 2521; // port par defaut sur lequel on ecoute tout le temps et sur lequel on envoi tous les UDP
         byte[] message;
         InetAddress serverIPAddr = null; // distant
         serverIPAddr = broadcast();
         String mesg= msg.toString();
         message = new byte[mesg.length()];
         message = mesg.getBytes();
     
         try {
        	 
        	 DatagramSocket socketUDP = new DatagramSocket(socketPort);
        	 DatagramPacket outPacket = new DatagramPacket(message, message.length,serverIPAddr,serverPort);			
        	 socketUDP.send(outPacket);
        	 System.out.println("message envoye UDP:"+msg.toString());
        	 socketUDP.close();

         } catch (IOException e) {
           	 System.out.println("ERROR SEND SEND_UDP MESSAGE");
         }     
    }
   
    
//Envoi d'un message avec TCP
  	public static void sendMessageTCP(int port, User local, User distant, Message message) throws SQLException {
  		
  		try{
  			System.out.println(port);
  			System.out.println(distant.getIPAddr().getHostAddress());
  			Socket sockCli = new Socket(distant.getIPAddr(), port);
          	PrintWriter out;
            out = new  PrintWriter(sockCli.getOutputStream(), true);
            out.println( message.toString());
            System.out.println("Envoi tcp " + message);
            sockCli.close();
              
  		}catch(IOException e){
  			e.printStackTrace();
  			System.out.println("ERROR SEND SEND_TCP");
  		}
  	}
      
	
}
