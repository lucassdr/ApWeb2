package modelo.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	private static EntityManagerFactory sicre;
	
	static {
		sicre = Persistence.createEntityManagerFactory("banco");
	}
	
	public static EntityManager getEntityManager() {
		return sicre.createEntityManager();
	}

}
