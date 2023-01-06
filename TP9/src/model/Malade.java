package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Malade extends Person {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer numMalade;

	public Integer getNumMalade() {
		return numMalade;
	}

	public void setNumMalade(Integer numMalade) {
		this.numMalade = numMalade;
	}
	
	
}
