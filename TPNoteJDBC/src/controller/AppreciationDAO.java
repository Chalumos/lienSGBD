package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import model.Appreciation;
import model.Film;
import model.Spectateur;

public class AppreciationDAO extends Dao{

	public AppreciationDAO(String tableBdd) {
		super(tableBdd);
	}
	
	public List<Appreciation> listerAvisFilms(String nomSpectateur) {
		List<Appreciation> listeAvis = new LinkedList<Appreciation>();
		
		HashMap<String, String> parametres = new HashMap<String, String>();
		parametres.put("conditions", "Spectateur.nom = '"+nomSpectateur+"'");
		parametres.put("order", "appreciation.idSpectateur DESC");
		parametres.put("othertable", 
					  " JOIN spectateur ON appreciation.idSpectateur  = spectateur.id"
					+ " JOIN film ON appreciation.idFilm = film.id");
		
		ResultSet resulat = find(parametres);
		try {
			while(resulat.next()) {
				Appreciation appreciation = new Appreciation();
				Film film = new Film();
				Spectateur spectateur = new Spectateur();
				spectateur.setNom(resulat.getString("nom"));
				spectateur.setPrenom(resulat.getString("prenom"));
				film.setTitre(resulat.getString("titre"));
				film.setVisaExploitation(resulat.getString("visa_exploitation"));
				film.setRealisateur(resulat.getString("realisateur"));
				film.setDuree(resulat.getInt("duree"));
				film.setAnneeSortie(resulat.getDate("annee_sortie"));
				appreciation.setSpectateur(spectateur);
				appreciation.setFilm(film);
				appreciation.setNote(getNotes(resulat.getInt("note")));
				listeAvis.add(appreciation);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeStatement();
		return listeAvis;
	}
	
	public String getNotes(int note) {
		String noteString = null;
		switch (note) {
		case 1: {
			noteString = "Nul";
			break;
		}
		case 2: {
			noteString = "Bien";
			break;
		}
		case 3: {
			noteString = "Très bien";
			break;
		}
		default:
		}
		return noteString;
	}
}
