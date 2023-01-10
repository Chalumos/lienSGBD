package utile;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GestionHibernate {
	
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager em;
	
	public static void initialiserConnexion() {
		entityManagerFactory = Persistence.createEntityManagerFactory("tp9");
		em = entityManagerFactory.createEntityManager();
	}

	public static EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

	public static void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		GestionHibernate.entityManagerFactory = entityManagerFactory;
	}

	public static EntityManager getEm() {
		return em;
	}

	public static void setEm(EntityManager em) {
		GestionHibernate.em = em;
	}
	
	

}
