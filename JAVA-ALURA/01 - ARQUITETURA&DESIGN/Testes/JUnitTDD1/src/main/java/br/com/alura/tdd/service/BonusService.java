package br.com.alura.tdd.service;

import java.math.BigDecimal;

import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.service.bonus.Bonus;

public class BonusService {

	public BigDecimal calcularBonus(Funcionario funcionario, Bonus regraBonus) {

		return regraBonus.obterBonus(funcionario);
	}
}