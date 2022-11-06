package fucturaprojectcrud.application;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fucturaprojectcrud.entities.Aluno;
import fucturaprojectcrud.entities.Curso;
import fucturaprojectcrud.entities.Endereco;
import fucturaprojectcrud.entities.Matricula;

public class Program {
	public static void main(String [] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("fuctura");
		EntityManager em = emf.createEntityManager();
		
		 
		try {
			em.getTransaction().begin();
			
			
			Endereco e1 = new Endereco("Tv. Coronel Frederico Lundgreen", 50, "Rio Doce", "Olinda", "PE");
			
			Aluno al1 = new Aluno("Ivisson Pereira", "134.825.084-45", "11/12/2003", 'M', e1);
			
			Curso c1 = new Curso("Java FullStack Software Developer", 4);
			Curso c2 = new Curso("Formação FullStack Cloud AWS", 4);
			
			Matricula m1 = new Matricula(al1, c2);
			
			List <Curso> lc = Arrays.asList(c1,c2);
			List <Aluno> la = Arrays.asList(al1);
			List <Endereco> le = Arrays.asList(e1);
			
			lc.forEach(em::persist);
			la.forEach(em::persist);
			le.forEach(em::persist);
			lc.forEach(em::merge);
			la.forEach(em::merge);
			le.forEach(em::merge);
			
			em.persist(m1);
			em.merge(m1);

			em.getTransaction().commit();
			
		} catch(Exception e ) {
			e.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}
	}
}