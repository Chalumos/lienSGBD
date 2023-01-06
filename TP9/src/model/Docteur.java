package model;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Docteur extends Employe{
	
	@OneToOne(mappedBy = "directeur")
	private Service specialite;
	
	@OneToMany(mappedBy = "docteur")
	private ArrayList<Malade> malades;

	public Service getSpecialite() {
		return specialite;
	}

	public void setSpecialite(Service specialite) {
		this.specialite = specialite;
	}

	public ArrayList<Malade> getMalades() {
		return malades;
	}

	public void setMalades(ArrayList<Malade> malades) {
		this.malades = malades;
	}
	
	
	
}
