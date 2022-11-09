package fucturaprojectcrud.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import fucturaprojectcrud.connection.ConnectionFactory;
import fucturaprojectcrud.dao.EnderecoDao;
import fucturaprojectcrud.db.DbNotFoundException;
import fucturaprojectcrud.db.DbPersistenceException;
import fucturaprojectcrud.db.DbUnexpectedException;
import fucturaprojectcrud.entities.Endereco;

public class EnderecoDaoEm implements EnderecoDao {
	
	EntityManager em = ConnectionFactory.getEntityManager();
	
	@Override
	@Transactional
	public void insert(Endereco endereco) {
		try {
			em.getTransaction().begin();
			em.persist(endereco);
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
			
			Endereco endereco = findById(id);
			em.remove(endereco);
			
			em.getTransaction().commit();
		} catch(Exception e) {
			throw new DbUnexpectedException(e.getMessage());
		}
	}
	
	@Override
	public void updateEndereco(Long id, Endereco novoEndereco) {
		try {
			em.getTransaction().begin();
			
			Endereco endereco = updateEnderecoData(findById(id), novoEndereco);
			em.merge(endereco);
			
			em.getTransaction().commit();
		} catch (Exception e) {
			throw new DbUnexpectedException(e.getMessage());
		}
	}

	@Override
	public List <Endereco> findAll() {
		try {
		TypedQuery <Endereco> query = em.createQuery("SELECT endereco FROM Endereco endereco", Endereco.class);
		if(query.getResultList().isEmpty()) {
			throw new DbNotFoundException("List of Type <" + Endereco.class + ">");
		}
		return query.getResultList();
		} catch (Exception e) {
			throw new DbUnexpectedException(e.getMessage());
		}
	}
	
	@Override
	public Endereco findById(Long id) {
		Endereco endereco = em.find(Endereco.class, id);
		if(endereco == null) {
			throw new DbNotFoundException(id);
		}
		return endereco;
	}

	@Override
	public void closeConnections() {
		em.close();
		ConnectionFactory.closeConnections();
	}
	
	private Endereco updateEnderecoData(Endereco velhoEndereco, Endereco novoEndereco) {
		velhoEndereco.setBairro(novoEndereco.getBairro());
		velhoEndereco.setCidade(novoEndereco.getCidade());
		velhoEndereco.setNumero(novoEndereco.getNumero());
		velhoEndereco.setRua(novoEndereco.getRua());
		velhoEndereco.setUf(novoEndereco.getUf());
		
		return velhoEndereco;
	}
}