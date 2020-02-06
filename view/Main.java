/*
 * Nom de classe : Main
 *
 * Description   : Permet de lancer l'application et la base de donnees
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

import java.sql.SQLException;

import model.MyBdd;

public class Main{
	
	public static void main (String [] args) { 
		
		MyBdd.Driver();
		try {
			new MyBdd();
		}catch(SQLException e) {
		e.printStackTrace();
		}
		new Profile();
	}
}