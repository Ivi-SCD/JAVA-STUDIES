package fucturaprojectcrud.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import fucturaoracleprojectcrud.db.DbNotFoundException;
import fucturaprojectcrud.dao.CursoDao;
import fucturaprojectcrud.entities.Curso;

public class CursoDaoEm implements CursoDao {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("fuctura");
	private EntityManager em = emf.createEntityManager();

	@Override
	@Transactional
	public void insert(Curso curso) {
		try {
			em.getTransaction().begin();
			em.persist(curso);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteById(Long id) {
		try {
			em.getTransaction().begin();
			
			Query query1 = em.createNativeQuery("DELETE FROM TB_MATRICULA WHERE curso_id = " + id);
			Query query2 = em.createNativeQuery("DELETE FROM TB_DISCIPLINA WHERE curso_id = " + id);
			
			query1.executeUpdate();
			query2.executeUpdate();
			
			Curso curso = findById(id);
			em.remove(curso);
			
			em.getTransaction().commit();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	@Transactional
	public void updateCurso(Long id, Curso novoCurso) {
		try {
			em.getTransaction().begin();
			
			Curso curso = updateCursoData(findById(id), novoCurso);
			em.merge(curso);
			
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Curso> findAll() {
		TypedQuery <Curso> query = em.createQuery("SELECT curso FROM Curso curso", Curso.class);
		return query.getResultList();
	}

	@Override
	public Curso findById(Long id) {
		Curso curso = em.find(Curso.class, id);
		if(curso == null) {
			throw new DbNotFoundException(id);
		}
		return curso;
	}
	
	@Override
	public void closeConnections() {
		em.close();
		emf.close();
	}
	
	private Curso updateCursoData(Curso velhoCurso, Curso novoCurso) {
		
		velhoCurso.setNome(novoCurso.getNome());
		velhoCurso.setSemestres(novoCurso.getSemestres());
		
		return velhoCurso;
	}
}