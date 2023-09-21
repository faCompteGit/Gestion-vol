package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Connexion {
	Connection cn;
	public Connexion(){
			String url="jdbc:mysql://localhost:3306/Aeroport";
			String user="root";
			String pass="";
			try {
				Class.forName("com.mysql.jdbc.Driver");
				cn = DriverManager.getConnection(url,user,pass);
				System.out.println("connecter");
			}catch(Exception e) {
				System.out.println("non connecter");
			}
			
	}
	
	
	public void execute(String sql)
	  {
		String url="jdbc:mysql://localhost:3306/Aeroport";
		String user="root";
		String pass="";
	    try (Connection cn = DriverManager.getConnection(url,user,pass);
	        Statement statement = cn.createStatement()) {
	      statement.executeUpdate(sql);
	      System.out.println("ok");
	      cn.close();
	    }
	    catch (SQLException e) {
	      throw new RuntimeException("Error executing sql:\n" + sql, e);
	    }
	  }
	}


