package controller;

import java.util.ArrayList;

import model.Associe;

public class GestionAssocie {
	
	AssocieDAO associeDao;
	
	public GestionAssocie() {
		associeDao = new AssocieDAO("associe");
	}
	
	public ArrayList<Associe> afficherAssocieEnRetard() {
		return associeDao.trouverAssocieEnRetard();
	}

}
