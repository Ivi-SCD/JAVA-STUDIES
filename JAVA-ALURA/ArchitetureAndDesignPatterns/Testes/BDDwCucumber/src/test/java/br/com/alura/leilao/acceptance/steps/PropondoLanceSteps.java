package br.com.alura.leilao.acceptance.steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import br.com.alura.leilao.model.Lance;
import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class PropondoLanceSteps {
	
	private Lance lance;
	private Leilao leilao;
	private List <Lance> lista;
	
	@Before
	public void setup() {
		this.lista = new ArrayList<Lance>();
		leilao = new Leilao("Tablet XPTO");
	}
	
	@Dado("um lance valido")
	public void dado_um_lance_valido() {
	    Usuario usuario = new Usuario("fulano", "fulano@email.com", "pass");
		lance = new Lance(usuario, BigDecimal.TEN);
	}

	@Quando("propoe ao leilao")
	public void quando_propoe_o_lance() {
	    leilao.propoe(lance);
	}
	
	@Entao("o lance e aceito")
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
	    Lance lance = new Lance(new Usuario(nomeUsuario), new BigDecimal(valor));
	    lista.add(lance);
	}

	@Quando("propoe varios lances ao leilao")
	public void quando_propoe_varios_lances_ao_leilao() {
		 this.lista.forEach(leilao::propoe);
	}
	
	@Entao("os lances sao aceitos")
	public void entao_os_lances_sao_aceitos() {

		assertTrue(this.lista.size() == 2);
		assertEquals(this.lista.size(), leilao.getLances().size());
		assertEquals(this.lista.get(0).getValor(), leilao.getLances().get(0).getValor());
		assertEquals(this.lista.get(1).getValor(), leilao.getLances().get(1).getValor());
	}

	@Dado("um lance invalido do usuario {string} de {int} reais")
	public void um_lance_invalido_do_usuario_de_reais(String nome, Integer valor) {
	    assertThrows(IllegalArgumentException.class, 
	    		() ->  this.lance = new Lance(new Usuario(nome), new BigDecimal(valor)));
	}
	
	@Quando("propoe o lance ao leilao")
	public void propoe_o_lance_ao_leilao() {
		
		assertThrows(NullPointerException.class, () -> leilao.propoe(lance));
		
	}
	@Entao("o lance nao e aceito")
	public void o_lance_nao_e_aceito() {
	    assertEquals(leilao.getLances().get(0), null);
	}
	
	
	@Dado("dois lances")
	public void dois_lances(io.cucumber.datatable.DataTable dataTable) {
	    List <Map<String, String>> val = dataTable.asMaps();
	    
	    for(Map<String, String> mapa : val) {
	    	String valor = mapa.get("valor");
	    	String usuario = mapa.get("nomeUsuario");
	    	
	    	lance = new Lance(new Usuario(usuario), new BigDecimal(valor));
	    	lista.add(lance);
	    }
	}

	@Entao("o segundo lance nao e aceito")
	public void o_segundo_lance_nao_e_aceito() {
	    assertEquals(2, leilao.getLances().size());
	    assertEquals(this.lista.get(0).getValor(), leilao.getLances().get(0).getValor());
	}
	
}