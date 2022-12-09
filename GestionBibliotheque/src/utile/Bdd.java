package utile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BDD {
	
	private static  Connection bdd;
	
	
	public static void getConnexion() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException ex1) {
			System.out.println("Pilote non trouvé!");
			System.exit(1);
		}
		try {
			/*
			 * avec sqlCommandPrompt
			Connection connexionBdd = DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/festival","root", "password");
			System.out.println("Connected!");
			*/
			
			Connection connexionBdd = DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/bibliothequeTP4","root", "");
			System.out.println("Connected!");
			bdd =  connexionBdd;
		}
		catch (SQLException ex2) {
			System.out.println("Erreur JDBC: "+ex2);
			System.exit(1);
		}
	}
}
