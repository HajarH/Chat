/*
 * Nom de classe : Profile
 *
 * Description   : Correspond a la fenetre de connexion, ne permet l'ouverture du profil que si le pseudo est unique
 *
 * Version       : finale
 *
 * Date          : 05/02/2020
 * 
 */

package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.channels.UnresolvedAddressException;
import java.sql.SQLException;

import controller.Send;
import controller.ReceiveMessageUDP;
import model.Message;
import model.MyBdd;
import model.User;

@SuppressWarnings("serial")
public class Profile extends javax.swing.JFrame implements ActionListener {

	//Variables 
	
    private javax.swing.JLabel avoirUnCompte;
    private javax.swing.JButton bouttonCo;
    private javax.swing.JLabel isPseudoUnique;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel labelConnexion;
    private javax.swing.JTextField saisiePseudo;
	public static User localUser = new User();
  
	//Constructeur 
	
    public Profile() {
       initialiser();
    }
              
    //Initialiser 
    
    private void initialiser() {
    	this.setTitle("Connexion");
        jPanel1 = new javax.swing.JPanel();
        saisiePseudo = new javax.swing.JTextField();
        bouttonCo = new javax.swing.JButton();
        labelConnexion = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        isPseudoUnique = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        avoirUnCompte = new javax.swing.JLabel();
        
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        saisiePseudo.setText("");
        saisiePseudo.addActionListener(this);

        bouttonCo.setText("Se connecter");
        bouttonCo.addActionListener(this);

        labelConnexion.setText("Connexion");

        isPseudoUnique.setText("Pseudo unique:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(isPseudoUnique)
                .addGap(37, 37, 37)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(isPseudoUnique)
                    .addComponent(jLabel3))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(bouttonCo)
                .addGap(118, 118, 118))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(labelConnexion))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(saisiePseudo, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(68, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addComponent(labelConnexion)
                .addGap(44, 44, 44)
                .addComponent(saisiePseudo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(bouttonCo)
                .addGap(14, 14, 14)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        javax.swing.GroupLayout avoirUnCompteLayout = new javax.swing.GroupLayout(avoirUnCompte);
        avoirUnCompte.setLayout(avoirUnCompteLayout);
        avoirUnCompteLayout.setHorizontalGroup(
            avoirUnCompteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 254, Short.MAX_VALUE)
        );
        avoirUnCompteLayout.setVerticalGroup(
            avoirUnCompteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 27, Short.MAX_VALUE)
        );

        pack();
        setVisible(true);
    }                    

    //Methodes 
    
    private void methodeChanger() throws UnresolvedAddressException, SQLException, InterruptedException{         
    	
    	String pseudo = null;
    	pseudo = saisiePseudo.getText();
		localUser.setIPAddr(User.setIPAddr()); 
		localUser.setEtat("CONNECTED");
		
		if(MyBdd.CompteExistant(User.setIPAddr().getHostAddress())) {
			
			localUser.setIPAddr(User.setIPAddr());
			localUser.setId(MyBdd.getMonId(localUser));
			Thread.sleep(1500);
			
			if(pseudo.equals(" ") || pseudo.equals("\n") || pseudo.equals(null) || pseudo.equals("")) {
				isPseudoUnique.setText("Format de la saisie invalide");
			}
			else if(User.isPseudoUnique(localUser, pseudo) == false) {
				
				isPseudoUnique.setText("Le pseudo n'est pas unique, changez");
			}
			else {
				
				isPseudoUnique.setText("Pseudo valide");
				localUser.setPseudo(pseudo);
				Send.sendMessageUDP(new Message("B1",localUser.getPseudo(), localUser.getId()));
				new Interfacee1();
				Interfacee1.ecran.setText("Vous etes connecté");
				Thread.sleep(1000);
				dispose();
				setVisible(false);
			}			
		}		
		else {
			
			avoirUnCompte.setText("Creation d'un compte");
			int id ;
			Thread.sleep(1500);
			boolean test = false;
			
			while(test == false) {
				
				id = User.genererID();
				test = User.isIdUniqueChange(localUser, id);
			}
			if(User.isPseudoUnique(localUser, pseudo) == false) {
				
				isPseudoUnique.setText("Le pseudo n'est pas unique, changez");
			}
			if(pseudo.equals(" ") || pseudo.equals("\n")) {
				isPseudoUnique.setText("Saisir un format valable");
			}
			else {
		
				localUser.setPseudo(pseudo);
				Send.sendMessageUDP(new Message("B1",localUser.getPseudo(), localUser.getId()));				
				MyBdd.Insert_new_User(localUser);
				System.out.println("Creation de l'utilisateur "+localUser.toString());
				new Interfacee1();	// ouverture de l'interface de communication 	
				Interfacee1.ecran.setText("Vous etes connecté");
				Thread.sleep(1000);
				dispose();
				setVisible(false);
			}
		}
		
		for(int i =0; i< localUser.getActiveUsers().size(); i++) {

			System.out.println(localUser.getActiveUsers().get(i).getPseudo()+" "+localUser.getActiveUsers().get(i).getId());//utilisateurs actifs a la créations
		}
    }

    //Methodes 
    
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if(source.equals(bouttonCo)) {
			
			new ReceiveMessageUDP(Interfacee1.bufTCP, Interfacee1.lbq, localUser);
			Send.sendMessageUDP(new Message("B1bis")); // demande l'identite des utilisateurs connectés
			
			try {
				
				methodeChanger();
			} catch (UnresolvedAddressException | SQLException | InterruptedException e1) {
				System.out.println("ERREUR CREATION PROFILE");
			}
		}
		
	}                                            
}
