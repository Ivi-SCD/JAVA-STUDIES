package br.com.alura.tdd.service.bonus;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.alura.tdd.modelo.Funcionario;

public class RegraBonusPorTrabalho implements Bonus {

	@Override
	public BigDecimal obterBonus(Funcionario funcionario) {
		BigDecimal valor = funcionario.getSalario().multiply(new BigDecimal("0.1"));
		
		if (valor.compareTo(new BigDecimal("1000")) > 0) {
			throw new IllegalArgumentException("Funcionario com salario maior que R$10000 nao pode receber bonus.");
		}
		
		return valor.setScale(2, RoundingMode.HALF_UP);
	}
}