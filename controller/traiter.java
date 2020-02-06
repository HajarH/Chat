/*
 * Nom de classe : Traiter
 *
 * Description   : permet le traitement de chaque message TCP recu 
 *
 * Version       : finale
 *
 * Date          : 05/02/2020
 * 
 */

package controller;

import java.lang.System;
import java.sql.SQLException;
import java.util.concurrent.LinkedBlockingQueue;
import model.Message;
import model.MyBdd;
import model.User;
import view.FenetreDiscussion;


class Traiter extends Thread{
	
	//Attributs
	
	private String unite;
	private User local;
    private LinkedBlockingQueue<String> bufTCP;
    boolean running = true;
    
    //Constructeur
    
    public Traiter(String u, User l, LinkedBlockingQueue<String> buf) {
    	this.unite = u;
    	this.local = l;
    	this.bufTCP = buf;
    	start();
    }
    
    //Methodes 
    
    public void run() {
    	
    	while(running) {
    		
        	try {
        		
				running = traiterMessageTCP();
			} catch (SQLException e) {
				e.printStackTrace();
			}
    	}
    	
    	System.out.println("FIN TRAITEMENT");
    }
    
   
    
    public boolean traiterMessageTCP() throws SQLException {
    	
    	int indice = 0;
    	try {
    		
    		this.bufTCP.put(this.unite);
			System.out.println("Message TCP recu "+" "+this.unite);
			Message rec = new Message();
			Message.toMessageTCP(rec, this.local, this.bufTCP.take());
			
    	   	for(int i = 0; i < this.local.getActiveUsers().size(); i++) {
    	   		
        		if(this.local.getActiveUsers().get(i).getPseudo().equals(rec.getUserDistant().getPseudo())) {
        			
        			indice = i;
        			if(User.sessionExists(this.local, this.local.getActiveUsers().get(i))) {
        				
        				for(int j = 0; j<this.local.getChatSessions().size(); j++) {
        					
        					if(this.local.getChatSessions().get(i).getDistantUser().getPseudo().equals(this.local.getActiveUsers().get(i).getPseudo())) {
        						
        						this.local.getChatSessions().get(i).setMessageHistory(rec);
        						MyBdd.InsertMessage (this.local, this.local.getActiveUsers().get(i),rec);
        						FenetreDiscussion.receptionAffichage(rec);
        					}
        				}
        			}
        			
        			else {
        				
        				User.setChatSession(this.local, this.local.getActiveUsers().get(indice));
        				for(int j = 0; j<this.local.getChatSessions().size(); j++) {
        					
        					if(this.local.getChatSessions().get(i).getDistantUser().getPseudo().equals(this.local.getActiveUsers().get(i).getPseudo())) {
        						
        						this.local.getChatSessions().get(i).setMessageHistory(rec);
        						MyBdd.InsertMessage(this.local, this.local.getActiveUsers().get(i),rec);
        						FenetreDiscussion.receptionAffichage(rec);
        					}
        				}
        			}
        		}		
    	   	}
		}catch(InterruptedException i) {
			i.printStackTrace();
		}
    	
    	return false;
    }
	
	
}
