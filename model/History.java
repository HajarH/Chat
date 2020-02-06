/*
 * Nom de classe : History
 *
 * Description   : permet la gestion de l'historique en local
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
import java.util.*;

public class History {
	
	//Variables 
	
	private User localUser;
	private User distantUser;
	private ArrayList<Message> history;
	
	//Constructeur 
	
	public History ( User localUser,User distantUser) {
		this.distantUser = distantUser;
		this.localUser = localUser;
		this.history = new ArrayList<Message>();
	}
	
	//Methodes
	
	public User getLocalUser() { 
		
		return this.localUser;	
	} 
	
	
	public User getDistantUser() { 
		
		return this.distantUser; 
	} 
	
	
	public ArrayList<Message> returnHistory() { 
		
		return this.history;
	}
	
	
	public void addMessageTo(Message msg) { 
		
		this.history.add(msg);
	}
	
	
	
}