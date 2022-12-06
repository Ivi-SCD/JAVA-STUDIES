package br.com.alura.escola.domain.indicacao;

import java.time.LocalDateTime;

import br.com.alura.escola.domain.aluno.Aluno;

public class Indicacao {
	
	private Aluno indicado;
	private Aluno indicante;
	private LocalDateTime dataIndicacao;
	
	public Indicacao(Aluno indicado, Aluno indicante) {
		this.dataIndicacao = LocalDateTime.now();
		this.indicado = indicado;
		this.indicante = indicante;
	}
	
	public Aluno getIndicado() {
		return indicado;
	}
	
	public Aluno getIndicante() {
		return indicante;
	}
	
	public LocalDateTime getDataIndicacao() {
		return dataIndicacao;
	}
	
}
