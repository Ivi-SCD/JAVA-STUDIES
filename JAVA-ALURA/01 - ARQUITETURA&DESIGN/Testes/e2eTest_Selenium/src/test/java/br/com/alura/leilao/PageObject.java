package br.com.alura.leilao;

import org.openqa.selenium.WebDriver;

import br.com.alura.leilao.util.driver.enums.Drivers;

public class PageObject {
	
	
	protected WebDriver browser;
	
	public PageObject(Drivers driver) {
		this.browser = driver.getBrowser();
	}
	
	public PageObject(WebDriver browser) {
		if (browser == null) {
			throw new NullPointerException("Can't be null");
		}
		this.browser = browser;
	}
	
	public void fecharBrowser() {
		this.browser.quit();
	}
}
