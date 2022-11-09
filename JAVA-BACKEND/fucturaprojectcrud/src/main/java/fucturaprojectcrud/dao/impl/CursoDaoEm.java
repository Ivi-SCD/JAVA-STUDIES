package fucturaprojectcrud.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import fucturaprojectcrud.connection.ConnectionFactory;
import fucturaprojectcrud.dao.CursoDao;
import fucturaprojectcrud.db.DbNotFoundException;
import fucturaprojectcrud.db.DbPersistenceException;
import fucturaprojectcrud.db.DbUnexpectedException;
import fucturaprojectcrud.entities.Curso;

public class CursoDaoEm implements CursoDao {

	EntityManager em = ConnectionFactory.getEntityManager();
	
	@Override
	@Transactional
	public void insert(Curso curso) {
		try {
			em.getTransaction().begin();
			em.persist(curso);
			em.getTransaction().commit();
		} catch (PersistenceException e) {
			throw new DbPersistenceException(e.getMessage());
		} catch (Exception e) {
			throw new DbUnexpectedException(e.getMessage());
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
			throw new DbUnexpectedException(e.getMessage());
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
			throw new DbUnexpectedException(e.getMessage());
		}
	}

	@Override
	public List<Curso> findAll() {
		try {
		TypedQuery <Curso> query = em.createQuery("SELECT curso FROM Curso curso", Curso.class);
		if(query.getResultList().isEmpty()) {
			throw new DbNotFoundException("List of Type <" + Curso.class + ">");
		}
		return query.getResultList();
		} catch (Exception e) {
			throw new DbUnexpectedException(e.getMessage());
		}
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
		ConnectionFactory.closeConnections();
	}
	
	private Curso updateCursoData(Curso velhoCurso, Curso novoCurso) {
		velhoCurso.setNome(novoCurso.getNome());
		velhoCurso.setSemestres(novoCurso.getSemestres());
		
		return velhoCurso;
	}
}