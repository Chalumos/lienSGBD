package view;

import java.util.List;
import java.util.Scanner;

import controller.GestionAppreciation;
import controller.GestionProjection;
import model.Appreciation;
import model.Projection;
import utile.Bdd;

public class Application {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		Bdd.getConnexion();
		showMenu();
		int choix = scanner.nextInt();
		switch (choix) {
		case 1: {
			scanner = new Scanner(System.in);
			GestionAppreciation gestionAvis = new GestionAppreciation();
			System.out.println("Spectateur: ");
			String nomSpectateur = scanner.nextLine();
			showAppreciation(gestionAvis.afficherAvisFilm(nomSpectateur), nomSpectateur);
			break;
		}
		case 3: {
			scanner = new Scanner(System.in);
			GestionProjection gestionSalle = new GestionProjection();
			System.out.println("Date pour aller voir le film:  (format jj/MM/AAAA)");
			String date = scanner.nextLine();
			System.out.println("Titre du film: ");
			String titreFilm = scanner.nextLine();
			showSallesFilm(gestionSalle.afficherSalleFilm(date, titreFilm), titreFilm, date);
			
			break;
		}
		default:
			throw new IllegalArgumentException("choix impossible: " + choix);
		}
	}
	
	private static void showMenu() {
		System.out.println("choissiez");
		System.out.println("1. Affichage des avis sur les films vu par un spectateur");
		System.out.println("2. Affichage liste films projeté pour une salle ");
		System.out.println("3. Afficher les associes en retard dans leurs prets");
	}
	
	private static void showAppreciation(List<Appreciation> listeAppreciation, String nomSpectateur) {
		if(listeAppreciation.size() <= 0) {
			System.out.println(nomSpectateur + " ne nous a laisser aucun avis :(");
		}
		else {
			System.out.println("Listes des Avis par film pour "+nomSpectateur);
			for(Appreciation appreciation : listeAppreciation) {
				System.out.println(appreciation.getFilm().getTitre()  +": "+appreciation.getNote());
			}
		}
	}
	
	private static void showSallesFilm(List<Projection> listeProjection, String nomFilm, String date) {
		if(listeProjection.size() <= 0) {
			System.out.println("Il n'y a pas de projection pour "+nomFilm+" le "+date);
		}
		else {
			System.out.println("Listes des salles pour aller voir "+nomFilm+" le "+date);
			for(Projection projection : listeProjection) {
				System.out.println("En "+projection.getSalle().getNom() +" à "+projection.getHeure());
			}
		}
	}
}

