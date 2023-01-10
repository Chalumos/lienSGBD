package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Hopital {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idHopital;
	
	@OneToMany(mappedBy = "hopitalEmploye")
	List<Employe> listeEmploye;
	
	@OneToMany(mappedBy = "hopitalService")
	List<Service> listeService;
}
