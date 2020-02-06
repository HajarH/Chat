/*
 * Nom de classe : Liste
 *
 * Description   : Permet l'affichage de la liste des utilisateurs connectes
 * 				   Possibilite d'afficher 52 utilisateurs connectes
 * 				   le boutton cacher permet de fermer la fenetre sans arreter le programme.
 *
 * Version       : finale
 *
 * Date          : 05/02/2020
 * 
 */

package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import model.User;

@SuppressWarnings("serial")
public class Liste extends javax.swing.JFrame implements ComponentListener, MouseListener, ActionListener {


    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private static javax.swing.JLabel user1;
    private static javax.swing.JLabel user10;
    private static javax.swing.JLabel user48;
    private static javax.swing.JLabel user49;
    private static javax.swing.JLabel user50;
    private static javax.swing.JLabel user51;
    private static javax.swing.JLabel user52;
    private static javax.swing.JLabel user11;
    private static javax.swing.JLabel user12;
    private static javax.swing.JLabel user13;
    private static javax.swing.JLabel user14;
    private static javax.swing.JLabel user15;
    private static javax.swing.JLabel user16;
    private static javax.swing.JLabel user17;
    private static javax.swing.JLabel user18;
    private static javax.swing.JLabel user19;
    private static javax.swing.JLabel user2;
    private static javax.swing.JLabel user20;
    private static javax.swing.JLabel user21;
    private static javax.swing.JLabel user22;
    private static javax.swing.JLabel user23;
    private static javax.swing.JLabel user24;
    private static javax.swing.JLabel user25;
    private static javax.swing.JLabel user26;
    private static javax.swing.JLabel user3;
    private static javax.swing.JLabel user4;
    private static javax.swing.JLabel user5;
    private static javax.swing.JLabel user6;
    private static javax.swing.JLabel user7;
    private static javax.swing.JLabel user27;
    private static javax.swing.JLabel user8;
    private static javax.swing.JLabel user28;
    private static javax.swing.JLabel user29;
    private static javax.swing.JLabel user30;
    private static javax.swing.JLabel user31;
    private static javax.swing.JLabel user32;
    private static javax.swing.JLabel user33;
    private static javax.swing.JLabel user34;
    private static javax.swing.JLabel user35;
    private static javax.swing.JLabel user36;
    private static javax.swing.JLabel user37;
    private static javax.swing.JLabel user9;
    private static javax.swing.JLabel user38;
    private static javax.swing.JLabel user39;
    private static javax.swing.JLabel user40;
    private static javax.swing.JLabel user41;
    private static javax.swing.JLabel user42;
    private static javax.swing.JLabel user43;
    private static javax.swing.JLabel user44;
    private static javax.swing.JLabel user45;
    private static javax.swing.JLabel user46;
    private static javax.swing.JLabel user47;
    private javax.swing.JButton cacher;
    
    //Contructeur
    
    public static ArrayList<javax.swing.JLabel>  UsersActifs;
    public Liste() {
        initialiser();
    }
    
    //Initialisation
                  
    private void  initialiser() {
    	this.setTitle("Utilisateurs Actifs");
    	UsersActifs = new ArrayList<javax.swing.JLabel>();
    	
        jPanel1 = new javax.swing.JPanel();
        user1 = new javax.swing.JLabel();
        UsersActifs.add(user1);
        
        user2 = new javax.swing.JLabel();
        UsersActifs.add(user2);
       
        user3 = new javax.swing.JLabel();
        UsersActifs.add(user3);
       
        user4 = new javax.swing.JLabel();
        UsersActifs.add(user4);
        
        user5 = new javax.swing.JLabel();
        UsersActifs.add(user5);
      
        user6 = new javax.swing.JLabel();
        UsersActifs.add(user6);
        
        user7 = new javax.swing.JLabel();
        UsersActifs.add(user7);
        
        user8 = new javax.swing.JLabel();
        UsersActifs.add(user8);
        
        user9 = new javax.swing.JLabel();
        UsersActifs.add(user9);
        
        user10 = new javax.swing.JLabel();
        UsersActifs.add(user10);
        
        user11 = new javax.swing.JLabel();
        UsersActifs.add(user11);
        
        user12 = new javax.swing.JLabel();
        UsersActifs.add(user12);
        
        user13 = new javax.swing.JLabel();
        UsersActifs.add(user13);
        
        user14 = new javax.swing.JLabel();
        UsersActifs.add(user14);
        
        user15 = new javax.swing.JLabel();
        UsersActifs.add(user15);
        
        user16 = new javax.swing.JLabel();
        UsersActifs.add(user16);
    
        user17 = new javax.swing.JLabel();
        UsersActifs.add(user17);

        user18 = new javax.swing.JLabel();
        UsersActifs.add(user18);

        user19 = new javax.swing.JLabel();
        UsersActifs.add(user19);

        user20 = new javax.swing.JLabel();
        UsersActifs.add(user20);

        user21 = new javax.swing.JLabel();
        UsersActifs.add(user21);

        user22 = new javax.swing.JLabel();
        UsersActifs.add(user22);

        user23 = new javax.swing.JLabel();
        UsersActifs.add(user23);

        user24 = new javax.swing.JLabel();
        UsersActifs.add(user24);

        user25 = new javax.swing.JLabel();
        UsersActifs.add(user25);

        user26 = new javax.swing.JLabel();
        UsersActifs.add(user26);

        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        
        user27 = new javax.swing.JLabel();
        UsersActifs.add(user27);
        
        user28 = new javax.swing.JLabel();
        UsersActifs.add(user28);
        
        user29 = new javax.swing.JLabel();
        UsersActifs.add(user29);
        
        user30 = new javax.swing.JLabel();
        UsersActifs.add(user30);
        
        user31 = new javax.swing.JLabel();
        UsersActifs.add(user31);

        user32 = new javax.swing.JLabel();
        UsersActifs.add(user32);

        user33 = new javax.swing.JLabel();
        UsersActifs.add(user33);

        user34 = new javax.swing.JLabel();
        UsersActifs.add(user34);

        user35 = new javax.swing.JLabel();
        UsersActifs.add(user35);

        user36 = new javax.swing.JLabel();
        UsersActifs.add(user36);

        user37 = new javax.swing.JLabel();
        UsersActifs.add(user37);

        user38 = new javax.swing.JLabel();
        UsersActifs.add(user38);

        user39 = new javax.swing.JLabel();
        UsersActifs.add(user39);

        user40 = new javax.swing.JLabel();
        UsersActifs.add(user40);

        user41 = new javax.swing.JLabel();
        UsersActifs.add(user41);

        user42 = new javax.swing.JLabel();
        UsersActifs.add(user42);

        user43 = new javax.swing.JLabel();
        UsersActifs.add(user43);

        user44 = new javax.swing.JLabel();
        UsersActifs.add(user44);

        user45 = new javax.swing.JLabel();
        UsersActifs.add(user45);

        user46 = new javax.swing.JLabel();
        UsersActifs.add(user46);

        user47 = new javax.swing.JLabel();
        UsersActifs.add(user47);

        user48 = new javax.swing.JLabel();
        UsersActifs.add(user48);

        user49 = new javax.swing.JLabel();
        UsersActifs.add(user49);

        user50 = new javax.swing.JLabel();
        UsersActifs.add(user50);

        user51 = new javax.swing.JLabel();
        UsersActifs.add(user51);

        user52 = new javax.swing.JLabel();
        UsersActifs.add(user52);
    
        cacher = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        user1.setText("");

        user2.setText("");

        user3.setText("");

        user4.setText("");

        user5.setText("");

        user6.setText("");

        user7.setText("");

        user8.setText("");

        user9.setText("");

        user10.setText("");

        user11.setText("");

        user12.setText("");

        user13.setText("");

        user14.setText("");

        user15.setText("");

        user16.setText("");

        user17.setText("");

        user18.setText("");

        user19.setText("");

        user20.setText("");

        user21.setText("");

        user22.setText("");

        user23.setText("");

        user24.setText("");

        user25.setText("");

        user26.setText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(user1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(user4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
                    .addComponent(user3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
                    .addComponent(user6, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
                    .addComponent(user5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(user8, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
                    .addComponent(user7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(user10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
                    .addComponent(user9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(user14, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
                    .addComponent(user13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(user11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(user12, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
                    .addComponent(user16, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
                    .addComponent(user15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(user18, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
                    .addComponent(user17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(user20, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
                    .addComponent(user19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(user22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
                    .addComponent(user21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(user24, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
                    .addComponent(user26, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
                    .addComponent(user23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(user25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(user2, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(user1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(user4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(user3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(user6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(user5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(user8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(user7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(user10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(user9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(user14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(user26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(user25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(user23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(user24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(user21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(user22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(user19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(user20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(user13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(user11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(user17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(user12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(user16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(user18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(user15)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addComponent(user2)
                    .addContainerGap(535, Short.MAX_VALUE)))
        );

        user27.setText("");

        user28.setText("");

        user29.setText("");

        user30.setText("");

        user31.setText("");

        user32.setText("");

        user33.setText("");

        user34.setText("");

        user35.setText("");

        user36.setText("");

        user37.setText("");

        user38.setText("");

        user39.setText("");

        user40.setText("");

        user41.setText("");

        user42.setText("");

        user43.setText("");

        user44.setText("");

        user45.setText("");

        user46.setText("");

        user47.setText("");

        user48.setText("");

        user49.setText("");

        user50.setText("");

        user51.setText("");

        user52.setText("");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(user27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(user30, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
                    .addComponent(user29, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
                    .addComponent(user32, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
                    .addComponent(user31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(user34, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
                    .addComponent(user33, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(user36, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
                    .addComponent(user35, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(user40, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
                    .addComponent(user39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(user37, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(user38, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
                    .addComponent(user42, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
                    .addComponent(user41, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(user44, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
                    .addComponent(user43, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(user46, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
                    .addComponent(user45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(user48, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
                    .addComponent(user47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(user50, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
                    .addComponent(user52, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
                    .addComponent(user49, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(user51, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(user28, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(user27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(user30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(user29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(user32)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(user31)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(user34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(user33)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(user36)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(user35)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(user40)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(user52)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(user51)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(user49)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(user50)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(user47)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(user48)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(user45)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(user46)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(user39)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(user37)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(user43)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(user38)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(user42)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(user44)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(user41)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addComponent(user28)
                    .addContainerGap(535, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 23, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        cacher.setText("Cacher");
        cacher.addActionListener(this);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cacher)
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE))))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(cacher)
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addContainerGap())
            );
        ajouterMouseListener();
        nouveauUser();
        setVisible(true);
        //prevoitFermeture();
        pack();
    }                      
    
    //Methodes 
    
    public void ajouterMouseListener() {
    	
    	for(int i = 0; i< UsersActifs.size(); i++) {
    		
    		UsersActifs.get(i).addMouseListener(this);
    	}
    }
   
    public static void nouveauUser() {
    	
    	for(int j = 0; j<Profile.localUser.getActiveUsers().size(); j++) {
    		
    		String pseudo = new String(Profile.localUser.getActiveUsers().get(j).getPseudo());
	    	for(int i =0; i< UsersActifs.size(); i++) {
	    		
	    		if(UsersActifs.isEmpty()) {
	    			
	    			i=UsersActifs.size();
	    			break;
	    		}else {
	    			
	    			if(UsersActifs.get(i).getText().equals("") == true){
	    				
	    					UsersActifs.get(i).setText(pseudo);
	    					i=UsersActifs.size();
	    	    			break;
	    			}
	    		}
	    	}
    	}
    }
        
    
    public static void changeElement(User us, String old) { // on ancien et nouveau pseudo
    	
    	System.out.println("Changer 1");
		for(int i = 0; i< UsersActifs.size(); i++) {
			
	    	System.out.println(UsersActifs.get(i).getText());
	    	System.out.println("old ="+old);
			if(UsersActifs.get(i).getText().equals(old) == true) {
		    	System.out.println("Changer 3");

				System.out.println(UsersActifs.get(i).getText());
				UsersActifs.get(i).setText("");
				UsersActifs.get(i).setText(us.getPseudo());
				Interfacee1.ecran.setToolTipText(old + "a changé de pseudo : "+us.getPseudo());
		    	System.out.println("Changer 4");

			}
		}
		
		for(int i=0; i< Interfacee1.listeDiscussion.size(); i++) {
	    	System.out.println("Changer 5");
			if(Interfacee1.listeDiscussion.get(i).getUserDistant().getPseudo().equals(old)) {
		    	System.out.println("Changer 6");
		    	
		    	Interfacee1.ecran.setToolTipText(old + "a changé de pseudo : "+us.getPseudo());
				Interfacee1.listeDiscussion.get(i).getUserDistant().setPseudo(us.getPseudo());
				Interfacee1.listeDiscussion.get(i).changerF(us.getPseudo());
			}
		}
		
	}
        
    @Override
	public void mouseClicked(MouseEvent e) {
    	
		Object source = e.getSource();
		for(int i =0; i<UsersActifs.size(); i++) {
			
			if(source.equals(UsersActifs.get(i))) {
				
				String distantPseudo = UsersActifs.get(i).getText(); // renvoi le pseudo cliqué
				Interfacee1.ecran.setText("Une fenetre de discussion avec "+distantPseudo + " est ouverte");
				resultDistant(distantPseudo);
			}
		}				
	}

    
	public void resultDistant(String pseudo){ // permet d'ouvrir une fenetre de discussion avec l'user distant
		int indice = 0;
		
		for(int i = 0; i< Profile.localUser.getActiveUsers().size(); i++) {
			
			if(Profile.localUser.getActiveUsers().get(i).getPseudo() == pseudo) {
				
				indice = i;
			}
		}
		Interfacee1.listeDiscussion.add(new FenetreDiscussion(Profile.localUser.getActiveUsers().get(indice)));
		dispose();
		setVisible(false);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object source = e.getSource();
		
		if(source.equals(cacher)) {
			
			dispose();
			setVisible(false);
		}		
	}
	
	/**
	public void prevoitFermeture() { // prevoit la fermeture de la fenetre d'utilisateurs actifs au bou d'un certain temps
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			System.out.println("ERREUR FERMETURE LISTE ACTIVE USERS");
		}
		dispose();
		setVisible(false);		
	}
	**/
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
}
