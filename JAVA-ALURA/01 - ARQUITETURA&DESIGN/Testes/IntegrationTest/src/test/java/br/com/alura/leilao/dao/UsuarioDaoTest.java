package br.com.alura.leilao.dao;

import static org.junit.jupiter.api.Assertions.assertThrows;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.leilao.model.Usuario;
import br.com.alura.leilao.util.JPAUtil;

class UsuarioDaoTest {

	private UsuarioDao dao;
	private EntityManager em = JPAUtil.getEntityManager();
	
	@BeforeEach
	public void beforeEach() {
		this.dao = new UsuarioDao(em);
		em.getTransaction().begin();
	}
	
	@AfterEach
	public void afterEach() {
		em.getTransaction().rollback();
	}
	
	private Usuario criarUsuario() {
		Usuario usuario = new Usuario("fulano", "fulano@email.com", "12345678");
		em.persist(usuario);
		return usuario;
	}
	
	@Test
	void deveriaEncontrarUsuario() {
		
		Usuario usuario = criarUsuario();
		Usuario encontrado = this.dao.buscarPorUsername(usuario.getNome());
		Assert.assertNotNull(encontrado);
	}
	
	@Test
	void naoDeveriaEncontrarUsuario() {
		
		criarUsuario();
		Assert.assertThrows(NoResultException.class, () -> this.dao.buscarPorUsername("beltrano"));
	}

	@Test
	void deveriaRemoverUsuario() {
		Usuario usuario = criarUsuario();
		dao.deletar(usuario);
		
		assertThrows(NoResultException.class, ()-> this.dao.buscarPorUsername(usuario.getNome()));
	}
	
}