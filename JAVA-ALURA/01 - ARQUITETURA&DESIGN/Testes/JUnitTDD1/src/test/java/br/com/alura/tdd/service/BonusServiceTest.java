package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.service.bonus.RegraBonusPorTrabalho;

class BonusServiceTest {

	private BonusService service;
	
	@BeforeEach
	private void inicializar() {
		service = new BonusService();
		System.out.println("Iniciando thread.");
	}
	
	@BeforeAll
	private static void beforeAllMethod() {
		System.out.println("Iniciando...");
	}
	
	@AfterEach
	private void finalizar() {
		System.out.println("Finalizando thread.");
	}
	
	@AfterAll
	private static void afterAllMethod() {
		System.out.println("Encerrando...");
	}
	
	@Test
	void bonusZeradoParaSalariosAcimaDeDezMil() {
		
		assertThrows(IllegalArgumentException.class, () -> service.calcularBonus
				(new Funcionario("Ivisson", LocalDate.now(), new BigDecimal("25000")),
						new RegraBonusPorTrabalho()));
		/*
		 * try {
		 * 		service.calcularBonus(new Funcionario("Gavi", LocalDateTime.now(), new BigDecimal("25000")),
		 * 			new RegraBonusPorTrabalho()));
		 * 		fail("Nao deu a exception);
		 * } catch (Exception e) {
		 * 		assertEquals("Funcionario com salario maior que R$10000 nao pode receber bonus.", e.getMessage());
		 * }
		 */
	}
	
	@Test
	void bonusDeveriaSerDezPorCentoDoSalario() {
		
		BigDecimal bonus = service.calcularBonus
		(new Funcionario("Ivisson", LocalDate.now(), new BigDecimal("2500")),
				new RegraBonusPorTrabalho());
		
		assertEquals(new BigDecimal("250.00"), bonus);
	}
	
	@Test
	void bonusDeveriaSerDezPorCentoParaSalarioMil() {
		
		BigDecimal bonus = service.calcularBonus
		(new Funcionario("Ivisson", LocalDate.now(), new BigDecimal("10000")),
				new RegraBonusPorTrabalho());
		
		assertEquals(new BigDecimal("1000.00"), bonus);
	}
	
}