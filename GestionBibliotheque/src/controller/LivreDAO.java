package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import model.Livre;

public class LivreDAO extends Dao{
	
	public LivreDAO(String tableBdd) {
		super(tableBdd);
	}


	public String ajoutExemplaire(String titre) {
		Livre livre = null;
		
		HashMap<String, String> parametres = new HashMap<String, String>();
		parametres.put("conditions", "titre = '"+titre+"'");
		ResultSet resulatFind = find(parametres);
		
		try {
			while(resulatFind.next()) {
			    livre = new Livre();
				livre.setIdLivre(resulatFind.getInt("livre.id"));
				livre.setTitre(resulatFind.getString("livre.titre"));
				livre.setNbExemplaire(resulatFind.getInt("livre.nbExemplaire"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeStatement();
		
		if(livre == null) {
			return "Le livre n'existe pas dans le catalogue";
		}
		parametres.clear();
		
		int newNbExemplaire = livre.getNbExemplaire()+1;
		parametres.put("modification", "nbExemplaire = "+newNbExemplaire);
		parametres.put("conditions", "titre = '"+titre+"'");
		int resulatUpdate =  update(parametres);
		if (resulatUpdate == 1 ) {
			closeStatement();
			return "L'exemplaire a bien ete ajouter pour "+titre+ ", nouveau nbExemplaire: "+newNbExemplaire;
		}
		else {
			closeStatement();
			return "Echec de l'ajout de l'exemplaire pour "+titre;
		}
	}
	
	public String ajouterLivre(String titre) {
		Livre livre = null;
		
		HashMap<String, String> parametres = new HashMap<String, String>();
		parametres.put("conditions", "titre = '"+titre+"'");
		ResultSet resulatFind = find(parametres);
		
		try {
			while(resulatFind.next()) {
			    livre = new Livre();
				livre.setIdLivre(resulatFind.getInt("livre.id"));
				livre.setTitre(resulatFind.getString("livre.titre"));
				livre.setNbExemplaire(resulatFind.getInt("livre.nbExemplaire"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeStatement();
		
		if(livre != null) {
			return "Le livre existe deja dans le catalogue";
		}
		parametres.clear();
		
		parametres.put("titre", titre);
		int resulatUpdate =  save(parametres);
		if (resulatUpdate == 1 ) {
			closeStatement();
			return "Le livre a bien ete ajouter au catalogue";
		}
		else {
			closeStatement();
			return "Echec de l'ajout du livre: "+titre;
		}
	}
	
	
	public List<Livre> voirCatalogue() {
		List<Livre> listeLivre = new LinkedList<Livre>();
		
		ResultSet resulat = find(null);
		try {
			while(resulat.next()) {
				Livre livre = new Livre();
				livre.setIdLivre(resulat.getInt("livre.idLivre"));
				livre.setTitre(resulat.getString("livre.titre"));
				livre.setNbExemplaire(resulat.getInt("livre.nbExemplaire"));
				listeLivre.add(livre);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeStatement();
		return listeLivre;
	}
}
