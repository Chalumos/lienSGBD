package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import model.Projection;
import model.Salle;

public class ProjectionDAO extends Dao{

	public ProjectionDAO(String tableBdd) {
		super(tableBdd);
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
