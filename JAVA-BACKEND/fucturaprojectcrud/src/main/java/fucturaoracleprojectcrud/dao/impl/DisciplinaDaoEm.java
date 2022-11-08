package fucturaoracleprojectcrud.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import fucturaoracleprojectcrud.dao.DisciplinaDao;
import fucturaoracleprojectcrud.db.DbNotFoundException;
import fucturaprojectcrud.entities.Disciplina;

public class DisciplinaDaoEm implements DisciplinaDao {
	
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("fuctura");
	private EntityManager em = emf.createEntityManager();

	@Override
	@Transactional
	public void insert(Disciplina disciplina) {
		try {
			em.getTransaction().begin();
			em.merge(disciplina);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
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
			e.printStackTrace();
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
			e.printStackTrace();
		}
	}

	@Override
	public List<Disciplina> findAll() {
		TypedQuery <Disciplina> query = em.createQuery("SELECT disciplina FROM Disciplina disciplina", Disciplina.class);
		return query.getResultList();
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
		emf.close();
	}
	
	private Disciplina updateDisciplinaData(Disciplina velhaDisciplina, Disciplina novaDisciplina) {
		
		velhaDisciplina.setNome(novaDisciplina.getNome());
		velhaDisciplina.setCurso(novaDisciplina.getCurso());
		velhaDisciplina.setProfessores(novaDisciplina.getProfessores());
		
		return velhaDisciplina;
	}
}