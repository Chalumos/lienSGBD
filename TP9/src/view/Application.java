package view;

import java.util.Scanner;

import controller.DocteurDAO;
import model.Docteur;
import utile.GestionHibernate;

public class Application {

	public static void main(String[] args) {
		
		GestionHibernate.initialiserConnexion();
		//demander au prof si on peut close la co 
		// pk numEmploye pas incrémenté ????
		
		try (Scanner scanner = new Scanner(System.in)) {
			menuChoix();
			
			int choix = scanner.nextInt();
			switch (choix) {
			case 0: {
				creerDocteur();
				break;
			}
			default:
				System.out.println("choix impossible: "+choix);
				break;
			}
		}

	}
	
	public static void menuChoix() {
		System.out.println("Choix du menu:");
		System.out.println("0: Creation docteur");
	}
	
	public static void creerDocteur() {
		try (Scanner saisie = new Scanner(System.in)) {
			System.out.println("nom");
			String nom = saisie.nextLine();
			System.out.println("prenom");
			String prenom = saisie.nextLine();
			System.out.println("numero de telephone");
			String numTel = saisie.nextLine();
			System.out.println("adresse");
			String adresse = saisie.nextLine();
			Docteur docteur = DocteurDAO.creerDocteur(nom, prenom, numTel, adresse);
			System.out.println(docteur +" bien cree");
		}
	}

}
