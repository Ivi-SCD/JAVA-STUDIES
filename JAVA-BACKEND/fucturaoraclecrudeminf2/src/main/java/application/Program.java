package application;

import domain.entities.Book;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Program {
	public static void main(String [] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("oraclejpa");
//		EntityManager em = emf.createEntityManager();
//		
//		
//		Book b1 = new Book(1, "Dracula", "Bram Stroker", "Terror");
//		
//		b1 = em.find(Book.class, 1);
//		System.out.println(b1.toString());
	}
}