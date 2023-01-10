package controller;

import model.Docteur;
import utile.GestionHibernate;

public class DocteurDAO {
	public static Docteur creerDocteur(String nom, String prenom, String numTel, String adresse) {
		Docteur docteur = new Docteur();
		
		docteur.setNom(nom);
		docteur.setPrenom(prenom);
		docteur.setNumTelephone(numTel);
		docteur.setAdresse(adresse);
//		docteur.setSpecialite(null);
//		docteur.setMalades(null);
		
		GestionHibernate.getEm().getTransaction().begin();
		GestionHibernate.getEm().persist(docteur);
		GestionHibernate.getEm().getTransaction().commit();

		return docteur;
		
	}

}
