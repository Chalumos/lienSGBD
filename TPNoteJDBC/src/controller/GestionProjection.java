package controller;

import java.util.List;

import model.Projection;

public class GestionProjection {

	ProjectionDAO projectionDAO;
	
	public GestionProjection() {
		projectionDAO = new ProjectionDAO("projection");
	}
	
	public List<Projection> afficherListeProjections(String nomSalle) {
		return projectionDAO.listerFilms(nomSalle);
	}
	
	public List<Projection> afficherSalleFilm(String date, String titreFilm) {
		String dateAnglaise = date.substring(6,10)+"-"+date.substring(3,5)+"-"+date.substring(0,2);
		return projectionDAO.listerSalleFilm(titreFilm, dateAnglaise);
	}
}
