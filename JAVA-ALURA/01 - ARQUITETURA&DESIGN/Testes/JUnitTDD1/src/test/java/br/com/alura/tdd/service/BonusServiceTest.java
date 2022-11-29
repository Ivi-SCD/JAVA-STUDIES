package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.service.bonus.RegraBonusPorTrabalho;

class BonusServiceTest {

	@Test
	void bonusZeradoParaSalariosAcimaDeDezMil() {
		BonusService service = new BonusService();
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
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus
		(new Funcionario("Ivisson", LocalDate.now(), new BigDecimal("2500")),
				new RegraBonusPorTrabalho());
		
		assertEquals(new BigDecimal("250.00"), bonus);
	}
	
	@Test
	void bonusDeveriaSerDezPorCentoParaSalarioMil() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus
		(new Funcionario("Ivisson", LocalDate.now(), new BigDecimal("10000")),
				new RegraBonusPorTrabalho());
		
		assertEquals(new BigDecimal("1000.00"), bonus);
	}
	
}