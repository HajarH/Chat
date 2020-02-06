/*
 * Nom de classe : ChatSession
 *
 * Description   : Permettait au depart de connaitre les sessions en cours de l'utilisateur local 
 * 				   Certaines methodes sont maintenant obsoletes depuis l'utilisation d'une inetrface graphique 
 * 
 * Version       : finale
 *
 * Date          : 05/02/2020
 * 
 */


package model;
import java.net.*;

public class ChatSession {
	
	//Variables 
	
	private User localUser;
	private User distantUser;
	private InetAddress localIPAddr;
	private InetAddress distantIPAddr;
	private int port; 
	private History history;
	
	//Constructeur 
	
	public ChatSession(User localUser, User distantUser) {
		this.localUser = localUser;
		this.distantUser = distantUser;
		this.localIPAddr = localUser.getIPAddr();
		this.distantIPAddr = distantUser.getIPAddr();
		this.port = this.distantUser.getId();
		this.history = new History(this.localUser, this.distantUser);
	}
	
	//Methodes 
	
	public User getLocalUser() { 
		
		return this.localUser;	
	} 
	
	
	public User getDistantUser() { 
		
		return this.distantUser; 
	} 

	
	public InetAddress getLocalIP() { 
		return this.localIPAddr; 
	} 
	
	
	public InetAddress getDistantIP() { 
		
		return this.distantIPAddr; 
	} 

	
	public int getPort() {
		
		return this.port;
	}
	
	
	public void setPort(int port) {
		
		this.port = port;
	}
	
	
	public void setMessageHistory(Message msg) {
		
		this.history. addMessageTo(msg);
	}
	
	
	public History getHistory() {
		
		return this.history;
	}
}
