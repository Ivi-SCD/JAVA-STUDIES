package br.com.alura.leilao.leiloes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.alura.leilao.PageObject;

public class LeiloesPage extends PageObject {
	
	private static final String URL_CADASTRO_LEILAO = "http://localhost:8080/leiloes/new";
	private static final String URL_LEILOES = "http://localhost:8080/leiloes";
	
	public LeiloesPage(WebDriver browser) {
		super(browser);
	}
	
	public boolean isLeilaoCadastrado(String nome, String valor, String dataHoje) {
		WebElement lastTableLine = this.browser.findElement(By.cssSelector("#tabela-leiloes tbody tr:last-child"));
		
		WebElement columnName = lastTableLine.findElement(By.cssSelector("td:nth-child(1)"));
		WebElement columnDate = lastTableLine.findElement(By.cssSelector("td:nth-child(2)"));
		WebElement columnValue = lastTableLine.findElement(By.cssSelector("td:nth-child(3)"));
		
		return columnName.getText().equals(nome) 
				&& columnValue.getText().equals(valor) 
				&& columnDate.getText().equals(dataHoje);
	}
	
	public boolean contemNaPage(String content) {
		return browser.getPageSource().contains(content);
	}
	
	public CadastroLeilaoPage carregarFormulario() {
		this.browser.navigate().to(URL_CADASTRO_LEILAO);
		return new CadastroLeilaoPage(browser);
		
	}

	public boolean isPaginaAtual() {
		return browser.getCurrentUrl().equals(URL_LEILOES);
	}

	
}
