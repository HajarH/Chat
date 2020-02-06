/*
 * Nom de classe : User
 *
 * Description   : Classe User, regroupe toutes les methodes necessaires a la creation et la gestion d'un utilisateur
 *
 * Version       : finale
 *
 * Date          : 05/02/2020
 * 
 */

/***
 * @author hajar
 */

package model;

import java.io.IOException;
import java.net.*;
import java.util.*;
import controller.Send;
import java.nio.channels.UnresolvedAddressException;
import java.sql.SQLException;


public class User {
	
	//Attributs
	
	private static ArrayList<User> users = new ArrayList<User>(); // Liste d'utilisateurs
	private static ArrayList<User> activeUsers = new ArrayList<User>(); // Utilisateurs actifs
	private static ArrayList<ChatSession> chatSessions = new ArrayList<ChatSession>(); // Chat Sessions
	private String pseudo = " "; 
	private String etat = "CONNECTED";
	private int Id;
	private InetAddress IPAddr;
	
	//Constructeurs
	
	public User (String pseudo, int Id) {
		
		this.pseudo = pseudo;
		this.Id = Id;
		this.IPAddr = setIPAddr();
	}
	
	
	public User() {
		
	}
	
	//Methodes
	
	public String getPseudo() { 
		
		return this.pseudo; 
	} 
	
	
	public void setPseudo(String pseudo) { 
		
		this.pseudo = pseudo;
	}
	
	
	public int getId() { 
		
		return this.Id; 
	} 
	
	
	public void setId(int Id) {
		
		this.Id=Id;
	}
	
	
	public String toString() { 
		
		return "pseudo= "+this.pseudo+" Id= "+this.Id+" IP= "+this.IPAddr.getHostAddress().toString();
	}
	
	
// renvoi l'adresse IP de l'utilisateur Local/ sur sa machine 
	public static InetAddress setIPAddr() throws UnresolvedAddressException{
	        
	        ArrayList<InetAddress> ipBroadAddrs = new ArrayList<>();
	        ArrayList<InetAddress> ipHostAddrs = new ArrayList<>();
	        Enumeration<NetworkInterface> interfaces;
	        
	        try {
	        	
	            interfaces = NetworkInterface.getNetworkInterfaces();
	            while (interfaces.hasMoreElements()) {
	            	
	                NetworkInterface networkInterface = interfaces.nextElement();
	                
	                try {
	                	
	                    if (networkInterface.isLoopback())
	                        continue;
	                    
	                } catch (SocketException e) {
	                	
	                   System.out.println("SOCKET EXEPTION setIPAddr() 1");
	                }  
	                for (InterfaceAddress interfaceAddress : networkInterface.getInterfaceAddresses()) {
	                	
	                    InetAddress broadcast = interfaceAddress.getBroadcast();
	                    InetAddress host = interfaceAddress.getAddress();
	                    if (broadcast == null)
	                        continue;

	                    ipBroadAddrs.add(broadcast);
	                    ipHostAddrs.add(host);
	                }
	            }
	   
	        } catch (SocketException e1) {
	        	System.out.println("SOCKET EXEPTION setIPAddr() 2");
	        }
	        
	        if(ipHostAddrs.size() == 0) {
	        	
	            throw new UnresolvedAddressException();
	        }
	        
	        
	        ArrayList<InetAddress> res = new ArrayList<>();
	        res.add(ipHostAddrs.get(0));
	        res.add(ipBroadAddrs.get(0));
	        
	        return res.get(0);
	}
	
	
	public void setIPAddr(InetAddress IPAddr) { 
		
		this.IPAddr = IPAddr;
	}
	
	
	public InetAddress getIPAddr() { // permet de recuperer l'adresse IP
			return this.IPAddr;	
	}


	public void addActiveUser(User user) { // Ajoute un utilisateur a la liste des utilisateurs actifs 
		boolean ver = false;
		
		for(int i = 0; i< user.getActiveUsers().size(); i++) {
			
			if(user.getIPAddr().equals(this.getActiveUsers().get(i).getIPAddr()) == true) {
				
				ver = true;
			}
		}
		
		if(ver == false) {
			
			User.activeUsers.add(user); 
		}	
	} 
	
	
	public boolean equals(User use) { 
		
		boolean ret = false;
		
		if(this.getId() == use.getId() && this.getIPAddr().equals(use.getIPAddr())) {
			
			ret = true;
		}
		
		return ret;
	}	
	

	public static void disconnectUser(User local, User user) { // supprime l'utilisateur de la liste des activeUsers
		
		if(local.getActiveUsers().contains(user)) {
			
			local.getActiveUsers().remove(local.getActiveUsers().indexOf(user));
		}
	}

	
	public static boolean sessionExists(User localUser, User distantUser) { // Return true if the session exists
		
		boolean sessionFound = false;
		int i = 0;
		
		while ((sessionFound == false) && (i<localUser.getChatSessions().size())) {
			
			if((localUser.getChatSessions().get(i).getDistantUser() == distantUser)) {
				
				sessionFound = true;
			} 
			else {
				
				i++;
			}
		}
		
		return sessionFound;
	}
	
	
	public int getNbChatSessions() {
		
		return this.getChatSessions().size();
	}
	
	
	public ArrayList<User> getUsers(){ 
		
		return User.users;
	}
	
	
	public ArrayList<User> getActiveUsers(){
		
		return User.activeUsers;
	}
	
	
	public ArrayList<ChatSession> getChatSessions(){
		
		return User.chatSessions;
	}
	
	
	public void setUser(User user) { 
		
		for(int i =0; i<this.getActiveUsers().size(); i++) {
			
			if(this.getActiveUsers().get(i).getId()== user.getId() && this.getActiveUsers().get(i).getIPAddr() == user.getIPAddr()) {
				
				if(this.getActiveUsers().get(i).getPseudo() != user.getPseudo()) {
					
					this.getActiveUsers().get(i).setPseudo(user.getPseudo());
				}
			}
		}
	}
	
	
	public static void setChatSession(User local, User distant) {
		
		local.getChatSessions().add(new ChatSession(local, distant));
	}
	
	
	public void setEtat(String etat) { 
		
		this.etat = etat;
	}
	
	
	public String getEtat() { // permet de recuperer l'etat "CONNECTED" ou "DISCONNECTED" du user
		
		return this.etat;
	}
	
	
// verifie l'unicite de l'id dans la liste des users (qui ont repondu a temps a sa requette)
  	public static boolean isIdUniqueChange(User local, int id) throws SQLException { 
  	
  		if(local.getActiveUsers().size() == 0) {
  			
  			local.setId(id);
  			
  			return true;
  		}
  		
  		for(int i=0; i< local.getActiveUsers().size(); i++) {
  			
			if( local.getActiveUsers().get(i).getId() == id) {
				
				return false;
			}
		}
		local.setId(id);
	
		return true;
  	}
  	
  	
 // verifie l'unicité du pseudo dans la liste des users (qui on repondu a temps a sa requette) 
   	public static boolean isPseudoUnique(User local, String pseudo) { 
   		
   		if(local.getActiveUsers().size() == 0) {
   			
   			return true;
   		}
   		
 		for(int i=0; i< local.getActiveUsers().size(); i++) {
 			
 			if( local.getActiveUsers().get(i).getPseudo().equals(pseudo)) {
 				
 				return false;
 			}
 		}
 		
 		return true;
 	}
   	
   	
 //Cree un user en fonction des informations du message
  	public static User toUser(User local, String pseudo, int Id, InetAddress IPAddr) {
  		
  		boolean fait = false;
  		User dist = new User();
  		
  		for(int i =0; i< local.getActiveUsers().size(); i++) {
  			
  			if(local.getActiveUsers().get(i).getPseudo() == pseudo) {
  				
  				fait = true;
  				System.out.println("to user :" +local.getActiveUsers().get(i).getPseudo().toString());
  				
  				return local.getActiveUsers().get(i);
  			}
  		}
  		
  		if(fait == false) {
  			
  			dist.setPseudo(pseudo);
  			dist.setId(Id);
  			dist.setIPAddr(IPAddr);
  		}
  		
  		return dist;
  	}
  	
  	
 // Permet de generer un Id correspondant a un port libre sur lequel les utilisateurs pourront se connecter pour l'envoi de TCP
 	public static int genererID() {
 		
 		Random rand;
 		int Id = 0;
 		ServerSocket test ;
 		
 		do {
 			rand = new Random();
 			Id = rand.nextInt(65000) + 1;
 			
 			try {
 				test = new ServerSocket(Id);
 				test.close();
 				
 			}catch(IOException e) {
 				System.out.println("Id incorrect");
 			}
 			
 		}while(Id == 2510 || Id ==2520 || Id <1025 || Id == 0 );
 		
 		return Id;
 	}
 	
 	
//Change le pseudo de l'utilisateur passe en parametre: renvoi false en cas d'echec ou true sinon
	public static boolean changerPseudo(User localUser, String newP) {
		
		System.out.println("Nous allons changer votre pseudo");
		boolean retour = false;
		String pseudo = newP;
		
		if(isPseudoUnique(localUser, pseudo) == false) { // on verifie son unicite 
			
			System.out.println("Le pseudo saisi n'est pas unique. Resaisir un pseudo : ");
			
		}else {
			
			retour = true;
			localUser.setPseudo(pseudo);
			//alerte les autres utilisateurs
			Send.sendMessageUDP(new Message("C", localUser, " IP= "+ localUser.getIPAddr().getHostAddress().toString()+ " NEW= " + localUser.getPseudo())); // on previent le reseau du changement de pseudo
		}
		
		return retour;
	}
  	
	
}