package model;

import java.util.ArrayList;
import java.util.List;

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
	private Service serviceSalle;
	
<<<<<<< HEAD
	@OneToOne(mappedBy = "salleInfirmier")
	private Infirmier surveillant;
	
	@OneToMany(mappedBy = "salleMalade")
	private List<Malade> malades;
=======
	@OneToOne(mappedBy = "salle")
	private Infirmier survellant;
	
	@OneToMany(mappedBy = "salle")
	private ArrayList<Malade> malades;
>>>>>>> a74c89da98faf6a25aa4c1b068ae8498793838bd
	
	
	public Service getService() {
		return serviceSalle;
	}
	public void setService(Service service) {
		this.serviceSalle = service;
	}
	public List<Malade> getMalades() {
		return malades;
	}
	public void setMalades(List<Malade> malades) {
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
		return surveillant;
	}
	public void setSurvellant(Infirmier survellant) {
		this.surveillant = survellant;
	}
	public int getNombreLits() {
		return nombreLits;
	}
	public void setNombreLits(int nombreLits) {
		this.nombreLits = nombreLits;
	}
	
	
}
