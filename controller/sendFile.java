/*
 * Nom de classe : SendFile
 *
 * Description   : Permet d'envoyer des fichier, non complet donc ne fonctionne pas
 *
 * Version       : final
 *
 * Date          : 05/02/2020
 * 
 */

package controller;

import java.io.IOException;
import java.io.Serializable;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import model.User;

@SuppressWarnings("serial")
public class sendFile extends Thread implements Serializable{
	
	//private String file; // chemin fichier
	private User dest; 
	private byte[] file;
	private User local;
	
	public sendFile (byte[] fl, User dst, User local) {
		this.file = fl;
		this.local = local;
		this.dest = dst;
		start();
	}

	public void run(){

		// sérialisation
		int port1 = this.local.getId()+1;
		int port2 =  this.dest.getId()+1;
		 	int socketPort = port1; // port par defaut depuis lequel on envoi tout le temps et sur lequel on envoi tous les UDP
	        int serverPort = port2; // port par defaut sur lequel on ecoute tout le temps et sur lequel on envoi tous les UDP
	       // byte[] message;
	        //boolean test = false;
	        InetAddress serverIPAddr = null; // distant
	        serverIPAddr = this.dest.getIPAddr();
	    
	        try {
	       	 DatagramSocket socketUDP = new DatagramSocket(socketPort);
	       	 DatagramPacket outPacket = new DatagramPacket(this.file, this.file.length,serverIPAddr,serverPort);			
				 //On envoi le datagram
	       	 socketUDP.send(outPacket);
	       	 System.out.println("Fichier envoye UDP:"+this.file.toString());
				 // On ferme le socket
	       	 socketUDP.close();

	        } catch (IOException e) {
	       	 System.out.println("Something went wrong in the client side : UDP");
	        }
	        /*
		      try {
		         FileOutputStream fs = new FileOutputStream(FILE_NAME);
		         os = new ObjectOutputStream(fs);
		         os.writeObject(me); // 3
		         os.close();
		         System.out.println(os);
		        int port = dest.getId()+1;
		        System.out.println(port);
		         Socket sockCli = new Socket(dest.getIPAddr().getHostAddress().toString(), port); // port sur lequel on envoi des fichier ID +1
	        	PrintWriter out;
	            out = new  PrintWriter(sockCli.getOutputStream(), true);
	            out.println(os);
	            System.out.println("Envoi tcp " + os);
	            sockCli.close();
		      } catch (Exception e) { 
		         e.printStackTrace(); 
		      }
		      */
  	}

}
