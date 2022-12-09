package controller;

public class GestionLivre {
	public static String AjouterExemplaireLivre(String titreLivre) {
		//LivreDAO.voirCatalogue();
		//return null;
		return LivreDAO.ajoutExemplaire(titreLivre.toLowerCase());
	}

}
