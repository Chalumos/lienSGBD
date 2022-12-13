package model;

import java.util.Date;

public class Film {
	String titre;
	int duree;
	String visaExploitation;
	String realisateur;
	Date anneeSortie;

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public String getVisaExploitation() {
		return visaExploitation;
	}

	public void setVisaExploitation(String visaExploitation) {
		this.visaExploitation = visaExploitation;
	}

	public String getRealisateur() {
		return realisateur;
	}

	public void setRealisateur(String realisateur) {
		this.realisateur = realisateur;
	}

	public Date getAnneeSortie() {
		return anneeSortie;
	}

	public void setAnneeSortie(Date anneeSortie) {
		this.anneeSortie = anneeSortie;
	}

	
	
}
