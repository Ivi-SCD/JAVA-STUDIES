package br.com.alura.leilao.leiloes;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import br.com.alura.leilao.login.LoginPage;

public class LeiloesTest {
	private LeiloesPage paginaDeLeiloes;
	
	
	@AfterEach
	void afterEach() {
		this.paginaDeLeiloes.fecharBrowser();
	}
	
	@Test
	public void deveriaCadastrarLeilao() {
		LoginPage paginaDeLogin = new LoginPage();
		this.paginaDeLeiloes = paginaDeLogin.executaLogin("fulano", "pass");
		CadastroLeilaoPage paginaDeCadastro = paginaDeLeiloes.carregarFormulario();
		
		String dataHoje = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		String nome = "Leilao do dia " + dataHoje;
		String valor = "500.00";
		 
		this.paginaDeLeiloes = paginaDeCadastro.cadastrarLeilao(nome, valor, dataHoje);
		assertTrue(paginaDeLeiloes.isLeilaoCadastrado(nome, valor, dataHoje));
	}
	
}