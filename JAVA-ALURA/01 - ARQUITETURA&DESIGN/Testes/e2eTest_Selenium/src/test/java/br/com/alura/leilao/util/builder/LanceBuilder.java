package br.com.alura.leilao.util.builder;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.alura.leilao.model.Lance;
import br.com.alura.leilao.model.Usuario;

public class LanceBuilder {
	
	private BigDecimal valor;
	private LocalDate data;
	private Usuario usuario;
	
	public LanceBuilder comValor(String valor) {
		this.valor = new BigDecimal(valor);
		return this;
	}
	
	public LanceBuilder comData(LocalDate date) {
		this.data = date;
		return this;
	}
	
	public LanceBuilder comUsuario(Usuario usuario) {
		this.usuario = usuario;
		return this;
	}
	
	public Lance criar() {
		Lance lance = new Lance(usuario, valor);
		lance.setData(data);
		
		return lance;
	}
	
}	
