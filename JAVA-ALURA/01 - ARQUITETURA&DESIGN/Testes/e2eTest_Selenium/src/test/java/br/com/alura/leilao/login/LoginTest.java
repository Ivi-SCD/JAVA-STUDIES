package br.com.alura.leilao.login;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import br.com.alura.leilao.util.driver.enums.Drivers;
import br.com.alura.leilao.util.driver.enums.SeleniumDriver;

public class LoginTest {
		
	private static final String URL_LOGIN = "http://localhost:8080/login";
	WebDriver browser;
	
	@BeforeEach
	void beforeEach() {
		this.browser = SeleniumDriver.getBrowser(Drivers.EDGE);
		navegarParaLogin();
	}
	
	@AfterEach
	void afterEach() {
		this.browser.quit();
	}
	
	@Test
	void deveriaEfetuaLoginComDadosValidos() {
		
		browser.findElement(By.id("username")).sendKeys("fulano");
		browser.findElement(By.id("password")).sendKeys("pass");
		browser.findElement(By.id("login-form")).submit();
		
		assertFalse(browser.getCurrentUrl().equals(URL_LOGIN));
		assertEquals(browser.findElement(By.id("usuario-logado")).getText(), "fulano");
	}
	
	@Test
	void naoDeveriaEfetuarLoginComDadosInvalidos() {
		
		browser.findElement(By.id("username")).sendKeys("fulano");
		browser.findElement(By.id("password")).sendKeys("false");
		browser.findElement(By.id("login-form")).submit();
		
		assertTrue(browser.getCurrentUrl().equals(URL_LOGIN + "?error"));
		assertTrue(browser.getPageSource().contains("Usuário e senha inválidos."));
		assertThrows(NoSuchElementException.class, () -> browser.findElement(By.id("usuario-logado")));
	}
	
	
	@Test
	void naoDeveriaAcessarPaginaRestritaSemLogin() {
		browser.navigate().to("http://localhost:8080/leiloes/2");
		
		assertTrue(browser.getCurrentUrl().equals(URL_LOGIN));
		assertFalse(browser.getPageSource().contains("Dados do leilão"));
	}
	
	private void navegarParaLogin() {
		browser.navigate().to(URL_LOGIN);
	}
}