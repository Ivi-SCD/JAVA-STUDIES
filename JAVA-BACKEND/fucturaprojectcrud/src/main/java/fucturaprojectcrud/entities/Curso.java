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
@Table(name = "tb_curso")
public class Curso implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private Integer semestres;
	
	@OneToMany(mappedBy = "id.curso", cascade = CascadeType.ALL)
	private List <Matricula> matriculasCurso = new ArrayList<>();
	
	@OneToMany(mappedBy = "curso", cascade = CascadeType.ALL)
	private List <Disciplina> matriculasDisciplina = new ArrayList<>();
	
	public Curso() {
	}
	
	public Curso(String nome, Integer semestres) {
		this.nome = nome;
		this.semestres = semestres;
	}
	
	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getSemestres() {
		return semestres;
	}

	public void setSemestres(Integer semestres) {
		this.semestres = semestres;
	}

	public List <Matricula> getMatriculasCurso() {
		return matriculasCurso;
	}
	
	public List<Disciplina> getMatriculasDisciplina() {
		return matriculasDisciplina;
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
		Curso other = (Curso) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Curso [id=" + id + ", nome=" + nome + ", semestres=" + semestres + "]";
	}
}