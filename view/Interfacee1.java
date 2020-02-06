/*
 * Nom de classe : Interfacee1
 *
 * Description   : Permet d'ouvrir un profil a l'utilisateur, c'est l'interface principale du programme
 * 				   On peut changer le pseudo, afficher la liste des utilisateurs actifs ou se deconnecter 
 * 				   Il y a un ecran central on recoi des notifiations (changement de pseudo, session en cours)
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
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.DatagramPacket;
import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

import controller.Send;
import controller.ReceiveMessageTCP;

@SuppressWarnings("serial")
public class Interfacee1 extends javax.swing.JFrame implements ActionListener, KeyListener, MouseListener, ComponentListener {

	//Variables 
	
    private javax.swing.JButton ActiveUsers;
    private javax.swing.JInternalFrame ListUsers;
    private javax.swing.JButton changerPseudo;
    private javax.swing.JButton deconnexion;
    public static javax.swing.JTextArea ecran;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static ArrayList<FenetreDiscussion> listeDiscussion;
    final static LinkedBlockingQueue<DatagramPacket> lbq = new LinkedBlockingQueue<DatagramPacket>(); // retour du thread des messages reçus 
	final static LinkedBlockingQueue<String> bufTCP = new LinkedBlockingQueue<String>(); // retour du thread des messages reçus 
	protected static ReceiveMessageTCP rcv; 
	
	//Constructeur 
	
    public Interfacee1() {
        initComponents();
    }
    
    //Itnitialisation
                    
    private void initComponents() {
    	
    	this.setTitle("Profil principal");
    	listeDiscussion = new ArrayList<FenetreDiscussion>(); // on memorise les conversations en cours
        jPanel1 = new javax.swing.JPanel();
        deconnexion = new javax.swing.JButton();
        changerPseudo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ecran = new javax.swing.JTextArea();
        ActiveUsers = new javax.swing.JButton();
        ListUsers = new javax.swing.JInternalFrame();
        rcv = new ReceiveMessageTCP(Interfacee1.bufTCP, Profile.localUser.getId(), Profile.localUser);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);


        deconnexion.setText("Deconnexion");
        deconnexion.addActionListener(this);

        changerPseudo.setText("Changer Pseudo");
        changerPseudo.addActionListener(this);
        
        ecran.setColumns(20);
        ecran.setRows(5);
        jScrollPane1.setViewportView(ecran);

        ActiveUsers.setText("Utilisateurs Actifs");
        ActiveUsers.addActionListener(this);

        javax.swing.GroupLayout ListUsersLayout = new javax.swing.GroupLayout(ListUsers.getContentPane());
        ListUsers.getContentPane().setLayout(ListUsersLayout);
        ListUsersLayout.setHorizontalGroup(
            ListUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        ListUsersLayout.setVerticalGroup(
            ListUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(deconnexion, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                .addGap(647, 647, 647))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ListUsers)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(changerPseudo, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(160, 160, 160)
                        .addComponent(ActiveUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 623, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(deconnexion)
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(changerPseudo)
                            .addComponent(ActiveUsers)))
                    .addComponent(ListUsers)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setVisible(true);
    }   
    
    // Methodes 
    
    @Override
	public void actionPerformed(ActionEvent e) {
    	
		Object source = e.getSource();
				
		if (source.equals(changerPseudo)) {
			
			new ChangerPseudo();
		}
		
		if(source.equals(deconnexion)) { 
			
			Profile.localUser.setEtat("DISCONNECTED");
			ecran.setText("Vous etes deconecte");
			Send.sendMessageUDP("FIN");// previent le reseau que l'user a quitter le Chat
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				System.out.println("INTERRUPTED EXCEPTION INTERFACEE DECONNECTION");
			}
			
			ReceiveMessageTCP.closeSocket(rcv);
			this.dispose();
			this.setVisible(false);			
		}
		
		if(source.equals(ActiveUsers)) { //permet d'afficher la liste d'utilisateurs actifs 
			
			new Liste();
		}
	}
	
    
	@Override
	public void componentResized(ComponentEvent e) {
		// TODO Auto-generated method stub		
	}

	@Override
	public void componentMoved(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentShown(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentHidden(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
 
}