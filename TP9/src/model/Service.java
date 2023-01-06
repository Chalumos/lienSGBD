package model;

import java.util.ArrayList;

import javax.annotation.processing.Generated;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Service {
	@Id
	private int code;
	private String nom;
	private int nombreLits;
	private Docteur directeur;
	private ArrayList<Salle> salles;
	
	
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
	public ArrayList<Salle> getSalles() {
		return salles;
	}
	public void setSalles(ArrayList<Salle> salles) {
		this.salles = salles;
	}
	
	
}
