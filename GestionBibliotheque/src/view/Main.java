package view;

import java.util.Scanner;

import controller.GestionLivre;
import utile.Bdd;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		Bdd.getConnexion();
		showMenu();
		int choix = scanner.nextInt();
		switch (choix) {
		case 1: {
			System.out.println("Titre du livre: ");
			scanner = new Scanner(System.in);
			String titreLivre = scanner.nextLine();
			System.out.println(GestionLivre.AjouterExemplaireLivre(titreLivre));
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
	}
}

