package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Docteur extends Employe{
	
	@OneToOne(mappedBy = "directeur")
	private Service specialite;
	
	@OneToMany(mappedBy = "docteur")
	private List<Malade> malades;

	public Service getSpecialite() {
		return specialite;
	}

	public void setSpecialite(Service specialite) {
		this.specialite = specialite;
	}

	public List<Malade> getMalades() {
		return malades;
	}

	public void setMalades(List<Malade> malades) {
		this.malades = malades;
	}

	@Override
	public String toString() {
		return this.getNom();
	}
	
	
	
	
	
}
