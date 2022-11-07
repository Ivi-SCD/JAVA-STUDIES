package fucturaprojectcrud.application;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fucturaprojectcrud.entities.Aluno;
import fucturaprojectcrud.entities.Curso;
import fucturaprojectcrud.entities.Disciplina;
import fucturaprojectcrud.entities.Endereco;
import fucturaprojectcrud.entities.Matricula;
import fucturaprojectcrud.entities.Professor;

public class Program {
	public static void main(String [] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("fuctura");
		EntityManager em = emf.createEntityManager();
		
		try {
			
			em.getTransaction().begin();
			
			
			//Instanciando os enderecos
			Endereco e1 = new Endereco("Tv. Coronel Frederico Lundgreen", 50, "Rio Doce", "Olinda", "PE");
			Endereco e2 = new Endereco("Rua Ferreiros", 60, "Paulista", "Olinda", "PE");
			Endereco e3 = new Endereco("Rua Jose Lima", 101, "Paulista", "Olinda", "PE");
			
			//Instanciando os alunos
			Aluno al1 = new Aluno("Ivisson Pereira", "111.222.333-44", "11/11/2011", 'M', e1);
			Aluno al2 = new Aluno("Lucas Martins", "222.333.444-55", "27/05/2003", 'M', e2);
			Aluno al3 = new Aluno("Argus Lima", "333.444.555-66", "06/02/2003", 'M', e3);
			
			//Instanciando os cursos
			Curso c1 = new Curso("Java FullStack Software Developer", 4);
			Curso c2 = new Curso("Formação FullStack Cloud AWS", 4);
			Curso c3 = new Curso("Formação FrontEnd", 2);
			
			//Instanciando os professores
			Professor p1 = new Professor("Aluisio Azevedo", "Bacharelado em CC", "99999-9999");
			Professor p2 = new Professor("Pedro Augusto", "Bacharelado em SI", "88888-8888");
			
			//Instanciando as matriculas
			Matricula m1 = new Matricula(al1, c1);
			Matricula m2 = new Matricula(al2, c2);
			Matricula m3 = new Matricula(al3, c3);
			
			//Instanciando as Disciplinas
			Disciplina d1 = new Disciplina("Java - Operators e Arithmetic Expressions", c1, p1);
			Disciplina d2 = new Disciplina("Java - POO", c1, p1);
			Disciplina d3 = new Disciplina("Java - Collections", c1, p2);
			Disciplina d4 = new Disciplina("Java - JPA/Hibernate", c1, p1);
			
			List <Endereco> le = Arrays.asList(e1,e2,e3);
			List <Aluno> la = Arrays.asList(al1,al2,al3);
			List <Curso> lc = Arrays.asList(c1,c2,c3);
			List <Professor> lp = Arrays.asList(p1,p2);
			List <Matricula> lm = Arrays.asList(m1,m2,m3);
			List <Disciplina> ld = Arrays.asList(d1,d2,d3,d4);
			/*
			// Create/Update
			le.forEach(em::persist);
			la.forEach(em::persist);
			lc.forEach(em::persist);
			lp.forEach(em::persist);
			
			lm.forEach(em::merge);
			ld.forEach(em::merge);
			
			*/
			em.getTransaction().commit();
			
		} catch(Exception e ) {
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}
	}
}