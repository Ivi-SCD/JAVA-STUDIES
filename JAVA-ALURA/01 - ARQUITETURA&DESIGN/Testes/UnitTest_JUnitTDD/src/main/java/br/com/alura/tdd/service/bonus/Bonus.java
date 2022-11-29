package br.com.alura.tdd.service.bonus;

import java.math.BigDecimal;

import br.com.alura.tdd.modelo.Funcionario;

public interface Bonus {
	
	BigDecimal obterBonus(Funcionario funcionario);
}