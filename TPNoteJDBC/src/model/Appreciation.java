package model;

public class Appreciation {
	Spectateur spectateur;
	Film film;
	String note;
	public Spectateur getSpectateur() {
		return spectateur;
	}
	public void setSpectateur(Spectateur spectateur) {
		this.spectateur = spectateur;
	}
	public Film getFilm() {
		return film;
	}
	public void setFilm(Film film) {
		this.film = film;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
}
