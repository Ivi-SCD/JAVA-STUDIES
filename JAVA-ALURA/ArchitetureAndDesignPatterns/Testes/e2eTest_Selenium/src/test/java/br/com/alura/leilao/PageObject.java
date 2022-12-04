package br.com.alura.leilao;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import br.com.alura.leilao.util.driver.enums.Drivers;

public class PageObject {
	
	
	protected WebDriver browser;
	
	public PageObject(Drivers driver) {
		this.browser = driver.getBrowser();
		waitSeconds(2, 5);
	}
	
	public PageObject(WebDriver browser) {
		if (browser == null) {
			throw new NullPointerException("Can't be null");
		}
		this.browser = browser;
		waitSeconds(2, 5);
		
	}
	
	public void fecharBrowser() {
		this.browser.quit();
	}
	
	
	private void waitSeconds(Integer secsImplicitylyWait, Integer secsPageLoad) {
		this.browser.manage().timeouts().implicitlyWait(secsImplicitylyWait, TimeUnit.SECONDS)
		.pageLoadTimeout(secsPageLoad, TimeUnit.SECONDS);
	}
}
