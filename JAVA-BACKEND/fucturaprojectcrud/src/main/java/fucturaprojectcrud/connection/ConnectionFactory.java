package fucturaprojectcrud.connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionFactory {
		
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("fuctura");
	
	@Deprecated
	public ConnectionFactory () {
	}
	
	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
	
	public static void closeConnections() {
		emf.close();
	}
}