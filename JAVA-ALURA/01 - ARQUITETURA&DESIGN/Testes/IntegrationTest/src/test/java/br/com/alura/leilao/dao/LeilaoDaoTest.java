package br.com.alura.leilao.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;
import br.com.alura.leilao.util.JPAUtil;

class LeilaoDaoTest {

	private LeilaoDao dao;
	private EntityManager em = JPAUtil.getEntityManager();
	
	@BeforeEach
	public void beforeEach() {
		this.dao = new LeilaoDao(em);
		em.getTransaction().begin();
	}
	
	@AfterEach
	public void afterEach() {
		em.getTransaction().rollback();
	}
	
	@Test
	void deveriaCadastrarUmLeilao() {
		Usuario usuario = criarUsuario();
		Leilao leilao = new Leilao("Mochila", new BigDecimal("70.00"), LocalDate.now(), usuario);
		
		leilao = dao.salvar(leilao);
		Leilao leilaosalvo = dao.buscarPorId(leilao.getId());
		
		assertNotNull(leilaosalvo);
	}
	
	@Test
	void deveriaAtualizarUmLeilao() {
		Usuario usuario = criarUsuario();
		Leilao leilao = new Leilao("Mochila", new BigDecimal("70.00"), LocalDate.now(), usuario);
		
		leilao = dao.salvar(leilao);
		leilao.setNome("Celular");
		leilao.setValorInicial(new BigDecimal("400"));
		
		leilao = dao.salvar(leilao);
		
		Leilao leilaosalvo = dao.buscarPorId(leilao.getId());
		assertEquals("Celular", leilaosalvo.getNome());
		assertEquals(new BigDecimal("400"), leilaosalvo.getValorInicial());
	}
	
	private Usuario criarUsuario() {
		Usuario usuario = new Usuario("fulano", "fulano@email.com", "12345678");
		em.persist(usuario);
		return usuario;
	}

}
