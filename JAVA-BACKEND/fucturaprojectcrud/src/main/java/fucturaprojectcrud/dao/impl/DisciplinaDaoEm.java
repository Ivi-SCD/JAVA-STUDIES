package fucturaprojectcrud.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import fucturaprojectcrud.connection.ConnectionFactory;
import fucturaprojectcrud.dao.DisciplinaDao;
import fucturaprojectcrud.db.DbNotFoundException;
import fucturaprojectcrud.db.DbPersistenceException;
import fucturaprojectcrud.db.DbUnexpectedException;
import fucturaprojectcrud.entities.Disciplina;

public class DisciplinaDaoEm implements DisciplinaDao {
	
	EntityManager em = ConnectionFactory.getEntityManager();

	@Override
	@Transactional
	public void insert(Disciplina disciplina) {
		try {
			em.getTransaction().begin();
			em.merge(disciplina);
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
			
			Disciplina disciplina = findById(id);
			em.remove(disciplina);
			
			em.getTransaction().commit();
		} catch(Exception e) {
			throw new DbUnexpectedException(e.getMessage());
		}
	}

	@Override
	@Transactional
	public void updateDisciplina(Long id, Disciplina novaDisciplina) {
		try {
			em.getTransaction().begin();
			
			Disciplina disciplina = updateDisciplinaData(findById(id), novaDisciplina);
			em.merge(disciplina);
			
			em.getTransaction().commit();
		} catch (Exception e) {
			throw new DbUnexpectedException(e.getMessage());
		}
	}

	@Override
	public List<Disciplina> findAll() {
		try {
			TypedQuery <Disciplina> query = em.createQuery("SELECT disciplina FROM Disciplina disciplina", Disciplina.class);
			if(query.getResultList().isEmpty()) {
				throw new DbNotFoundException("List of Type <" + Disciplina.class + ">");
			}
			return query.getResultList();
		} catch (Exception e) {
			throw new DbUnexpectedException(e.getMessage());
		}
	}
	
	@Override
	public Disciplina findById(Long id) {
		Disciplina disciplina = em.find(Disciplina.class, id);
		if(disciplina == null) {
			throw new DbNotFoundException(id);
		}
		return disciplina;
	}
	
	@Override
	public void closeConnections() {
		em.close();
		ConnectionFactory.closeConnections();
	}
	
	private Disciplina updateDisciplinaData(Disciplina velhaDisciplina, Disciplina novaDisciplina) {
		velhaDisciplina.setNome(novaDisciplina.getNome());
		velhaDisciplina.setCurso(novaDisciplina.getCurso());
		velhaDisciplina.setProfessores(novaDisciplina.getProfessores());
		
		return velhaDisciplina;
	}
}