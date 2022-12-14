package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import model.Appreciation;
import model.Film;
import model.Projection;
import model.Salle;
import model.Spectateur;

public class FilmDAO extends Dao{

	public FilmDAO(String tableBdd) {
		super(tableBdd);
	}

	public List<Projection> listerFilms(String nomSalle) {
		List<Projection> listeProjection = new LinkedList<Projection>();
		
		HashMap<String, String> parametres = new HashMap<String, String>();
		parametres.put("conditions", "Salle.nom = '"+nomSalle+"'");
		parametres.put("othertable", 
					  " JOIN projection ON film.id  = projection.idFilm"
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

}
