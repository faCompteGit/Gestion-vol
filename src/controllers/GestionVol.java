package controllers;


import java.sql.Connection;
import vues.jframeListReservation;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.text.TabableView;

import models.Admin;
import models.Client;
import models.Connexion;
import models.Reservation;
import models.Vol;

public class GestionVol {
	Connection cn;
	public GestionVol() {
		
	}
	private static Pattern p = Pattern.compile("^[a-zA-Z0-9]*$");
	private static Pattern p2 = Pattern.compile("^[0-9]*$");
	public static boolean isAlphaNumeric(String s) {
        //return s != null && s.matches("^[a-zA-Z0-9]*$");
        return p.matcher(s).find();
    }
 
	public static boolean isNumeric(String s) {
        //return s != null && s.matches("^[0-9]*$");
        return p2.matcher(s).find();
	}
	
														//METHODES CLIENTS
	//Ajouter un client
	public Boolean AjouterClient(Client cl) throws SQLException  {
		try {
			System.out.println("insertin client");
			System.out.println(cl.getNom());
			System.out.println(cl.getPrenom());
			String sql = "INSERT INTO clients(nom,prenom) " + "VALUES ('"+cl.getNom()+"','"+cl.getPrenom()+"')";
			Connexion cn = new Connexion();
			cn.execute(sql);
			return true;
		}catch(Exception e) {
			throw new RuntimeException(e);
			
			
		}
		
	}
	
	//Rechercher un client
	public ArrayList<Client> RechercherClient(int id) throws SQLException  {
		String url="jdbc:mysql://localhost:3306/Aeroport";
		String user="root";
		String pass="";
		ArrayList<Client> clientList = null;
	
			try(Connection con = DriverManager.getConnection(url,user,pass);
				Statement statement = con.createStatement();){
				ResultSet rs;
				String sql = "select * from clients " + "where id= ('"+id+"')";
				 rs = statement.executeQuery(sql);
				 clientList = new ArrayList<>();
				    while (rs.next()) {
				    	Client client = new Client(rs.getString("nom"), rs.getString("prenom"));
				    	clientList.add(client);
				    }
				    System.out.println("affichage");
				    con.close();
				    return clientList;
			     
			}catch(Exception e){
				throw new RuntimeException(e);
				
			}
		    
		}
	
	//Rechercher un client par nom
		//public ArrayList<Client> RechercherClientNom(String nom) throws SQLException  {
			//String url="jdbc:mysql://localhost:3306/Aeroport";
			//String user="root";
			//String pass="";
			//ArrayList<Client> clientList = null;
		
				//try(Connection con = DriverManager.getConnection(url,user,pass);
					//Statement statement = con.createStatement();){
					//ResultSet rs;
					//String sql = "select id,nom,prenom from clients " + "where nom= ('"+nom+"')";
					 //rs = statement.executeQuery(sql);
					 ///clientList = new ArrayList<>();
					    //while (rs.next()) {
					    	//Client client = new Client(rs.getInt(1),rs.getString("nom"), rs.getString("prenom"));
					    	//int id= rs.getInt("id");
					    	//String name = rs.getString("nom");
					    	//String pren = rs.getString("prenom");
					    	//clientList.add(client);
					    //}
					    //System.out.println("affichage");
					   // con.close();
					    //return clientList;
				     
				//}catch(Exception e){
					//throw new RuntimeException(e);
					
			//	}
			    
			//}
	
	//Modifier un client
	public Boolean ModifierClient(int id ,Client cl) throws SQLException  {
		try {
			System.out.println("client modifier");
			String sql = "update clients set nom = " + "'"+cl.getNom()+"',"+"prenom ="+"'"+cl.getPrenom()+"'"
					 + "where id="+"'"+id+"'";
			System.out.println("client modifier oohhh");
			Connexion cn = new Connexion();
			cn.execute(sql);
			return true;
		}catch(Exception e) {
			throw new RuntimeException(e);
			
			
		}
		
	}
	//public Boolean Modifiercl(String nom ,Client cl) throws SQLException  {
		//try {
			//System.out.println("vol modifier");
			//String sql = "update clients set nom = "+"'"+cl.getNom()+"',"+"prenom ="+"'"+cl.getPrenom()+"'"
				//	 + "where nom="+"'"+cl.getNom()+"'";
			//Connexion cn = new Connexion();
			//cn.execute(sql);
			//return true;
		//}catch(Exception e) {
			//throw new RuntimeException(e);
			
			
	//	}
		
	//}
														//METHODES VOLS

		//Ajouter un vol
		public Boolean AjouterVol(Vol vol) throws SQLException  {
			try {
				System.out.println("insertion vol");
				String sql = "INSERT INTO vols(ref,date_Vol,heure_depart,heure_Arrivee,destination,etat_vol,prix) " 
			+ "VALUES ('"+vol.getRef()+"','"+vol.getDate_Vol()+"','"+vol.getHeure_Depart()+"','"+vol.getHeure_Arrivee()+"','"+vol.getDestination()+"','"+vol.getEtat_Vol()+"','"+vol.getPrix()+"')";
				Connexion cn = new Connexion();
				cn.execute(sql);
				return true;
			}catch(Exception e) {
				throw new RuntimeException(e);
				
			}
			
		}
		
		//Rechercher un vol
		public ArrayList<Vol> RechercherVol(String ref) throws SQLException  {
			String url="jdbc:mysql://localhost:3306/Aeroport";
			String user="root";
			String pass="";
		
				try(Connection con = DriverManager.getConnection(url,user,pass);
					Statement statement = con.createStatement();){
					ResultSet rs;
					String sql = "select * from vols " + "where ref= ('"+ref+"')";
					 rs = statement.executeQuery(sql);
					 ArrayList<Vol> volList = new ArrayList<>();
					    while (rs.next()) {
					    	Vol vol = new Vol(rs.getString("ref"), rs.getString("date_vol"),rs.getString("heure_depart"),rs.getString("heure_arrivee"),rs.getString("destination"),rs.getString("etat_vol"),rs.getInt("prix"));
					    	volList.add(vol);
					    }
					    System.out.println("affichage");
					    con.close();
					    return volList;
				     
				}catch(SQLException e){
					e.printStackTrace();
					
				}
				return null;
			    
			}
		
		
		
		//Modifier un vol
		public Boolean ModifierVol(String ref ,Vol vol) throws SQLException  {
			try {
				System.out.println("vol modifier");
				String sql = "update vols set date_vol = "+"'"+vol.getDate_Vol()+"',"+"heure_depart ="+"'"+vol.getHeure_Depart()+"',"+"heure_arrivee ="+"'"+vol.getHeure_Arrivee()+"',"+"destination ="+"'"+vol.getDestination()+"',"+"etat_vol ="+"'"+vol.getEtat_Vol()+"',"+"prix ="+"'"+vol.getPrix()+"'"
						 + "where ref="+"'"+ref+"'";
				Connexion cn = new Connexion();
				cn.execute(sql);
				return true;
			}catch(Exception e) {
				throw new RuntimeException(e);
				
				
			}
			
		}
		
		
																//METHODES RESERVATION
		
		//Ajouter une résevation
			public Boolean AjouterReservation(Reservation res) throws SQLException  {
				
				try {
					System.out.println("cr�ation reservation");
					String sql = "INSERT INTO reservations(client_id,mode_paiement,vol_ref,date_reservation,nbr_billet) " 
				+ "VALUES ('"+res.getClient_id()+"','"+res.getMode_paiement()+"','"+res.getVol_ref()+"','"+res.getDate_Reservation()+"','"+res.getNbr_billet()+"')";
					Connexion cn = new Connexion();
					cn.execute(sql);
					return true;
				}catch(Exception e) {
					throw new RuntimeException(e);
				}
				
				
		
	
	}

			
			
			
			
			
			
			
			
			
																		//METHODES ADMINISTRATEUR
			
			
			//Se connecter
			public ArrayList<Admin> seConnecter(Admin admin)   {
				String url="jdbc:mysql://localhost:3306/Aeroport";
				String user="root";
				String pass="";
				ResultSet rs = null ;
				Statement st = null;
				ArrayList<Admin> adminList = null;
				try{
					Connection con = DriverManager.getConnection(url,user,pass);
					if(con!=null) {
						String sql = "select username, pass from admins " + "where username= ('"+admin.getNom()+"')";
						st = con.createStatement();
						rs = st.executeQuery(sql);
						 while (rs.next()) {
							 adminList = new ArrayList<>();
							 Admin adm = new Admin(rs.getString(1), rs.getString(2));
							 	adminList.add(adm);
						    }
						 return adminList;
					}
					else {
						return adminList;
					}
				}catch(Exception e) {
					throw new RuntimeException(e);
				}
			}
					
			
			
			
			
}
