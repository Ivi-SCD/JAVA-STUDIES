package br.com.alura.escola.dominio.aluno;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class CPFTest {

	@Test
	void naoDeveriaCriarCPFcomCPFinvalido() {
		
		assertThrows(IllegalArgumentException.class, 
				() -> new CPF(null));
		
		assertThrows(IllegalArgumentException.class, 
				() -> new CPF(""));
		
		assertThrows(IllegalArgumentException.class, 
				() -> new CPF("11111111111"));
	}

}
