package fucturaprojectcrud.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fucturaoracleprojectcrud.db.DbNotFoundException;
import fucturaprojectcrud.dao.MatriculaDao;
import fucturaprojectcrud.entities.Matricula;

public class MatriculaDaoEm implements MatriculaDao {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("fuctura");
	private EntityManager em = emf.createEntityManager();
	
	@Override
	public void insert(Matricula matricula) {
		try {
			em.getTransaction().begin();
			em.merge(matricula);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	@Override
	public List <Matricula> findAll() {
		TypedQuery <Matricula> query = em.createQuery("SELECT matricula FROM Matricula matricula", Matricula.class);
		return query.getResultList();
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
		emf.close();
	}
	
}