package controller;

public class GestionLivre {
	
	LivreDAO livreDao;
	
	public GestionLivre() {
		livreDao = new LivreDAO("Livre");
	}
	
	public String ajouterExemplaireLivre(String titreLivre) {
		return livreDao.ajoutExemplaire(titreLivre.toLowerCase());
	}
	
	public String ajouterLivre(String titreLivre) {
		return livreDao.ajouterLivre(titreLivre.toLowerCase());
	}

}
