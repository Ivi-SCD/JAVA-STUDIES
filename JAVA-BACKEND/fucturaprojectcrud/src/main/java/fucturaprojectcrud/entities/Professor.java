package fucturaprojectcrud.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_professor")
public class Professor implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	private String graduacao;
	
	@Column(nullable = false)
	private String telefoneNumero;
	
	@OneToMany(mappedBy = "professor", cascade = CascadeType.ALL)
	private List <Disciplina> matriculasProfessor = new ArrayList<>();
	
	public Professor() {
	}
	
	public Professor(String nome, String graduacao, String telefoneNumero) {
		this.nome = nome;
		this.graduacao = graduacao;
		this.telefoneNumero = telefoneNumero;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getGraduacao() {
		return graduacao;
	}
	
	public void setGraduacao(String graduacao) {
		this.graduacao = graduacao;
	}
	
	public String getTelefoneNumero() {
		return telefoneNumero;
	}
	
	public void setTelefoneNumero(String telefoneNumero) {
		this.telefoneNumero = telefoneNumero;
	}
	
	public List<Disciplina> getMatriculasProfessor() {
		return matriculasProfessor;
	}

	public Long getId() {
		return id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Professor other = (Professor) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Professor [id=" + id + ", nome=" + nome + ", graduacao=" + graduacao + ", telefoneNumero="
				+ telefoneNumero + "]";
	}
}