package fucturaprojectcrud.entities;

import java.io.Serializable;
import java.text.ParseException;
import java.time.Instant;
import java.util.Date;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import fucturaprojectcrud.entities.pk.MatriculaPK;

@Entity
@Table(name = "tb_matricula")
public class Matricula implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MatriculaPK id = new MatriculaPK();
	
	@Temporal(TemporalType.DATE)
	private Date dataMatricula;

	public Matricula() {
	}
	
	public Matricula(Aluno aluno, Curso curso) throws ParseException {
		
		id.setAluno(aluno);
		id.setCurso(curso);
		
		this.dataMatricula = Date.from(Instant.now());
	}

	public Date getDataMatricula() {
		return dataMatricula;
	}

	public void setDataMatricula(Date dataMatricula) {
		this.dataMatricula = dataMatricula;
	}
	
	public Aluno getAluno() {
		return id.getAluno();
	}
	
	public void setAluno(Aluno aluno) {
		id.setAluno(aluno);
	}
	
	public Curso getCurso() {
		return id.getCurso();
	}
	
	public void setCurso(Curso curso) {
		id.setCurso(curso);
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
		Matricula other = (Matricula) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Matricula [id=" + id + ", dataMatricula=" + dataMatricula + "]";
	}
}