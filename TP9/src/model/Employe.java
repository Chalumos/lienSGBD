package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Employe extends Person {
//	@Id
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
