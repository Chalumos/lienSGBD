package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
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
		
		ResultSet resultat = find(parametres);
		try {
			while(resultat.next()) {
				Appreciation appreciation = new Appreciation();
				Film film = new Film();
				Spectateur spectateur = new Spectateur();
				spectateur.setNom(resultat.getString("nom"));
				spectateur.setPrenom(resultat.getString("prenom"));
				film.setTitre(resultat.getString("titre"));
				film.setVisaExploitation(resultat.getString("visa_exploitation"));
				film.setRealisateur(resultat.getString("realisateur"));
				film.setDuree(resultat.getInt("duree"));
				film.setAnneeSortie(resultat.getDate("annee_sortie"));
				appreciation.setSpectateur(spectateur);
				appreciation.setFilm(film);
				appreciation.setNote(getNotes(resultat.getInt("note")));
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
			noteString = "Tr�s bien";
			break;
		}
		default:
		}
		return noteString;
	}
}
