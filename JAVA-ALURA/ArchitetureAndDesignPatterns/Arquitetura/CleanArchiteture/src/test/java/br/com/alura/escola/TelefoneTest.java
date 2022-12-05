package br.com.alura.escola;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TelefoneTest {

	@Test
	void naoDeveriaCriarTelefoneComTelefoneInvalido() {
		assertThrows(IllegalArgumentException.class, 
				() -> new Telefone(null, null));
		
		assertThrows(IllegalArgumentException.class, 
				() -> new Telefone("555", null));
		
		assertThrows(IllegalArgumentException.class, 
				() -> new Telefone("", ""));
		
		assertThrows(IllegalArgumentException.class, 
				() -> new Telefone("81", "1111111111"));
		
		assertThrows(IllegalArgumentException.class, 
				() -> new Telefone("555", "11111111"));
	}

}
