package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import model.Associe;
import model.Livre;

public class AssocieDAO extends Dao{

	public AssocieDAO(String tableBdd) {
		super(tableBdd);
	}

	
	public ArrayList<Associe> trouverAssocieEnRetard() {
		ArrayList<Associe> listeAssocieEnRetard = new ArrayList<Associe>();
		
		Date date = new Date();
		SimpleDateFormat DateFor = new SimpleDateFormat("yyyy-MM-dd");
		String stringDate= DateFor.format(date);
		
		HashMap<String, String> parametres = new HashMap<String, String>();
		parametres.put("fields", "nom, prenom");
		parametres.put("othertable", "JOIN pret ON associe.id = idAssocie");
		parametres.put("conditions", "DATEDIFF(dateRendu,'"+stringDate+"') < 0");
		
		ResultSet resulat = find(parametres);
		if(resulat == null) {
			return null;
		}
		
		try {
			while(resulat.next()) {
				Associe associe = new Associe();
				associe.setNom(resulat.getString("nom"));
				associe.setPrenom(resulat.getString("prenom"));
				listeAssocieEnRetard.add(associe);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeStatement();
		
		return listeAssocieEnRetard;
	}
}
