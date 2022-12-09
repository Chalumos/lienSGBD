package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;


import model.Livre;
import utile.Bdd;

public class LivreDAO {
	public static List<Livre> voirCatalogue() {
		List<Livre> listeLivre = new LinkedList<Livre>();
		Statement statement;
		try {
			statement = Bdd.connexionBdd.createStatement();
			ResultSet resulat = statement.executeQuery("SELECT * FROM Livre");
			while(resulat.next()) {
				Livre livre = new Livre();
				livre.setIdLivre(resulat.getInt("livre.idLivre"));
				livre.setTitre(resulat.getString("livre.titre"));
				livre.setNbExemplaire(resulat.getInt("livre.nbExemplaire"));
				listeLivre.add(livre);
			}
			return listeLivre;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}

	public static String ajoutExemplaire(String titre) {
		List<Livre> listeLivre = new LinkedList<Livre>();
		try {
			PreparedStatement prepStatement = Bdd.connexionBdd.prepareStatement("select * from livre where titre = ?;");
			prepStatement.setString(1, titre);
			ResultSet resulat = prepStatement.executeQuery();
			while(resulat.next()) {
				Livre livre = new Livre();
				livre.setIdLivre(resulat.getInt("livre.idLivre"));
				livre.setTitre(resulat.getString("livre.titre"));
				livre.setNbExemplaire(resulat.getInt("livre.nbExemplaire"));
				listeLivre.add(livre);
			}
			if(listeLivre.size() <= 0) {
				prepStatement.close();
				return "Le livre n'existe pas dans le catalogue";
			}
			else {
				int newNbExemplaire = listeLivre.get(0).getNbExemplaire()+1;
				prepStatement = Bdd.connexionBdd.prepareStatement
						(
						"update livre set nbExemplaire = ? where livre.titre = ? "
						);
				prepStatement.setInt(1, newNbExemplaire);
				prepStatement.setString(2, titre);
				prepStatement.executeUpdate();
				prepStatement.close();
				return "L'exemplaire à été ajouter pour ce livre";
			}
		}
		 catch (SQLException e) {
			e.printStackTrace();
		}
		return "Echec de l'ajout";
	}
}
