package br.com.alura.escola.infra.aluno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.escola.domain.aluno.Aluno;
import br.com.alura.escola.domain.aluno.AlunoRepository;
import br.com.alura.escola.domain.aluno.CPF;
import br.com.alura.escola.domain.aluno.Email;
import br.com.alura.escola.domain.aluno.Telefone;

public class AlunoJDBC implements AlunoRepository {

	private final Connection connection;

	public AlunoJDBC(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void matricular(Aluno aluno) {

		try {
			String sql = "INSERT INTO ALUNO VALUES(?, ?, ?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, aluno.getCpf());
			ps.setString(2, aluno.getNome());
			ps.setString(3, aluno.getEmail());
			ps.execute();

			sql = "INSERT INTO TELEFONE VALUES (?, ?)";
			ps = connection.prepareStatement(sql);
			for (Telefone a : aluno.getTelefones()) {
				ps.setString(1, a.getDdd());
				ps.setString(2, a.getNumero());
				ps.execute();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Aluno buscarPorCPF(CPF cpf) {
		try {
			String sql = "SELECT id, nome, email FROM ALUNO WHERE cpf = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, cpf.getNumero());

			ResultSet rs = ps.executeQuery();
			boolean encontrou = rs.next();
			if (!encontrou) {
				throw new RuntimeException("Aluno nao encontrado: " + cpf.getNumero());
			}

			String nome = rs.getString("nome");
			Email email = new Email(rs.getString("email"));
			Aluno encontrado = new Aluno(cpf, nome, email);

			Long id = rs.getLong("id");
			sql = "SELECT ddd, numero FROM TELEFONE WHERE aluno_id = ?";
			ps = connection.prepareStatement(sql);
			ps.setLong(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				String numero = rs.getString("numero");
				String ddd = rs.getString("ddd");
				encontrado.adicionarTelefone(ddd, numero);
			}

			return encontrado;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Aluno> listarTodosAlunosMatriculados() {
		try {
			String sql = "SELECT id, cpf, nome, email FROM ALUNO";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			List<Aluno> alunos = new ArrayList<>();
			while (rs.next()) {
				CPF cpf = new CPF(rs.getString("cpf"));
				String nome = rs.getString("nome");
				Email email = new Email(rs.getString("email"));
				Aluno aluno = new Aluno(cpf, nome, email);

				Long id = rs.getLong("id");
				sql = "SELECT ddd, numero FROM TELEFONE WHERE aluno_id = ?";
				PreparedStatement psTelefone = connection.prepareStatement(sql);
				psTelefone.setLong(1, id);
				ResultSet rsTelefone = psTelefone.executeQuery();
				while (rsTelefone.next()) {
					String numero = rsTelefone.getString("numero");
					String ddd = rsTelefone.getString("ddd");
					aluno.adicionarTelefone(ddd, numero);
				}

				alunos.add(aluno);
			}

			return alunos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}	

}
