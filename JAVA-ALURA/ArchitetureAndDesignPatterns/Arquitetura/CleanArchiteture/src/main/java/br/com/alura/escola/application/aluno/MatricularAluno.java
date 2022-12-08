package br.com.alura.escola.application.aluno;

import br.com.alura.escola.domain.aluno.Aluno;
import br.com.alura.escola.domain.aluno.AlunoRepository;
import br.com.alura.escola.domain.aluno.CPF;
import br.com.alura.escola.domain.aluno.Email;

public class MatricularAluno {
	
	private final AlunoRepository repositorio;
	
	public MatricularAluno(AlunoRepository repositorio) {
		this.repositorio = repositorio;
	}
	
	// COMMAND
	public void executa (MatricularAlunoDTO dados) {
		Aluno novoAluno = dados.criarAluno();
		repositorio.matricular(novoAluno);
	}
	
	public record MatricularAlunoDTO(String nomeAluno, String cpfAluno, String emailAluno) {
		public Aluno criarAluno() {
			return new Aluno(new CPF(cpfAluno)
					,nomeAluno
					,new Email(emailAluno));
		}
	};
}
