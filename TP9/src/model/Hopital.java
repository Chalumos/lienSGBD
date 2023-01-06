package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

public class Hopital {
	
	@OneToMany(mappedBy = "hopitalEmploye")
	List<Employe> listeEmploye;
	
	@OneToMany(mappedBy = "hopitalService")
	List<Service> listeService;
}
