package br.com.alura.leilao.util.driver.enums;

import org.openqa.selenium.WebDriver;

public class SeleniumDriver {
	
	public static WebDriver getBrowser (Drivers driver) {
		if (driver == null) {
			throw new NullPointerException("Driver value is null");
		}
		return driver.getBrowser();
	}
	
}