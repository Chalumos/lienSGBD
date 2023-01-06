package model;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Salle {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private int num;
	private int nombreLits;
	
	@ManyToOne
	private Service service;
	
	@OneToOne(mappedBy = "salle")
	private Infirmier survellant;
	
	@OneToMany(mappedBy = "salle")
	private ArrayList<Malade> malades;
	
	
	public Service getService() {
		return service;
	}
	public void setService(Service service) {
		this.service = service;
	}
	public ArrayList<Malade> getMalades() {
		return malades;
	}
	public void setMalades(ArrayList<Malade> malades) {
		this.malades = malades;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public Infirmier getSurvellant() {
		return survellant;
	}
	public void setSurvellant(Infirmier survellant) {
		this.survellant = survellant;
	}
	public int getNombreLits() {
		return nombreLits;
	}
	public void setNombreLits(int nombreLits) {
		this.nombreLits = nombreLits;
	}
	
	
}
