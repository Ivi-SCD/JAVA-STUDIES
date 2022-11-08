package fucturaprojectcrud.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import fucturaoracleprojectcrud.db.DbNotFoundException;
import fucturaprojectcrud.dao.AlunoDao;
import fucturaprojectcrud.entities.Aluno;

public class AlunoDaoEm implements AlunoDao {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("fuctura");
	private EntityManager em = emf.createEntityManager();

	@Override
	@Transactional
	public void insert(Aluno aluno) {
		try {
			em.getTransaction().begin();
			em.persist(aluno);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteById(Long id) {
		try {
			em.getTransaction().begin();
			
			Aluno aluno = findById(id);
			if (aluno != null) {
				Query query = em.createNativeQuery("DELETE FROM TB_MATRICULA WHERE aluno_id = " + id);
				query.executeUpdate();
			}
			
			em.remove(aluno);
			
			em.getTransaction().commit();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	@Transactional
	public void updateAluno(Long id, Aluno novoAluno) {
		try {
			em.getTransaction().begin();
			
			Aluno aluno = updateAlunoData(findById(id), novoAluno);
			em.merge(aluno);
			
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Aluno> findAll() {
		TypedQuery <Aluno> query = em.createQuery("SELECT aluno FROM Aluno aluno", Aluno.class);
		return query.getResultList();
	}
	
	@Override
	public Aluno findById(Long id) {
		Aluno aluno = em.find(Aluno.class, id);
		if (aluno == null) {
			throw new DbNotFoundException(id);
		}
		return aluno;
	}
	
	@Override
	public void closeConnections() {
		em.close();
		emf.close();
	}
	
	private Aluno updateAlunoData(Aluno velhoAluno, Aluno novoAluno) {
		velhoAluno.setNome(novoAluno.getNome());
		velhoAluno.setCpf(novoAluno.getCpf());
		velhoAluno.setDataNascimento(novoAluno.getDataNascimento());
		velhoAluno.setEndereco(novoAluno.getEndereco());
		velhoAluno.setSexo(novoAluno.getSexo());
		
		return velhoAluno;
	}

}