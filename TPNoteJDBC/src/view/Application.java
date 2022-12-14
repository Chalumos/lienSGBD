package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import controller.GestionAppreciation;
import controller.GestionFilm;
import model.Appreciation;
import model.Film;
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
			GestionAppreciation gestionAvis = new GestionAppreciation();
			System.out.println("Spectateur: ");
			scanner = new Scanner(System.in);
			String nomSpectateur = scanner.nextLine();
			showAppreciation(gestionAvis.afficherAvisFilm(nomSpectateur), nomSpectateur);
			break;
		}
		case 2: {
			GestionFilm gestionFilm=new GestionFilm();
			System.out.println("Salle: ");
			scanner = new Scanner(System.in);
			String nomSalle = scanner.nextLine();
			showFilms(gestionFilm.afficherListeProjections(nomSalle),nomSalle);
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + choix);
		}
	}
	
	private static void showMenu() {
		System.out.println("choissiez");
		System.out.println("1. Affichage des avis sur les films vu par un spectateur");
		System.out.println("2. Affichage liste films projete pour une salle ");
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
	
	private static void showFilms(List<Projection> listeProjections,String nomSalle) {
		if(listeProjections.size()<=0) {
			System.out.println("Aucun film prevu aujourd'hui dans cette salle.");
		}
		else {
			System.out.println("Les films prevu aujourd hui dans la salle "+nomSalle +" sont :");
			for(Projection projection:listeProjections){
				System.out.println(projection.getFilm().getTitre()+" a "+projection.getHeure());
			}
		}
	}
}

