package fucturaprojectcrud.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import fucturaprojectcrud.connection.ConnectionFactory;
import fucturaprojectcrud.dao.ProfessorDao;
import fucturaprojectcrud.db.DbNotFoundException;
import fucturaprojectcrud.db.DbPersistenceException;
import fucturaprojectcrud.db.DbUnexpectedException;
import fucturaprojectcrud.entities.Professor;

public class ProfessorDaoEm implements ProfessorDao {
	
	EntityManager em = ConnectionFactory.getEntityManager();

	@Override
	@Transactional
	public void insert(Professor professor) {
		try {
			em.getTransaction().begin();
			em.persist(professor);
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
			
			Query query = em.createNativeQuery("DELETE FROM TB_DISCIPLINA WHERE professor_id = " + id);
			query.executeUpdate();
			
			Professor professor = findById(id);
			em.remove(professor);
			
			em.getTransaction().commit();
		} catch(Exception e) {
			throw new DbUnexpectedException(e.getMessage());
		}
	}

	@Override
	@Transactional
	public void updateProfessor(Long id, Professor novoProfessor) {
		try {
			em.getTransaction().begin();
			
			Professor professor = updateProfessorData(findById(id), novoProfessor);
			em.merge(professor);
			
			em.getTransaction().commit();
		} catch (Exception e) {
			throw new DbUnexpectedException(e.getMessage());
		}
	}

	@Override
	public List<Professor> findAll() {
		try {
			TypedQuery <Professor> query = em.createQuery("SELECT professor FROM Professor professor", Professor.class);
			if(query.getResultList().isEmpty()) {
				throw new DbNotFoundException("List of Type <" + Professor.class + ">");
			}
			return query.getResultList();
		} catch (Exception e) {
			throw new DbUnexpectedException(e.getMessage());
		}
	}
	
	@Override
	public Professor findById(Long id) {
		Professor professor = em.find(Professor.class, id);
		if(professor == null) {
			throw new DbNotFoundException(id);
		}
		return professor;
	}
	
	@Override
	public void closeConnections() {
		em.close();
		ConnectionFactory.closeConnections();
	}
	
	private Professor updateProfessorData(Professor velhoProfessor, Professor novoProfessor) {
		velhoProfessor.setNome(novoProfessor.getNome());
		velhoProfessor.setGraduacao(novoProfessor.getGraduacao());
		velhoProfessor.setTelefoneNumero(novoProfessor.getTelefoneNumero());
		
		return velhoProfessor;
	}
}