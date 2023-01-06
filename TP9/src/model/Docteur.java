package model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Docteur extends Employe{
	@OneToOne
	private Service specialite;

	public Service getSpecialite() {
		return specialite;
	}

	public void setSpecialite(Service specialite) {
		this.specialite = specialite;
	}
	
	
}
