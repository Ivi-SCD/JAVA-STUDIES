package br.com.alura.escola.infra.aluno;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import br.com.alura.escola.domain.aluno.CifradorDeSenha;

public final class CifradorDeSenhaComMD5 implements CifradorDeSenha{

	@Override
	public String cifrarSenha(String senha) {
		try {
			MessageDigest md = MessageDigest.getInstance(senha);
			md.update(senha.getBytes());
			byte [] bytes = md.digest();
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i]) & 0xff));
			}
			return sb.toString();
			
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("erro");
		}
	}

	@Override
	public boolean validarSenhaCifrada(String senhaCifrada, String senha) {
		return senhaCifrada.equals(cifrarSenha(senha));
	}

}
