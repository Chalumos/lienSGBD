package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.GestionAssocie;
import controller.GestionLivre;
import model.Associe;
import utile.Bdd;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		Bdd.getConnexion();
		showMenu();
		int choix = scanner.nextInt();
		switch (choix) {
		case 1: {
			GestionLivre controllerLivre = new GestionLivre();
			System.out.println("Titre du livre: ");
			scanner = new Scanner(System.in);
			String titreLivre = scanner.nextLine();
			System.out.println(controllerLivre.ajouterExemplaireLivre(titreLivre));
			break;
		}
		case 2:{
			GestionLivre controllerLivre = new GestionLivre();
			System.out.println("Titre du livre a ajouter: ");
			scanner = new Scanner(System.in);
			String titreLivre = scanner.nextLine();
			System.out.println(controllerLivre.ajouterLivre(titreLivre));
			break;
		}
		case 3: {
			GestionAssocie gestionAssocie = new GestionAssocie();
			showAssocie(gestionAssocie.afficherAssocieEnRetard());
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + choix);
		}
	}
	
	private static void showMenu() {
		System.out.println("choissiez");
		System.out.println("1. Ajouter un exemplaire d'un livre");
		System.out.println("2. Ajouter un livre au catalogue");
		System.out.println("3. Afficher les associes en retard dans leurs prets");
	}
	
	private static void showAssocie(ArrayList<Associe> listeAssocie) {
		if(listeAssocie != null) {
			System.out.println("Associe(s) en retard:");
			for (Associe associe: listeAssocie) {
				System.out.println("1 : "+associe.getNom()+" "+associe.getPrenom());
			}
		}
	}
}

