/*
 * Nom de classe : Message
 *
 * Description   : Permet la gestion du format Message conversion en string ou en Message 
 *
 * Version       : finale
 *
 * Date          : 05/02/2020
 * 
 */

package model;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Message{
	
	//Variables 
	
	private String msg = null;
	private User pLocal = null;
	private User pDistant = null;
	private String type;
	private String hd; 
	
	//Constructeurs
	
	public Message() {
		
		this.hd = horodatage();
	}

	
	public Message(String typ) { //permet d'envoyer le B1bis // verifie l'unicité du pseudo lors d'une première connexion ou de l'identifiant
		
		this.type = typ;
		this.msg = " ";
	}
	
	
	public Message(String type, User pLocal, User pDistant, String msg) {
		
		this.pLocal = pLocal;
		this.pDistant = pDistant;
		this.type = type;
		this.msg = msg;
		this.hd = horodatage();
	}

	
	public Message(String type, User user, String msg) { // message construit quand on change de pseudo 
		
		if(user.getIPAddr() != User.setIPAddr()) { // signifie que l'user est distant
			
			this.pDistant = user;
		}
		else this.pLocal = user;		
		this.type = type;
		this.msg = msg;
		this.hd = horodatage();
	}
	
	
	public Message(String type, String pseudo, int Id) { //B1 = previent le reseau pour qu'il ajoute cet utilisateur
		
		this.type = type;
		this.msg = "P= "+pseudo+" "+"Id= "+Id+" "+"IP= "+User.setIPAddr().getHostAddress().toString();
		this.hd = horodatage();
	}

	// Methodes 
	
	public static String horodatage() { // permet l'horodatage des messages
		
		Date date = new Date(System.currentTimeMillis()); 
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");  
        String strDate = dateFormat.format(date);  
        
		return strDate;
	}
	
	public String toString() {
		
		String retour;
		
		if(this.type.equals("B1")==true || this.type.equals("B2")==true) {
			retour = "T= "+this.type+" "+this.msg+" "+"hd= "+this.hd;
		}
		else if(this.type.equals("D") == true) {
			retour = "T= "+this.type+" msg= "+this.msg+" hd= "+this.hd;
		}
		else if(this.type.equals("C")== true) {
			retour = "T= "+this.type+" "+this.msg+" "+"hd= "+this.hd;
		}
		else if(this.type.equals("B1bis")==true) {
			retour = "T= "+this.type;
		}
		else if(this.type.equals("I")==true) {			
			retour = "T= "+this.type+" IP= "+this.getUserDistant().getIPAddr().getHostAddress()+" msg= "+this.msg+" hd= "+this.hd;
		}
		else if(this.type.equals("F")==true) {			
			retour = "T= "+this.type+" IP= "+this.getUserDistant().getIPAddr().getHostAddress()+" msg= "+this.msg+" hd= "+this.hd;
		}
		else retour = "message="+this.msg+" hd= "+Message.horodatage();
		
		return retour;
	}
	
	//Permet la conversion des messages TCP en Message
	public static void toMessageTCP(Message msg, User local, String recu) {
		
		String typ = new String();
		InetAddress IPdistant = null;	
		String[] mots = recu.split(" ");
		typ = mots[1];
		if(typ.equals("I")) { // si on recoi un message via TCP
			String rec=" ";
			int indice = 0;
			int cnt = 4;
			
			try {
				IPdistant = InetAddress.getByName(mots[3]);
			}catch(IOException e) {
				e.printStackTrace();
			}
			for(int i = 0; i< local.getActiveUsers().size(); i++) {
				if(local.getActiveUsers().get(i).getIPAddr().getHostAddress() == IPdistant.getHostAddress()) {
					System.out.println(local.getActiveUsers().get(i).getPseudo());
					indice = i;
				}
			}
			while(mots[cnt].equals("hd=") == false) {
				rec = rec+mots[cnt]+" ";
				cnt ++;
			}
			msg.setType(typ);
			msg.setMessage(rec);
			msg.setUserDistant(local.getActiveUsers().get(indice));			
		}
		if(typ.equals("F")) { // si on recoi un message via TCP
			String rec=" ";
			int indice = 0;
			int cnt = 4;
			
			try {
				IPdistant = InetAddress.getByName(mots[3]);
			}catch(IOException e) {
				e.printStackTrace();
			}
			for(int i = 0; i< local.getActiveUsers().size(); i++) {
				if(local.getActiveUsers().get(i).getIPAddr().getHostAddress() == IPdistant.getHostAddress()) {
					System.out.println(local.getActiveUsers().get(i).getPseudo());
					indice = i;
				}
			}
			while(mots[cnt].equals("hd=") == false) {
				rec = rec+mots[cnt]+" ";
				cnt ++;
			}
			msg.setType(typ);
			msg.setMessage(rec);
			msg.setUserDistant(local.getActiveUsers().get(indice));			
		}
	}
	

//Converti le message recu sous forme de string en format Message
	public static Message toMessage(User local, String msg) {
		
		Message retour;
		String typ = new String();
		String distant= new String();
		InetAddress IPdistant = null;
		int idDistant = 0;		
		String[] mots = msg.split(" ");
		typ = mots[1];
		
		if(typ.equals("B1")) { // quand on recoi un message d'alerte
			
			typ = mots[1];
			distant = mots[3];
			idDistant = Integer.parseInt(mots[5]);
			System.out.println(idDistant);
			
			try {
				IPdistant = InetAddress.getByName(mots[7]);
				System.out.println(IPdistant);
				
			}catch(IOException e) {
				e.printStackTrace();
			}
			User dist = User.toUser(local, distant, idDistant, IPdistant);
			retour = new Message(typ, dist, " ");
		}
		
		else if(typ.equals("D")) { // pour informer de l'etablissement d'une session de chat : Notification
			
			User dist = new User();
			String txt=" ";
			typ = mots[1];
			distant = mots[4];
			idDistant = Integer.parseInt(mots[6]);
			try {
				System.out.println("TO MESSAGE "+ InetAddress.getByName(mots[8]));
				IPdistant = InetAddress.getByName(mots[8]);
			}catch(UnknownHostException e) {
				e.printStackTrace();
			}
	
			dist = User.toUser(local, distant, idDistant, null);
			retour = new Message(typ, dist, txt);
		}
		
		else if(typ.equals("B1bis")) {
			Message msgg = new Message();
			msgg.setType("B1bis");
			retour = msgg;
		}
		
		else if(typ.equals("C")) { // pour informer d'un changement de pseudo et changer le pseudo
			
			//mots[6] contient le nouveau pseudo / mot[4] contient l'adresse IP 
			try {
				IPdistant = InetAddress.getByName(mots[4]);
			} catch (UnknownHostException e1) {
				e1.printStackTrace();
			}
			typ = mots[1];
			distant = mots[6];
			
			for(int i =0; i< local.getActiveUsers().size(); i++) {
				if(local.getActiveUsers().get(i).getIPAddr().getHostAddress().equals(IPdistant.getHostAddress())) {
					local.getActiveUsers().get(i).setPseudo(distant);
				}
			}
			
			retour = new Message(typ, User.toUser(local, distant, 0, IPdistant), mots[5]);
		}
		
		User dist = User.toUser(local, distant, idDistant, IPdistant);
		retour = new Message(typ, dist, " ");
	
		return retour;
	}
		
	
	public String getMessage() {
		
		return this.msg;
	}
	
	
	public String getPseudoLocal() {
		
		return this.pLocal.getPseudo();
	}
	
	
	public User getUserDistant() {
		
		return this.pDistant;
	}
	
	
	public User getUserLocal() {
		
		return this.pLocal;
	}
	
	public String getPseudoDistant() {
		
		return this.pDistant.getPseudo();
	}
	
	
	public String getType() {
		
		return this.type;
	}
	
	
	public void setMessage(String txt) {
		
		this.msg = txt;
	}
	
	
	public void setUserLocal(User local) {
		
		this.pLocal = local;
	}
	
	
	public void setUserDistant(User distant) {
		
		this.pDistant = distant;
	}
	
	
	public void setType(String type) {
		
		this.type = type;
	}
	

}
