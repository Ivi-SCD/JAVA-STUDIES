package br.com.alura.leilao.util.driver.enums;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public enum Drivers {
	EDGE {
		@Override
		public WebDriver getBrowser() {
			System.setProperty("webdriver.edge.driver", "drivers/msedgedriver.exe");
			WebDriver browser = new EdgeDriver();
			return browser;
		}
	},
	CHROME {
		@Override
		public WebDriver getBrowser() {
			//Set the property 
			//Set the browser
			return null;
		}
	};
	
	public abstract WebDriver getBrowser();
}