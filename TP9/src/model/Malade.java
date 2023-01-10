package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Malade extends Person {
//	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer numMalade;
	
	@ManyToOne()
<<<<<<< HEAD
	private Salle salleMalade;
=======
	private Salle salle;
>>>>>>> a74c89da98faf6a25aa4c1b068ae8498793838bd
	
	@ManyToOne()
	private Docteur docteur;

	public Integer getNumMalade() {
		return numMalade;
	}

	public void setNumMalade(Integer numMalade) {
		this.numMalade = numMalade;
	}

	public Salle getSalle() {
		return salleMalade;
	}

	public void setSalle(Salle salle) {
		this.salleMalade = salle;
	}

	public Docteur getDocteur() {
		return docteur;
	}

	public void setDocteur(Docteur docteur) {
		this.docteur = docteur;
	}
	
	
}
