package br.com.alura.escola.domain.aluno;

import java.util.List;

public interface AlunoRepository {
	
	void matricular(Aluno aluno);
	Aluno buscarPorCPF(CPF cpf);
	List <Aluno> listarTodosAlunosMatriculados();
	// ...
}
