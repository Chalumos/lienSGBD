package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Employe extends Person {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer numEmploye;
	
	@ManyToOne()
	Hopital hopitalEmploye;
	
	public Integer getNumEmploye() {
		return numEmploye;
	}
	public void setNumEmploye(Integer numEmploye) {
		this.numEmploye = numEmploye;
	}

}
