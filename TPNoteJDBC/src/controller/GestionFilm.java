package controller;

import java.util.List;

import model.Appreciation;
import model.Film;
import model.Projection;

public class GestionFilm {
	
	private FilmDAO filmDAO;
	
	public GestionFilm() {
		filmDAO = new FilmDAO("film");
	}
	
	public List<Projection> afficherListeProjections(String nomSalle) {
			return filmDAO.listerFilms(nomSalle);
	}
}
