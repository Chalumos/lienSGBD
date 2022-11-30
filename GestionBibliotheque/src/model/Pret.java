package model;

import java.time.LocalDate;

public class Pret {
	private Livre livre;
	private Associe associe;
	private LocalDate dateEmprunt;
	private LocalDate dureeEmprunt;
	
	
	public Livre getLivre() {
		return livre;
	}
	public void setLivre(Livre livre) {
		this.livre = livre;
	}
	public Associe getAssocie() {
		return associe;
	}
	public void setAssocie(Associe associe) {
		this.associe = associe;
	}
	public LocalDate getDateEmprunt() {
		return dateEmprunt;
	}
	public void setDateEmprunt(LocalDate dateEmprunt) {
		this.dateEmprunt = dateEmprunt;
	}
	public LocalDate getDureeEmprunt() {
		return dureeEmprunt;
	}
	public void setDureeEmprunt(LocalDate dureeEmprunt) {
		this.dureeEmprunt = dureeEmprunt;
	}
	
	
}
