package br.com.alura.escola.domain.aluno;

public class Telefone {
	
	private String ddd;
	private String numero;
	
	public Telefone(String ddd, String numero) {
		
		 if (ddd == null || numero == null) {
		        throw new IllegalArgumentException("DDD e Numero sao obrigatorios!");
		    }
		
		if(!ddd.matches("\\d{2}") 
		|| !numero.matches("\\d{8,9}")) {
			throw new IllegalArgumentException("Numero invalido");
		}
		this.ddd = ddd;
		this.numero = numero;
	}
	
	public String getDdd() {
		return ddd;
	}
	
	public String getNumero() {
		return numero;
	}
}
