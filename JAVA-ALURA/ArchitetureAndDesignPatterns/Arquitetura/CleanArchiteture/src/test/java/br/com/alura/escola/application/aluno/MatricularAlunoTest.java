package br.com.alura.escola.application.aluno;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import br.com.alura.escola.application.aluno.MatricularAluno.MatricularAlunoDTO;
import br.com.alura.escola.domain.aluno.Aluno;
import br.com.alura.escola.domain.aluno.AlunoRepository;
import br.com.alura.escola.domain.aluno.CPF;
import br.com.alura.escola.infra.aluno.AlunoEmMemoria;

class MatricularAlunoTest {

	@Test
	void alunoDeveriaSerPersistido() {
		// Poderia ser utilizando MOCK -> Mockito
		AlunoRepository repositorio = new AlunoEmMemoria();
		MatricularAluno useCase = new MatricularAluno(repositorio);
		
		MatricularAlunoDTO dados = new MatricularAlunoDTO("ivisson", 
				"123.456.789-00", 
				"ivi@email.com");
		useCase.executa(dados);
		
		Aluno encontrado = repositorio.buscarPorCPF(new CPF(dados.cpfAluno()));
		
		assertNotNull(encontrado);
		assertEquals(encontrado.getNome(), dados.nomeAluno());
		assertEquals(encontrado.getCpf(), dados.cpfAluno());
		assertEquals(encontrado.getEmail(), dados.emailAluno());
	}

}
