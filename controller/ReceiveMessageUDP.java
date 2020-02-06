/*
 * Nom de classe : receiveMessageUDP
 *
 * Description   : Permet la reception des messages UDP
 *
 * Version       : finale
 *
 * Date          : 05/02/2020
 * 
 */

package controller;

import java.net.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

import model.Message;
import model.MyBdd;
import model.User;
import view.FenetreDiscussion;
import view.Interfacee1;
import view.Profile;

import java.io.*;


public class ReceiveMessageUDP extends Thread{
	
	// Attributes 
	
	private int socketPort = 2521;// port d'eccoute broadcast
	private User localUser=null;
	private LinkedBlockingQueue<DatagramPacket> lbq ;
	private LinkedBlockingQueue<String> bufTCP ;
	
	//Constructeurs 
	
    public ReceiveMessageUDP(LinkedBlockingQueue<DatagramPacket> lbq, LinkedBlockingQueue<String> bufTCP ) {
    	
    	this.lbq = lbq;
    	this.bufTCP = bufTCP;
    	this.start();
    }
    
    
	public ReceiveMessageUDP(LinkedBlockingQueue<String> bufTCP, LinkedBlockingQueue<DatagramPacket> lbq, User us){
		
		this.localUser = us;
		this.lbq = lbq;
    	this.bufTCP = bufTCP;
		this.start();
	}
	
	//Methodes
	
	public void run(){	

		try {				
			DatagramSocket socketUDP = new DatagramSocket(socketPort);
			
			while(this.localUser.getEtat().equals("CONNECTED")) {
				
				byte[] buffer = new byte[100000];
				DatagramPacket inPacket = new DatagramPacket(buffer, buffer.length);
				socketUDP.receive(inPacket);
				socketPort = inPacket.getPort();
				if(inPacket.getAddress().getHostAddress().matches(User.setIPAddr().getHostAddress())== false) {
					System.out.println("1");
					traiteUDPMessageBis(this.bufTCP, inPacket, this.lbq, this.localUser);
					System.out.println("2");
					String message = new String(inPacket.getData(), 0, inPacket.getLength());
					System.out.println(message);
					System.out.println("Recu UDP: " +message); 
				}
			}
			
			socketUDP.close();
			
		} catch ( IOException e) {
			System.out.println("ERREUR RCV_UDP");
			
		} catch (SQLException e) {
			System.out.printf("ERREUR SQL RCV UDP");
		}
	}
	
	//Traite les messages UD recus
	public static void traiteUDPMessageBis(LinkedBlockingQueue<String> buf, DatagramPacket unite, LinkedBlockingQueue<DatagramPacket> lbq, User localUser) throws SQLException {
		
		ArrayList<Message> tab = new ArrayList<Message>();
		boolean test = false;
		// On recupere les datagrammes reçus et on les met sous format message pour les exploiter par la suite
				
				for(int i = 0; i<localUser.getActiveUsers().size(); i++) {
				
					if(unite.getAddress().getHostAddress().matches(localUser.getActiveUsers().get(i).getIPAddr().getHostAddress()) == false) {
						
						test = true;
					}
				}
				
				if(test == false) {
					
					try {
						lbq.put(unite); // verifier 
					}catch(InterruptedException e) {
						System.out.println("InterruptedException TRT UDP");
					}
					
		      		String ms = new String(unite.getData(), 0, unite.getLength());
		      		Message rec = Message.toMessage(localUser, ms);
		      		tab.add(rec);
				}
				
				for(int i = 0; i< tab.size(); i ++) {
					if(tab.get(i).getType().equals("B1bis") == true ) {
						System.out.println("REPONSE B1bis");
						Send.sendMessageUDP(new Message("B1", localUser.getPseudo(), localUser.getId())); // On lui repond en donnant notre identite			  
					}     
					
					if(tab.get(i).getType().equals("B1") == true) { // on recoit ce message lorsqu'un utilisateur vient d'arriver sur le reseau 
						
						for(int j = 0; j < localUser.getActiveUsers().size(); j++) {
							
							if(localUser.getActiveUsers().get(i).getIPAddr().getHostAddress().equals(tab.get(i).getUserDistant().getIPAddr().getHostAddress())) {
								
								localUser.getActiveUsers().get(i).setPseudo(tab.get(i).getUserDistant().getPseudo());
								test = true;
							}
						}
						
						if(test == false) {
							
							User dist = new User();
							dist.setEtat("CONNECTED");
							dist.setId(tab.get(i).getUserDistant().getId());
							dist.setPseudo(tab.get(i).getUserDistant().getPseudo());
							dist.setIPAddr(tab.get(i).getUserDistant().getIPAddr());	  		
							MyBdd.Insert_new_User(dist); // insertion de l'utilisateur dans la base de données
							localUser.addActiveUser(dist);
							localUser.setUser(dist);
						}
						
						tab.remove(i);
					}
  			 
  		  

					else if(tab.get(i).getType().equals("C") == true ) { // on recoi ce message quand un utlisateur a change de pseudo
					
						for(int j = 0; j< Profile.localUser.getActiveUsers().size(); j ++) {
							String old = new String();
							old = Profile.localUser.getActiveUsers().get(i).getPseudo();
							if(tab.get(i).getUserDistant().getIPAddr().equals(Profile.localUser.getActiveUsers().get(j).getIPAddr())== true) {
			
								old = Profile.localUser.getActiveUsers().get(j).getPseudo();
								Profile.localUser.getActiveUsers().get(j).setPseudo(tab.get(i).getUserDistant().getPseudo());
								view.Liste.changeElement(Profile.localUser.getActiveUsers().get(j), old) ;
								
								tab.remove(i);
							}
						}
					}
  		  
					else if(tab.get(i).getType().equals("D") == true) {
				
						int indice = 0;
  	
						for(int j = 0; j< localUser.getActiveUsers().size(); j++) {
  				  
							//System.out.println(localUser.getActiveUsers().get(j).getIPAddr().getHostAddress());
							//System.out.println(tab.get(i).getUserDistant().getIPAddr());
							if(localUser.getActiveUsers().get(j).getIPAddr().getHostAddress().matches(tab.get(i).getUserDistant().getIPAddr().getHostAddress())) {
								indice = j;
								System.out.println(localUser.getActiveUsers().get(indice).getPseudo());
								System.out.println("Saisir I: suivi du nom de l'utilisateur pour accepter l'invitation");
								Interfacee1.listeDiscussion.add(new FenetreDiscussion(localUser.getActiveUsers().get(indice)));
							}
						}        	
					}

				}
		}
	}
