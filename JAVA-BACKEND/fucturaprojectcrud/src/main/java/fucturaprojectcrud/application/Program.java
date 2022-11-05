package fucturaprojectcrud.application;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fucturaprojectcrud.entities.Aluno;
import fucturaprojectcrud.entities.Endereco;

public class Program {
	public static void main(String [] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("fuctura");
		EntityManager em = emf.createEntityManager();
		
		 
		try {
			em.getTransaction().begin();
			
			
			Endereco e1 = new Endereco("Tv. Coronel Frederico Lundgreen", 50, "Rio Doce", "Olinda", "PE");
			Aluno al1 = new Aluno("Ivisson Pereira", "134.825.084-45", "11/12/2003", 'M', e1);
			
			
			em.merge(al1);
			
			
			em.getTransaction().commit();
		} catch(Exception e ) {
			e.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}
	}
}