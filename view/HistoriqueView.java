/*
 * Nom de classe : HistoriqueView
 *
 * Description   : Affiche dans une nouvelle fenetre l'historique avec l'utilisateur choisi
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
import java.sql.SQLException;
import java.util.ArrayList;

import model.MyBdd;
import model.User;

@SuppressWarnings("serial")
public class HistoriqueView extends javax.swing.JFrame implements ActionListener {

	//Variables 
	
	  private javax.swing.JButton cacher;
      private javax.swing.JPanel jPanel1;
      private javax.swing.JScrollPane jScrollPane1;
      private javax.swing.JTextArea affichage;
      private User distant;
      
    // Methodes 
      
    public HistoriqueView(User dist) {
    	distant = dist;
        initialiser();
    }

    //Initialisation 
    
    private void initialiser() {
    	
    	this.setTitle("Historique : "+distant.getPseudo());
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        affichage = new javax.swing.JTextArea();
        cacher = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        affichage.setColumns(20);
        affichage.setRows(5);
        jScrollPane1.setViewportView(affichage);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
        );

        cacher.setText("cacher");
        cacher.addActionListener(this);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cacher))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(cacher)
                .addGap(3, 3, 3)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        run();
        setVisible(true);
        pack();
    }                     

    //Methodes

    public void run() {
        setVisible(true);
        String txt = new String();
        String pseudo = distant.getPseudo();
		int indice = 0;
		for(int i = 0; i< Profile.localUser.getActiveUsers().size(); i++) {
			if(Profile.localUser.getActiveUsers().get(i).getPseudo().equals(pseudo)) {
				indice = i;
			}
		}
		ArrayList<String> results= new ArrayList<String>();
		try {
			MyBdd.get_History(results, Profile.localUser , Profile.localUser.getActiveUsers().get(indice));
		} catch (SQLException e) {
			System.out.println("SQL EXCEPTION VIEW HISTORIQUE");
		}
		
		for(int i = 0; i< results.size(); i++) {
			System.out.println(results.get(i));
			txt = txt+ results.get(i)+"\n";
		}
		 affichage.setText(txt);
    }


	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source.equals(cacher)) {
			dispose();
			setVisible(false);
		}
		
	}                
}
            