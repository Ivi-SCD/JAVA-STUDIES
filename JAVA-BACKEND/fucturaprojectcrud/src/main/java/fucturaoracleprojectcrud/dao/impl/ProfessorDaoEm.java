package fucturaoracleprojectcrud.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import fucturaoracleprojectcrud.dao.ProfessorDao;
import fucturaprojectcrud.entities.Professor;

public class ProfessorDaoEm implements ProfessorDao {
	
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("fuctura");
	private EntityManager em = emf.createEntityManager();

	@Override
	@Transactional
	public void insert(Professor professor) {
		try {
			em.getTransaction().begin();
			em.persist(professor);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
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
			e.printStackTrace();
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
			e.printStackTrace();
		}
	}

	@Override
	public List<Professor> findAll() {
		TypedQuery <Professor> query = em.createQuery("SELECT professor FROM Professor professor", Professor.class);
		return query.getResultList();
	}
	
	@Override
	public Professor findById(Long id) {
		Professor professor = em.find(Professor.class, id);
		return professor;
	}
	
	@Override
	public void closeConnections() {
		em.close();
		emf.close();
	}
	
	private Professor updateProfessorData(Professor velhoProfessor, Professor novoProfessor) {
		
		velhoProfessor.setNome(novoProfessor.getNome());
		velhoProfessor.setGraduacao(novoProfessor.getGraduacao());
		velhoProfessor.setTelefoneNumero(novoProfessor.getTelefoneNumero());
		
		return velhoProfessor;
	}
}