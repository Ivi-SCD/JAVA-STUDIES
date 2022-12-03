package br.com.alura.leilao.acceptance.steps;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.alura.leilao.model.Lance;
import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PropondoLanceSteps {
	
	private Lance lance;
	private Leilao leilao;
	
	@Given("\\(Dado): Um lance valido")
	public void dado_um_lance_valido() {
	    Usuario usuario = new Usuario("fulano", "fulano@email.com", "pass");
		lance = new Lance(usuario, BigDecimal.TEN);
	}

	@When("\\(Quando): Propoe o lance")
	public void quando_propoe_o_lance() {
	    leilao = new Leilao("iPhone 12", BigDecimal.TEN, LocalDate.now());
	    leilao.propoe(lance);
	}
	@Then("\\(Entao): O lance e aceito")
	public void entao_o_lance_e_aceito() {
	    assertTrue(leilao.getLances().contains(lance));
	}
}