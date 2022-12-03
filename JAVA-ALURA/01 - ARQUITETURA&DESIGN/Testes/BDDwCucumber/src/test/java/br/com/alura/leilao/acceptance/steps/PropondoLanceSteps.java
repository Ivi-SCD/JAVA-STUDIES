package br.com.alura.leilao.acceptance.steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.leilao.model.Lance;
import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class PropondoLanceSteps {
	
	private Lance lance;
	private Leilao leilao;
	private Lance lance10;
	private Lance lance15;
	
	@Dado("Um lance valido")
	public void dado_um_lance_valido() {
	    Usuario usuario = new Usuario("fulano", "fulano@email.com", "pass");
		lance = new Lance(usuario, BigDecimal.TEN);
	}

	@Quando("Propoe ao leilao")
	public void quando_propoe_o_lance() {
	    leilao = new Leilao("iPhone 12", BigDecimal.TEN, LocalDate.now());
	    leilao.propoe(lance);
	}
	
	@Entao("O lance e aceito")
	public void entao_o_lance_e_aceito() {
	    assertTrue(leilao.getLances().contains(lance));
	    assertTrue(leilao.getLances().size() == 1);
	    assertEquals(leilao.getLances().get(0).getValor(), lance.getValor());
	}
	
//	@Given("\\(Dado): varios lances validos")
//	public void dado_varios_lances_validos() {
//		Usuario usuario1 = new Usuario("fulano", "fulano@email.com", "pass");
//		lance10 = new Lance(usuario1, BigDecimal.TEN);
//		Usuario usuario2 = new Usuario("beltrano", "beltrano@email.com", "pass");
//		lance15 = new Lance(usuario2, new BigDecimal("15.0"));
//		leilao = new Leilao("Tablet XPTO");
//	}
	
	@Dado("um lance de {double} reais do usuario {string}")
	public void um_lance_de_reais_do_usuario(Double valor, String nomeUsuario) {
	    System.out.println(valor);
	    System.out.println(nomeUsuario);
	}

	@Quando("propoe varios lances ao leilao")
	public void quando_propoe_varios_lances_ao_leilao() {
		 leilao.propoe(lance10);
		 leilao.propoe(lance15);
	}
	
	@Entao("os lances sao aceitos")
	public void entao_os_lances_sao_aceitos() {
		
		List <Lance> lances = new ArrayList<>();
		lances.add(lance10);
		lances.add(lance15);
		
		assertTrue(leilao.getLances()
				.containsAll(lances));
		assertTrue(leilao.getLances().size() == 2);
		
		assertEquals(new BigDecimal("15.0"), lance15.getValor());
		assertEquals(BigDecimal.TEN, lance10.getValor());
	}

	
}