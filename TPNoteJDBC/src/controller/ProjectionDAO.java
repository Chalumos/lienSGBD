package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import model.Film;
import model.Projection;
import model.Salle;

public class ProjectionDAO extends DAO{

	public ProjectionDAO(String tableBdd) {
		super(tableBdd);
	}
	
	public List<Projection> listerFilms(String nomSalle) {
		List<Projection> listeProjection = new LinkedList<Projection>();
		
		HashMap<String, String> parametres = new HashMap<String, String>();
		parametres.put("order", "projection.idSalle DESC");
		parametres.put("conditions", "Salle.nom = '"+nomSalle+"'");
		parametres.put("othertable", 
					  " JOIN film ON projection.idFilm = film.id"
					+ " JOIN Salle ON projection.idSalle = Salle.id");
		
		ResultSet resultat = find(parametres);
		try {
			while(resultat.next()) {
				Film film = new Film();
				Projection projection = new Projection();
				Salle salle = new Salle();
				
				film.setTitre(resultat.getString("titre"));
				film.setDuree(resultat.getInt("duree"));
				film.setAnneeSortie(resultat.getDate("annee_sortie"));
				film.setRealisateur(resultat.getString("realisateur"));
				film.setVisaExploitation(resultat.getString("visa_exploitation"));
				
				salle.setNom(resultat.getString("nom"));
	
				projection.setHeure(resultat.getTime("heure"));
				projection.setFilm(film);
				projection.setSalle(salle);
				listeProjection.add(projection);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		closeStatement();
		return listeProjection;		
	}


	public List<Projection> listerSalleFilm(String titreFim, String date){
		List<Projection> listeProjection = new LinkedList<Projection>();
		
		HashMap<String, String> parametres = new HashMap<String, String>();
		parametres.put("fields","nom, heure");
		parametres.put("order", "projection.idSalle DESC");
		parametres.put("othertable", "JOIN salle ON projection.idSalle = salle.id "
								  + " JOIN film ON projection.idFilm = film.id");
		parametres.put("conditions", "DATEDIFF(projection.dateFin,'"+date+"') >= 0 "
								   + "AND  DATEDIFF(projection.dateDebut,'"+date+"') <= 0 "
								  + " AND film.titre = '"+titreFim+"'");
		ResultSet resultat = find(parametres);
		try {
			while(resultat.next()) {
				Projection projection = new Projection();
				Salle salle = new Salle();
				salle.setNom(resultat.getString("nom"));
				projection.setSalle(salle);
				projection.setHeure(resultat.getTime("heure"));
				listeProjection.add(projection);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		closeStatement();
		return listeProjection;
		
	}

}
