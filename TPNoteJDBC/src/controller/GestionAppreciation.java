package controller;

import java.util.List;

import model.Appreciation;

public class GestionAppreciation {

	AppreciationDAO appreciationDAO;
	
	public GestionAppreciation() {
		appreciationDAO = new AppreciationDAO("appreciation");
	}
	
	public List<Appreciation> afficherAvisFilm(String nomSpectateur) {
		return appreciationDAO.listerAvisFilms(nomSpectateur);
	}
}
