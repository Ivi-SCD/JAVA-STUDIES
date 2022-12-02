package br.com.alura.leilao.leiloes;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.leilao.login.LoginPage;

public class LeiloesTest {
	private LeiloesPage paginaDeLeiloes;
	private CadastroLeilaoPage paginaDeCadastro;
	
	@BeforeEach
	void beforeEach() {
		LoginPage paginaDeLogin = new LoginPage();
		this.paginaDeLeiloes = paginaDeLogin.executaLogin("fulano", "pass");
		paginaDeCadastro = paginaDeLeiloes.carregarFormulario();
	}
	
	@AfterEach
	void afterEach() {
		this.paginaDeLeiloes.fecharBrowser();
	}
	
	@Test
	void deveriaCadastrarLeilao() {
		
		String dataHoje = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		String nome = "Leilao do dia " + dataHoje;
		String valor = "500.00";
		 
		this.paginaDeLeiloes = paginaDeCadastro.cadastrarLeilao(nome, valor, dataHoje);
		assertTrue(paginaDeLeiloes.isLeilaoCadastrado(nome, valor, dataHoje));
	}
	
	@Test
	void deveriaValidarCadastroLeilao() {
		this.paginaDeLeiloes = paginaDeCadastro.cadastrarLeilao("", "", "");
		
		assertFalse(this.paginaDeCadastro.isPaginaAtual());
		assertTrue(this.paginaDeLeiloes.isPaginaAtual());
		assertTrue(this.paginaDeCadastro.isValidacoesVisiveis());
	}
}