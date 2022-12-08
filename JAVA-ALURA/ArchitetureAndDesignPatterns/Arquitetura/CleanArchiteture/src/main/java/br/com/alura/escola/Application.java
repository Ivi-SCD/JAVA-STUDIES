package br.com.alura.escola;

import br.com.alura.escola.application.aluno.MatricularAluno;
import br.com.alura.escola.application.aluno.MatricularAluno.MatricularAlunoDTO;
import br.com.alura.escola.infra.aluno.AlunoEmMemoria;

public class Application {

	public static void main(String[] args) {
		String nome = "Pessoa da Silva";
		String cpf ="111.111.111-11";
		String email = "pessoa@email.com";
		
		MatricularAluno matricular = new MatricularAluno(
				new AlunoEmMemoria());
		matricular.executa(new MatricularAlunoDTO(nome, cpf, email));
	}

}
