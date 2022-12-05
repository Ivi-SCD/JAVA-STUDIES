package br.com.alura.escola;

public class Indicacao {
	
	private Aluno indicado;
	private Aluno indicante;
	
	public Indicacao(Aluno indicado, Aluno indicante) {
		this.indicado = indicado;
		this.indicante = indicante;
	}
	
	public Aluno getIndicado() {
		return indicado;
	}
	
	public Aluno getIndicante() {
		return indicante;
	}
	
}
