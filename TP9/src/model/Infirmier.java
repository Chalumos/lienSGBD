package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Infirmier extends Employe{
	
	@OneToOne
	private Salle salleInfirmier;
	
	@ManyToOne
	private Service serviceInfirmier;
	
	public Service getService() {
		return serviceInfirmier;
	}
	public void setService(Service service) {
		this.serviceInfirmier = service;
	}
	public Salle getSalle() {
		return salleInfirmier;
	}
	public void setSalle(Salle salle) {
		this.salleInfirmier = salle;
	}
	
}
