package br.com.alura.escola.infra.aluno;

import java.util.ArrayList;
import java.util.List;

import br.com.alura.escola.domain.aluno.Aluno;
import br.com.alura.escola.domain.aluno.AlunoRepository;
import br.com.alura.escola.domain.aluno.CPF;

public class AlunoEmMemoria implements AlunoRepository {

	private List<Aluno> matriculados = new ArrayList<>();
	
	@Override
	public void matricular(Aluno aluno) {
		this.matriculados.add(aluno);
	}

	@Override
	public Aluno buscarPorCPF(CPF cpf) {
		return this.matriculados.stream()
				.filter(a -> a.getCpf().equals(cpf.getNumero()))
				.findFirst()
				.orElseThrow(() -> new RuntimeException
						("Aluno nao encontrado: " + cpf.getNumero()));
	}

	@Override
	public List<Aluno> listarTodosAlunosMatriculados() {
		return this.matriculados;
	}
}
