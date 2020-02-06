/*
 * Nom de classe : FenetreDiscussion.java
 *
 * Description   : Permet d'ouvrir une Fenetre de discussion avec un utilisateurs qu'on a choisi ou qui nous a envoye une demande 
 *
 * Version       : finale
 *
 * Date          : 05/02/2020
 * 
 */

package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JLabel;

import controller.Send;
import model.Message;
import model.MyBdd;
import model.User;

@SuppressWarnings("serial")
public class FenetreDiscussion extends javax.swing.JFrame implements ActionListener, KeyListener {
	
	//Variables 
	
    private javax.swing.JButton AccepterInvit;
    private javax.swing.JButton Piecejointe;
    private javax.swing.JTextField SaisiMessage;
    private javax.swing.JButton cacher;
    private javax.swing.JButton envoyerInvit;
    private javax.swing.JButton historique;
    private static javax.swing.JLabel message1;
    private static javax.swing.JLabel message2;
    private static javax.swing.JLabel message3;
    private static javax.swing.JLabel message4;
    private static javax.swing.JLabel message5;
    private static javax.swing.JLabel message6;
    private static javax.swing.JLabel message7;
    private static javax.swing.JLabel message8;
    private static javax.swing.JLabel message9;
    private static javax.swing.JLabel message10;
    private static javax.swing.JLabel message11;
    private static javax.swing.JLabel message12;
    private static javax.swing.JLabel message13;
    private static javax.swing.JLabel message14;
    private static javax.swing.JLabel message15;
    private static javax.swing.JLabel message16;
    private static javax.swing.JLabel message17;
    private static javax.swing.JLabel message18;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton quit;
    private static User distant;
    private static ArrayList<String> msg;
    private static ArrayList<JLabel> mes;
    
    //Constructeur
 
    public FenetreDiscussion(User distant) {
        FenetreDiscussion.distant = distant;
        initialisation();
    }
    
    //Initialisation 
    
    private void initialisation() {
    	this.setTitle("Fenetre de discussion : "+distant.getPseudo());
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        SaisiMessage = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        message1 = new javax.swing.JLabel();
        message11 = new javax.swing.JLabel();
        message12 = new javax.swing.JLabel();
        message18 = new javax.swing.JLabel();
        message13 = new javax.swing.JLabel();
        message14 = new javax.swing.JLabel();
        message15 = new javax.swing.JLabel();
        message16 = new javax.swing.JLabel();
        message17 = new javax.swing.JLabel();
        message2 = new javax.swing.JLabel();
        message3 = new javax.swing.JLabel();
        message4 = new javax.swing.JLabel();
        message5 = new javax.swing.JLabel();
        message6 = new javax.swing.JLabel();
        message7 = new javax.swing.JLabel();
        message8 = new javax.swing.JLabel();
        message9 = new javax.swing.JLabel();
        message10 = new javax.swing.JLabel();
        Piecejointe = new javax.swing.JButton();
        historique = new javax.swing.JButton();
        cacher = new javax.swing.JButton();
        quit = new javax.swing.JButton();
        msg = new ArrayList<String>();
        mes = new ArrayList<JLabel>();
        AccepterInvit = new javax.swing.JButton();
        envoyerInvit = new javax.swing.JButton();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        SaisiMessage.setColumns(20);
        SaisiMessage.setAutoscrolls(true);
        jScrollPane1.setViewportView(SaisiMessage);

        message1.setText("");
        mes.add(message1);

        message2.setText("");
        mes.add(message2);

        message3.setText("");
        mes.add(message3);

        message4.setText("");
        mes.add(message4);

        message5.setText("");
        mes.add(message5);

        message6.setText("");
        mes.add(message6);

        message7.setText("");
        mes.add(message7);

        message8.setText("");
        mes.add(message8);

        message9.setText("");
        mes.add(message9);

        message10.setText("");
        mes.add(message10);

        message11.setText("");
        mes.add(message11);
        
        message12.setText("");
        mes.add(message12);

        message13.setText("");
        mes.add(message13);

        message14.setText("");
        mes.add(message14);
        
        message15.setText("");
        mes.add(message15);

        message16.setText("");
        mes.add(message16);

        message17.setText("");
        mes.add(message17);

        message18.setText("");
        mes.add(message18);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(message1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(message2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(message3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(message4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(message5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(message6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(message7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(message8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(message9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(message10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(message11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(message12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(message13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(message14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(message15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(message16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(message17, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                .addGap(354, 354, 354))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(message18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(message1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(message2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(message3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(message4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(message5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(message6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(message7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(message8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(message9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(message10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(message11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(message12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(message13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(message14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(message15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(message16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(message17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(message18))
        );

        Piecejointe.setText("Piece jointe");

        historique.setText("Historique");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Piecejointe, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(historique, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(48, 48, 48))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(historique)
                        .addGap(28, 28, 28)
                        .addComponent(Piecejointe)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        
        SaisiMessage.setText("Saisir un message");
        SaisiMessage.addActionListener(this);

        historique.setText("Historique");
        historique.addActionListener(this);

        Piecejointe.addActionListener(this);

        AccepterInvit.setText("Accepter invitation");
        AccepterInvit.addActionListener(this);

        envoyerInvit.setText("Envoyer une invitation");
        envoyerInvit.addActionListener(this);
        
        quit.setText("Quitter la discussion");
        quit.addActionListener(this);
        
        cacher.setText("cacher");
        cacher.addActionListener(this);

        AccepterInvit.setText("Accepter l'invitation");

        

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(quit, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AccepterInvit, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(envoyerInvit, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 120, Short.MAX_VALUE)
                .addComponent(cacher))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(quit)
                    .addComponent(AccepterInvit)
                    .addComponent(envoyerInvit)
                    .addComponent(cacher))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        setVisible(true);
        pack();
    }

    //Methodes
    
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if(source.equals(historique)) {
			new HistoriqueView(distant);
		}
		
		if(source.equals(Piecejointe)) {
			//TODO
		}
		
		if(source.equals(cacher)) {
			this.dispose();
			this.setVisible(false);	
		}
		
		if(source.equals(AccepterInvit)) {	// Accepter une invitation	
			for(int i = 0; i< Profile.localUser.getActiveUsers().size(); i++) {
				try {
					Send.sendMessageTCP(distant.getId(), Profile.localUser, distant, new Message("I", Profile.localUser, distant, "La connexion est etablie"));
				} catch (SQLException e1) {
					System.out.println("SQL EXCEPTION Fenetre 1");
				}
			}
		}
			
		if(source.equals(SaisiMessage)) {
			saisirMessage();
		}
		
		if(source.equals(envoyerInvit)) { // envoyer une invitation
			String distantPseudo = distant.getPseudo();
			int indice =0;
			for(int i = 0; i< Profile.localUser.getActiveUsers().size(); i++) {
				indice = i;
				if(distantPseudo.equals(Profile.localUser.getActiveUsers().get(i).getPseudo())) {
					Message alerte = new Message("D", Profile.localUser, Profile.localUser.getActiveUsers().get(indice), "UD= "+Profile.localUser.getPseudo()+ " Id= "+ Profile.localUser.getId()+" IP= "+Profile.localUser.getIPAddr().getHostAddress());
					Send.sendMessageUDP(alerte, Profile.localUser.getActiveUsers().get(indice));
				}
			}	
		}
		
		if(source.equals(quit)) {// previent l'user distant qu'on a mis fin a la session de Chat	
			
			msg.add("Fin de la conversation avec "+distant.getPseudo()+"    "+Message.horodatage());
			Interfacee1.ecran.setToolTipText("Fin de la conversation avec "+distant.getPseudo());
			try {
				Send.sendMessageTCP(distant.getId(), Profile.localUser,  distant, new Message("F", Profile.localUser, distant, "FIN")); // ajouter toMessageTCP le F
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e1) {
					System.out.println("ERREUR FIN CONVERSATION");
				}
				for(int i =0; i<Interfacee1.listeDiscussion.size(); i++) {
					Interfacee1.listeDiscussion.get(i).cacher.doClick();
				}
			} catch (SQLException e1) {
				System.out.println("SQL EXCEPTION Fenetre QUIT");
			}
			setVisible(false);
	    	dispose();
		}
		
    }
    
    public static void affichage() {  // appelee a chaque envoi ou reception de message pour actualiser les messages affiches 	 
    	
    for(int j = 0; j<msg.size(); j++) {
    	
    	if(message18.getText().equals("")){
     		message1.setText("");
    		message18.setText(msg.get(j));
    	}
    	
    	else if(message17.getText().equals("")) {
     		message18.setText("");
    		message17.setText(msg.get(j));
    	}
    	
    	else if(message16.getText().equals("")){
     		message17.setText("");
    		message16.setText(msg.get(j));
    	}
    	
    	else if(message15.getText().equals("")) {
     		message16.setText("");
    		message15.setText(msg.get(j));
    	}
    	
    	else if(message14.getText().equals("")){
     		message15.setText("");
    		message14.setText(msg.get(j));
    	}
    	
    	else if(message13.getText().equals("")) {
     		message14.setText("");
    		message13.setText(msg.get(j));
    	}
    
      	else if(message12.getText().equals("")){
    		message13.setText("");
    		message12.setText(msg.get(j));
    	}
    	
      	else if(message11.getText().equals("")) {
    		message12.setText("");
    		message11.setText(msg.get(j));
    	}
    	
    	else if(message10.getText().equals("")){
    		message11.setText("");
    		message10.setText(msg.get(j));
    	}
    	
    	else if(message9.getText().equals("")) {
     		message10.setText("");
    		message9.setText(msg.get(j));
    	}
    	
    	else if(message8.getText().equals("")){
    		message9.setText("");
    		message8.setText(msg.get(j));
    	}
    	
    	else if(message7.getText().equals("")) {
    		message8.setText("");
    		message7.setText(msg.get(j));
    	}
    	
    	else if(message6.getText().equals("")){
    		message7.setText("");
    		message6.setText(msg.get(j));
    	}
    
      	else if(message5.getText().equals("") == true) {
    		message6.setText("");
    		message5.setText(msg.get(j));
    	}   
    	
    	else if(message4.getText().equals("") == true){
    		message5.setText("");
    		message4.setText(msg.get(j));
    	}   
  	
    	else if(message3.getText().equals("")  == true) {
    		message4.setText("");
    		message3.setText(msg.get(j));
    	}  
    	
     	else if(message2.getText().equals("") == true){
    		message3.setText("");
    		message2.setText(msg.get(j));
    	}   
    	
     	else if(message1.getText().equals("") == true) {
    		message2.setText("");
    		message1.setText(msg.get(j));
    	}    	   	
    	
    	else {
    		/*
    		message1.setText("");
      		message2.setText("");
    		message3.setText("");
    		message4.setText("");
    		message5.setText("");
    		message6.setText("");
    		message7.setText("");
    		message8.setText("");
    		message9.setText("");
    		message10.setText("");
    		message11.setText("");
    		message12.setText("");
    		message13.setText("");
    		message14.setText("");
    		message15.setText("");
    		message16.setText("");
    		message17.setText("");
    		message18.setText("");
    		
    		
        	message1.setText(message2.getText());
        	message2.setText(message3.getText());
        	message3.setText(message4.getText());
        	message4.setText(message5.getText());
        	message5.setText(message6.getText());
        	message6.setText(message7.getText());
        	message7.setText(message8.getText());
        	message8.setText(message9.getText());
        	message9.setText(message10.getText());
        	message10.setText(message11.getText());
        	message11.setText(message12.getText());
        	message12.setText(message13.getText());
        	message13.setText(message14.getText());
        	message14.setText(message15.getText());
        	message15.setText(message16.getText());
        	message16.setText(message17.getText());
        	message17.setText(message18.getText());
        	message18.setText(msg.get(msg.size()));
        	*/
        	
        	/*
    		message1.setText("");
    		for(int i =1; i<(mes.size()-1); i++) {
    			System.out.println(mes.get(i-1).getText());
        		mes.get(i).setText(mes.get(i-1).getText());
    		}	
    		message18.setText("");
    		
    		if(msg.size() >= mes.size()) {
        		int sup = msg.size() - mes.size();
        		for(int i =0; i< sup; i++) {
        			msg.remove(i);
        		}
    	}
    	*/
    		affichage();
    	}
    	
    	}
    	
    	/*
    	if(msg.size()<mes.size()) {
    		for(int i=0; i<msg.size(); i++) {
    			for(int j =0; j<msg.size(); j++) {
    				mes.get(j).setText(msg.get(i));
    			}
    		}
    	}
    	
    	}
    	
    	for(int i =0; i<msg.size(); i++) {
    		 for(int j = (mes.size()-1); j>0; j--) {
    			 mes.get(1).setText("Bonjour");
				 mes.get(2).setText("Ca va ?");
				 mes.get(3).setText("Oui et toi ?");
				 
    				 mes.get(j).setText(msg.get(i));
    				
    				 /*
	    			 if(mes.get(0).equals("")) {
	    				JLabel inter = mes.get(j-1);
	    				mes.get(j).setText(inter.getText());
	    				}
	    				
    		 }
    	 }
    	**/
    }
    
    public static void receptionAffichage(Message recu) {
    	if(recu.getUserDistant().getId() == distant.getId() || recu.getUserLocal().getId() == distant.getId()) {
    		if(recu.getType().equals("F")) {
    			msg.add(distant.getPseudo()+" a quitté la conversation");
    			Interfacee1.ecran.setToolTipText(distant.getPseudo()+" a quitté la conversation");
    			try {
					Thread.sleep(2000);
					for(int i =0; i<Interfacee1.listeDiscussion.size(); i++) {
						Interfacee1.listeDiscussion.get(i).cacher.doClick();
					}
				} catch (InterruptedException e) {
					System.out.println("ERREUR Fenetre SLEEP");
				}
    		}
    		else {
    			String ret = "FROM "+recu.getUserDistant().getPseudo()+ " : "+recu.getMessage()+"    "+Message.horodatage();
    			System.out.println(ret);
				msg.add(ret);
				System.out.println(mes.get(0));
				for(int i = 0; i< msg.size(); i++) {
					System.out.println(msg.get(i));
				}
				affichage();
    		}	
    	}
    }
    
    public void saisirMessage() {
    	String txt;
    	Message rec;
    	
    	txt = SaisiMessage.getText();
    	
    	rec = new Message("I", Profile.localUser, distant, txt);
    	if(distant.getPseudo().equals(rec.getUserDistant().getPseudo())) {
			if(User.sessionExists(Profile.localUser, distant)) {
				for(int j = 0; j<Profile.localUser.getChatSessions().size(); j++) {
					if(Profile.localUser.getChatSessions().get(j).getDistantUser().getPseudo().equals(distant.getPseudo())) {
						Profile.localUser.getChatSessions().get(j).setMessageHistory(rec);
						try {
							MyBdd.InsertMessage(distant, Profile.localUser, rec);
						} catch (SQLException e1) {
							System.out.println("SQL EXCEPTION VIEW Fenetre DISCUSSION KEY 1 ");
						}
						String cc = "FROM "+Profile.localUser.getPseudo() + " : "+rec.getMessage()+"    "+Message.horodatage();
						msg.add(cc);
						affichage();
					}
				}
			}
			else {
				User.setChatSession(Profile.localUser, distant);
				for(int j = 0; j<Profile.localUser.getChatSessions().size(); j++) {
					System.out.println("ICI");
					if(Profile.localUser.getChatSessions().get(j).getDistantUser().getPseudo().equals(Profile.localUser.getActiveUsers().get(j).getPseudo())) {
						Profile.localUser.getChatSessions().get(j).setMessageHistory(rec);
						try {
							MyBdd.InsertMessage (Profile.localUser.getChatSessions().get(j).getDistantUser(),Profile.localUser, rec);
						} catch (SQLException e1) {
							System.out.println("SQL EXCEPTION VIEW Fenetre DISCUSSION KEY 2 ");
						}
						String cc = "FROM "+Profile.localUser.getPseudo() + " : "+rec.getMessage()+"    "+Message.horodatage();
						msg.add(cc);
						affichage();
					}
				}
			}
			try {
				Send.sendMessageTCP(distant.getId(), Profile.localUser,  distant, rec);
			} catch (SQLException e1) {
				
			System.out.println("SQL EXCEPTION VIEW Fenetre DISCUSSION KEY 3");
			}
		}
    }
    
    public User getUserDistant() {
    	return distant;
    }
    
    public void changerF(String nouveau) {
    	this.setTitle("Fenetre de discussion: "+distant.getPseudo());

    }

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		Object source = e.getSource();
		
		if(source.equals(SaisiMessage)) {
			saisirMessage();
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
               
}
