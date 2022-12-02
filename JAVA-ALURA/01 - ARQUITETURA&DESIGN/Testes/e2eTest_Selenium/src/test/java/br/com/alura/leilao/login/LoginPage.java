package br.com.alura.leilao.login;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import br.com.alura.leilao.leiloes.LeiloesPage;
import br.com.alura.leilao.util.driver.enums.Drivers;
import br.com.alura.leilao.util.driver.enums.SeleniumDriver;

public class LoginPage {
	
	private static final String URL_LOGIN = "http://localhost:8080/login";
	WebDriver browser;
	
	public LoginPage() {
		this.browser = SeleniumDriver.getBrowser(Drivers.EDGE);
		this.browser.navigate().to(URL_LOGIN);
	}
	
	public boolean isLoginPage() {
		return browser.getCurrentUrl().equals(URL_LOGIN);
	}
	
	public boolean isLoginPage(String value) {
		return browser.getCurrentUrl().equals(URL_LOGIN + "?" + value);
	}
	
	public boolean contemNaPage(String content) {
		return browser.getPageSource().contains(content);
	}
	
	public LeiloesPage executaLogin(String username, String senha) {
		browser.findElement(By.id("username")).sendKeys(username);
		browser.findElement(By.id("password")).sendKeys(senha);
		browser.findElement(By.id("login-form")).submit();
		
		return new LeiloesPage(browser);
	}

	public String getNomeUsuarioLogado() {
		try {
			String user = browser.findElement(By.id("usuario-logado")).getText();
			return user;
		} catch (NoSuchElementException e) {
			return "404";
		}
	}
	
	public void navegaParaLances() {
		this.browser.navigate().to("http://localhost:8080/leiloes/2");
	}
	
	public void fecharBrowser() {
		this.browser.quit();
	}
}
