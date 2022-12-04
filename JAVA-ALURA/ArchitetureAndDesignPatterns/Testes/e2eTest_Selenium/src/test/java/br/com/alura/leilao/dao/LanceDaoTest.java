package br.com.alura.leilao.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.leilao.model.Lance;
import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;
import br.com.alura.leilao.util.JPAUtil;
import br.com.alura.leilao.util.builder.LanceBuilder;
import br.com.alura.leilao.util.builder.LeilaoBuilder;
import br.com.alura.leilao.util.builder.UsuarioBuilder;

class LanceDaoTest {
	
	private LanceDao dao;
	private EntityManager em;
	
	@BeforeEach
	public void beforeEach() {
		this.em = JPAUtil.getEntityManager();
		this.dao = new LanceDao(em);
		em.getTransaction().begin();
	}
	
	@AfterEach
	public void afterEach() {
		em.getTransaction().rollback();
	}
	
	@Test
	void deveriaBuscarMaiorLanceLeilao() {
		Usuario usuarioDono = new UsuarioBuilder()
				.comNome("Ivisson")
				.comEmail("ivisson@email.com")
				.comSenha("12345")
				.criar();
		
		Usuario usuario_first = new UsuarioBuilder()
				.comNome("Richarlison")
				.comEmail("richarlison@email.com")
				.comSenha("12345")
				.criar();
		
		Usuario usuario_second = new UsuarioBuilder()
				.comNome("Rodrigo")
				.comEmail("rodrigo@email.com")
				.comSenha("12345")
				.criar();
		
		em.persist(usuarioDono);
		em.persist(usuario_first);
		em.persist(usuario_second);
		
		Leilao leilao = new LeilaoBuilder().comData(LocalDate.now())
				.comNome("Leilao Teste")
				.comValorInicial("100.00")
				.comUsuario(usuarioDono)
				.criar();
		
		em.persist(leilao);
		
		Lance lance_first = new LanceBuilder()
				.comData(LocalDate.now())
				.comUsuario(usuario_second)
				.comValor("200.00")
				.criar();
		
		Lance lance_second = new LanceBuilder()
				.comData(LocalDate.now())
				.comUsuario(usuario_first)
				.comValor("300.00")
				.criar();

		leilao.propoe(lance_first);
		leilao.propoe(lance_second);
		
		dao.salvar(lance_second);
		dao.salvar(lance_first);
		
		Lance maiorLance = dao.buscarMaiorLanceDoLeilao(leilao);
	
		assertEquals(maiorLance.getValor(), lance_second.getValor());
	}
	
	@Test
	void deveriaSomar() {
		Integer soma = 1+1;
		assertEquals(2, soma);
	}
}
