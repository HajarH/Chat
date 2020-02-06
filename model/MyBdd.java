/*
 * Nom de classe : MyBdd
 *
 * Description   : Base de donnees local, permet le stockages des messages echanges
 * 				   L'id et l'ip du user local sont aussi concerves dans cette base de donnees 
 * 				   L'identité des utilisateurs distants n'est pas concervee 
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

import java.sql.*;
import java.util.*;



public class MyBdd {
	
	public static String dateFormat = "yyyy-MM-dd HH:mm:ss";
	
	private static  MyBdd instance = null;
	
	public MyBdd() throws SQLException {
			Driver();
			Create_User_Table();
			MyBdd.Create_message_Table();
	}
	
	public static  MyBdd getInstance(User us) throws SQLException {
		if (instance == null) {
			instance = new  MyBdd();
		}
		return instance;
	}
	
	public static void Driver(){
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public static Connection etablirConnexion() throws SQLException {
		
		String url = "jdbc:sqlite:"+"BDD.db";
		Connection conn = DriverManager.getConnection(url);
		System.out.print("BDD connection");
		return conn;
	}
	
	// Creation User: concervation des informations du user local 
	// Ajouter les utilisateurs connectes 
	
	public static void Create_User_Table() {
		
		Connection co=null;
		String sql = "CREATE TABLE IF NOT EXISTS User" + 
				"   ( Pseudo VARCHAR(20), "+
			    "	 Id INT," + 
				"    IP_address VARCHAR(15));"; 
		try {
			try {
				co = etablirConnexion();
				Statement st = co.createStatement();
				
				st.executeUpdate(sql);
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}finally {
			if (co!= null)
				try {
					co.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}
	
	//Recupérer les Id existant
	
	public static ArrayList<Integer> getIdUsers() throws SQLException{
		
		Connection co=null;
		ArrayList<Integer> results= new ArrayList<Integer>();
		try {
			co = MyBdd.etablirConnexion();
			String sql = "SELECT * " + " FROM User";
			Statement st = co.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				results.add(rs.getInt("Id"));
			} 
		}finally {
			if (co!= null)
				co.close();
		}
		
		return results;
	}
	
	
	//Insert un nouvel utilisateur dans la table
	
	public static void Insert_new_User (User user) throws SQLException {
		
		Connection co = null;
		try {
			co=etablirConnexion();
			int id = user.getId();
			String IP = user.getIPAddr().getHostAddress().toString();
			if(getIdUsers().contains(user.getId()) == false) {
				String sql = "INSERT INTO User (Pseudo, Id , IP_address) " + " VALUES ( '" + user.getPseudo() + "','" + id + "','" + IP + "')";							
				Statement st = co.createStatement();
				st.executeUpdate(sql);
				st.close();
			}
			
		
		} finally {
			if (co !=null)
				co.close();
		}
	} 
	
	
	//Creé une table de messages 
	public static void Create_message_Table() throws SQLException {
		
		Connection co=null;
		try {
			co = MyBdd.etablirConnexion();
			Statement st = co.createStatement();
			String sql = " CREATE TABLE IF NOT EXISTS Message" + 
					" (Sender_IP VARCHAR(15)," + 
					" Receiver_IP VARCHAR(15)," + 
					" Text TEXT , " + 
					" Time String) ;" ; 
					
				
				System.out.println("Table messages crée "+sql);
			st.executeUpdate(sql);

			st.close();
		}finally {
			if (co!= null) 
				co.close();
		}
	}
	
	
	//Compte existant
		public static boolean CompteExistant(String IP) throws SQLException {
			
			Connection co=null;
			boolean ret;
			ArrayList<String> results= new ArrayList<String>();
			try {
				co = MyBdd.etablirConnexion();
				String sql = "SELECT IP_address " + " FROM User";
				Statement st = co.createStatement();
				ResultSet rs = st.executeQuery(sql);
				while(rs.next()) {
					results.add(rs.getString("IP_address"));
				} 
				if(results.contains(IP)) {
					ret = true;
				}
				else ret = false;
			}finally {
				if (co!= null)
					co.close();
			}
			return ret;
		}
		

	//creer table de ChatSession
		public static void Create_ChatSession_Table(User local, User distant) throws SQLException {
			Connection co=null;
			try {
				co = MyBdd.etablirConnexion();
				Statement st = co.createStatement();
				String sql = "CREATE TABLE IF NOT EXISTS ChatSession" + 
						"	(Distant_IP VARCHAR(15)," + 
						"	Local_IP VARCHAR(15)," + 
						"	Time String);" ; 
				
				st.executeUpdate(sql);

				st.close();
			}finally {
				if (co!= null) 
					co.close();
			}
		}
		
	//Insert un nouveau message
	public static void InsertMessage (User receiver, User sender, Message msg) throws SQLException {
		
		Connection co = null;
		try {
			co=MyBdd.etablirConnexion();
			//String sql = ("INSERT into Message (Sender_IP , Receiver_IP , Text, Time) ") 
			String sql = ("INSERT into Message (Sender_IP , Receiver_IP , Text , Time) ") 
					+ (" VALUES ('"+sender.getIPAddr().getHostAddress() +"'" + " , "+ "'" + receiver.getIPAddr().getHostAddress()+"'" +" , "+"' "
					+ " "+ "(FROM "+sender.getIPAddr().getHostAddress()+" : "+sender.getPseudo() + ") TO (" +receiver.getIPAddr().getHostAddress()+" : "+ receiver.getPseudo()+")   " +msg.getMessage()+"' , "+ "'"+Message.horodatage()+"') ;");
			//+" , "+"' "+ dateFormat+"' 
			Statement st = co.createStatement();
			System.out.println("Message ajouté");
			st.executeUpdate(sql);
		
			st.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			if (co !=null)
				co.close();
		}
	} 
	
	
	//Recupere un message dans l'historique 
	public static void get_History(ArrayList<String> results, User receive , User send) throws SQLException {
		
		Connection co=null;
		String txt;
		String date;
		try {
			co = MyBdd.etablirConnexion();
			String sql = "SELECT * " + " FROM Message "
					+ " where ( Sender_IP = '" + receive.getIPAddr().getHostAddress() + "' AND Receiver_IP = '" + send.getIPAddr().getHostAddress() + "' )" 
					+" OR ( Sender_IP = '" + send.getIPAddr().getHostAddress() + "' AND Receiver_IP = '" + receive.getIPAddr().getHostAddress() +"' ); ";
			Statement st = co.createStatement();
			ResultSet rs =st.executeQuery(sql);
			while(rs.next()) {

				txt = rs.getString("Text");
				date = rs.getString("Time");
				results.add(txt+" "+date);	
				//System.out.println(rs.getString("Text"));
			} 
		}finally {
			if (co!= null)
				co.close();
		}
	}
	
	
	//Supprime les Id des utilisateurs distants à la deconnexion
	public static void DeleteUsers()throws SQLException {
		
			Connection co = null;
			try {
				System.out.println("ON DELETE BDD");
				co=etablirConnexion();
				String sql = "DELETE INTO User (Pseudo, Id , IP_address)"
							+ "WHERE IP_address NOT_LIKE"+ User.setIPAddr().getHostAddress().toString();;
					Statement st = co.createStatement();
					st.executeUpdate(sql);
					st.close();
				}			
			 finally {
				if (co !=null)
					co.close();
			}	
	}
	
	//Verifie l'existence d'une chat session	
	public static Boolean Session_exist(User user1, User user2, User local) throws SQLException {
		
		ArrayList<String> hist = new ArrayList<String>();
		get_History(hist,user1,user2);
		return !(hist.isEmpty());
	}
	
	
	//Renvoi les pseudos existants mais lors de l'ouverture du compte il permet la récupération du pseudo du user local
	public static String getMonPseudo() throws SQLException {
		
		Connection co=null;
		
		String results= new String();
		try {
			co = MyBdd.etablirConnexion();
			String sql = "SELECT Pseudo " + " FROM User"
					+ " WHERE IP_address = '" + User.setIPAddr().getHostAddress()+"'";
			Statement st = co.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()) {
				results=(rs.getString("Pseudo"));
			}
			st.close();
		}
		finally {
			if(co != null)
				co.close();
		}
		
		return results;
	}
	
	
	//Renvoi les ID existants mais lors de l'ouverture du compte il permet la récupération du Id du user local
		public static int getMonId(User local) throws SQLException {
			
			Connection co=null;
			
			int results = 0;
			try {
				co = MyBdd.etablirConnexion();
				String sql = "SELECT Id " + " FROM User WHERE IP_address = '" + local.getIPAddr().getHostAddress()+"'";
				System.out.println(sql);
				Statement st = co.createStatement();
				ResultSet rs = st.executeQuery(sql);
				if(rs.next()) {
					results=(rs.getInt("Id"));
				}
				st.close();
			}
			finally {
				if(co != null)
					co.close();
			}
			
			return results;
		}
		
		
		//Renvoi les pseudos existants mais lors de l'ouverture du compte il permet la récupération du pseudo du user local
		public static ArrayList<String> getPseudos() throws SQLException {
			
			Connection co=null;
			
			ArrayList<String> results= new ArrayList<String>();
			try {
				co = MyBdd.etablirConnexion();
				String sql = "SELECT Pseudo " + " FROM User "
						+ " WHERE IP_address =\'" + User.setIPAddr().getHostAddress().toString()+'\'';
				Statement st = co.createStatement();
				ResultSet rs = st.executeQuery(sql);
				while(rs.next()) {
					results.add(rs.getString("Pseudo"));
				}
				st.close();
			}
			finally {
				if(co != null)
					co.close();
			}
			
			return results;
		}
}