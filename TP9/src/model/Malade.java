package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Malade extends Person {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer numMalade;
	
	@ManyToOne
	private Salle salle;
	
	@ManyToOne
	private Docteur docteur;

	public Integer getNumMalade() {
		return numMalade;
	}

	public void setNumMalade(Integer numMalade) {
		this.numMalade = numMalade;
	}

	public Salle getSalle() {
		return salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}

	public Docteur getDocteur() {
		return docteur;
	}

	public void setDocteur(Docteur docteur) {
		this.docteur = docteur;
	}
	
	
}
