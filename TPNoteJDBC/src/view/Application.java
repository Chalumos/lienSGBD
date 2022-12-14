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
		String fin = "";
		
		Bdd.getConnexion();
		while(!fin.equals("non")) {
			showMenu();
			try{
				int choix = scanner.nextInt();
			switch (choix) {
			case 0: {
				Bdd.creerJeuDeDonnee();
				System.out.println("Jeu de donnees cree");
				break;
			}
			case 1: {
				scanner = new Scanner(System.in);
				GestionAppreciation gestionAvis = new GestionAppreciation();
				System.out.println("Spectateur: ");
				String nomSpectateur = scanner.nextLine();
				showAppreciation(gestionAvis.afficherAvisFilm(nomSpectateur), nomSpectateur);
				break;
			}
			case 2: {
				GestionProjection gestionProjection =new GestionProjection();
				System.out.println("Salle: ");
				scanner = new Scanner(System.in);
				String nomSalle = scanner.nextLine();
				showFilms(gestionProjection.afficherListeProjections(nomSalle),nomSalle);
				break;
			}
			case 3: {
				scanner = new Scanner(System.in);
				GestionProjection gestionProjection = new GestionProjection();
				System.out.println("Date pour aller voir le film:  (format jj/MM/AAAA)");
				String date = scanner.nextLine();
				System.out.println("Titre du film: ");
				String titreFilm = scanner.nextLine();
				showSallesFilm(gestionProjection.afficherSalleFilm(date, titreFilm), titreFilm, date);
				break;
			}
			default:
				System.out.println("choix impossible: "+choix);
				break;
			}
			}catch (Exception e) {
				System.out.println("\nrenter un entier !");
			}
			scanner = new Scanner(System.in);
			System.out.println("\nReafficher le menu ? (''non'' pour arreter)");
			fin = scanner.nextLine();
		}
	}
	
	private static void showMenu() {
		System.out.println("choissiez");
		System.out.println("0. Creation du jeu de donnees dans database cinema");
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
	
	private static void showSallesFilm(List<Projection> listeProjection, String nomFilm, String date) {
		if(listeProjection.size() <= 0) {
			System.out.println("Il n'y a pas de projection pour "+nomFilm+" le "+date);
		}
		else {
			System.out.println("Listes des salles pour aller voir "+nomFilm+" le "+date);
			for(Projection projection : listeProjection) {
				System.out.println("En "+projection.getSalle().getNom() +" a "+projection.getHeure());
			}
		}
	}
}

