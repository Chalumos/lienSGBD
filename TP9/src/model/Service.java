package model;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.processing.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Service {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int code;
	private String nom;
	private int nombreLits;
	
	@OneToMany(mappedBy = "serviceInfirmier")
	private List<Infirmier> infirmiers;
	
	@OneToOne
	private Docteur directeur;
	
	@OneToMany(mappedBy = "serviceSalle")
	private List<Salle> salles;
	
	@ManyToOne()
	private Hopital hopitalService;
	
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getNombreLits() {
		return nombreLits;
	}
	public void setNombreLits(int nombreLits) {
		this.nombreLits = nombreLits;
	}
	public Docteur getDirecteur() {
		return directeur;
	}
	public void setDirecteur(Docteur directeur) {
		this.directeur = directeur;
	}
	public List<Salle> getSalles() {
		return salles;
	}
	public void setSalles(List<Salle> salles) {
		this.salles = salles;
	}
	
	
}
