package br.com.alura.leilao.login;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.leilao.util.driver.enums.Drivers;

public class LoginTest {
	
	private LoginPage paginaDeLogin;
	
	@BeforeEach
	void beforeEach() {
		paginaDeLogin = new LoginPage(Drivers.EDGE);
	}
	
	@AfterEach
	void afterEach() {
		paginaDeLogin.fecharBrowser();
	}
	
	@Test
	void deveriaEfetuaLoginComDadosValidos() {
		
		paginaDeLogin.executaLogin("fulano", "pass");
		
		assertFalse(paginaDeLogin.isLoginPage());
		assertEquals(paginaDeLogin.getNomeUsuarioLogado(), "fulano");
	}
	
	@Test
	void naoDeveriaEfetuarLoginComDadosInvalidos() {
	
		paginaDeLogin.executaLogin("fulano", "false");
		
		assertTrue(paginaDeLogin.isLoginPage("error"));
		assertTrue(paginaDeLogin.contemNaPage("Usuário e senha inválidos."));
		assertEquals(paginaDeLogin.getNomeUsuarioLogado(), "404");
	}
	
	
	@Test
	void naoDeveriaAcessarPaginaRestritaSemLogin() {
		
		paginaDeLogin.navegaParaLances();
		
		assertTrue(paginaDeLogin.isLoginPage());
		assertFalse(paginaDeLogin.contemNaPage("Dados do leilão"));
	}
}