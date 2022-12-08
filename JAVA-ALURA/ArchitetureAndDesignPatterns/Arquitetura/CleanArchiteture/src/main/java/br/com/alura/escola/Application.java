package br.com.alura.escola;

import br.com.alura.escola.domain.aluno.Aluno;
import br.com.alura.escola.domain.aluno.AlunoRepository;
import br.com.alura.escola.domain.aluno.CPF;
import br.com.alura.escola.domain.aluno.Email;
import br.com.alura.escola.infra.aluno.AlunoEmMemoria;

public class Application {

	public static void main(String[] args) {
		String nome = "Pessoa da Silva";
		CPF cpf = new CPF("111.111.111-11");
		Email email = new Email("pessoa@email.com");
		
		Aluno aluno = new Aluno(cpf, nome, email);
		
		AlunoRepository repositorio = new AlunoEmMemoria();
		repositorio.matricular(aluno);
	}

}
