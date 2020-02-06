/*
 * Nom de classe : ChangerPseudo
 *
 * Description   : Ouvre une fenetre qui permet de changer le pseudo 
 *
 * Version       : finale
 *
 * Date          : 05/02/2020
 * 
 */

/***
 * @author hajar
 */


package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.User;

@SuppressWarnings("serial")
public class ChangerPseudo extends javax.swing.JFrame implements ActionListener {
	
	// Variables
	
    private javax.swing.JButton EnvoyerPseudo;
    private javax.swing.JTextField SaisirPseudo;
    private javax.swing.JPanel jPanel1;
	
    //Constructeur 
    
    public ChangerPseudo() {
       initialiser();
    }

    //Initialiser
    
    private void initialiser() {

    	 jPanel1 = new javax.swing.JPanel();
         EnvoyerPseudo = new javax.swing.JButton();
         SaisirPseudo = new javax.swing.JTextField();
         this.setTitle("Changer Pseudo");

         setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

         EnvoyerPseudo.setText("Soumettre");
         EnvoyerPseudo.addActionListener(this);

         SaisirPseudo.setText("");
         SaisirPseudo.addActionListener(this);

         javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
         jPanel1.setLayout(jPanel1Layout);
         jPanel1Layout.setHorizontalGroup(
             jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addGroup(jPanel1Layout.createSequentialGroup()
                 .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(jPanel1Layout.createSequentialGroup()
                         .addGap(141, 141, 141)
                         .addComponent(EnvoyerPseudo))
                     .addGroup(jPanel1Layout.createSequentialGroup()
                         .addGap(64, 64, 64)
                         .addComponent(SaisirPseudo, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)))
                 .addContainerGap(70, Short.MAX_VALUE))
         );
         jPanel1Layout.setVerticalGroup(
             jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                 .addContainerGap(101, Short.MAX_VALUE)
                 .addComponent(SaisirPseudo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                 .addGap(58, 58, 58)
                 .addComponent(EnvoyerPseudo)
                 .addGap(97, 97, 97))
         );

         javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
         getContentPane().setLayout(layout);
         layout.setHorizontalGroup(
             layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
         );
         layout.setVerticalGroup(
             layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
         );

         pack();
        setVisible(true);
    }                    

    //Methodes 
    
    public void changer(String pseudo) throws InterruptedException {
    	
    	 boolean test = User.changerPseudo(Profile.localUser, pseudo);
    		
    		if(test == false) {
    			
    			Interfacee1.ecran.setText("Pseudo déja utilisé, choisissez un autre pseudo");
    			System.out.println("Le pseudo saisi n'est pas unique. Saisir un pseudo : ");
    		}
    		else {
    			
    			Interfacee1.ecran.setText("Votre nouveau pseudo est "+Profile.localUser.getPseudo());
    			Thread.sleep(5000);
    			setVisible(false);
    			dispose();
    		}
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		System.out.println("Nous allons changer votre pseudo");
		Interfacee1.ecran.setText("Nous allons changer votre pseudo");
		if(source.equals(EnvoyerPseudo)) {
			String pseudo = SaisirPseudo.getText();
			 jPanel1.setToolTipText("Verification unicité en cours");
			 Interfacee1.ecran.setToolTipText("Verification unicité en cours");
			try {
				changer(pseudo);
			} catch (InterruptedException e1) {
				System.out.println("ERREUR CHANGEMENT PSEUDO");
			}
		}		
	}
	
  
                
}