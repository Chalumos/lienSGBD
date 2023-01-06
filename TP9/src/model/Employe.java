package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employe extends Person {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer numEmploye;

	
	public Integer getNumEmploye() {
		return numEmploye;
	}
	public void setNumEmploye(Integer numEmploye) {
		this.numEmploye = numEmploye;
	}

}
