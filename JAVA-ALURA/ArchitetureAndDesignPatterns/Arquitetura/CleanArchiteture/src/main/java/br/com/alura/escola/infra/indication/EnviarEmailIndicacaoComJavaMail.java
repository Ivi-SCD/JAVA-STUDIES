package br.com.alura.escola.infra.indication;

import br.com.alura.escola.application.indication.EnviarEmailIndicacao;
import br.com.alura.escola.domain.aluno.Aluno;

public class EnviarEmailIndicacaoComJavaMail implements EnviarEmailIndicacao {

	@Override
	public void enviarPara(Aluno indicado) {
		// lógica de envio de email com a lib Java Mail
	}
	
}
