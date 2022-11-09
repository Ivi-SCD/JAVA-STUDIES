package fucturaprojectcrud.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import fucturaprojectcrud.connection.ConnectionFactory;
import fucturaprojectcrud.dao.MatriculaDao;
import fucturaprojectcrud.db.DbNotFoundException;
import fucturaprojectcrud.db.DbPersistenceException;
import fucturaprojectcrud.db.DbUnexpectedException;
import fucturaprojectcrud.entities.Matricula;

public class MatriculaDaoEm implements MatriculaDao {

	EntityManager em = ConnectionFactory.getEntityManager();
	
	@Override
	public void insert(Matricula matricula) {
		try {
			em.getTransaction().begin();
			em.merge(matricula);
			em.getTransaction().commit();
		} catch (PersistenceException e) {
			throw new DbPersistenceException(e.getMessage());
		} catch (Exception e) {
			throw new DbUnexpectedException(e.getMessage());
		}
	}
	
	@Override
	public List <Matricula> findAll() {
		try {
			TypedQuery <Matricula> query = em.createQuery("SELECT matricula FROM Matricula matricula", Matricula.class);
			if(query.getResultList().isEmpty()) {
				throw new DbNotFoundException("List of Type <" + Matricula.class + ">");
			}
			return query.getResultList();
		} catch(Exception e) {
			throw new DbUnexpectedException(e.getMessage());
		}
	}
	
	@Override
	public Matricula findById(Long id) {
		Matricula matricula = em.find(Matricula.class, id);
		if (matricula == null) {
			throw new DbNotFoundException(id);
		}
		return matricula;
	}
	
	@Override
	public void closeConnections() {
		em.close();
		ConnectionFactory.closeConnections();
	}
}