package view;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Application {

	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tp8");
		EntityManager em = entityManagerFactory.createEntityManager();
		
		
		em.getTransaction().begin();
		//em.persist(tr);
		em.getTransaction().commit();

	}

}
