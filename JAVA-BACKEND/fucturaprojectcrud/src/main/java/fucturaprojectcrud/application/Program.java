package fucturaprojectcrud.application;

import java.text.ParseException;
import java.util.Arrays;
import java.util.List;

import fucturaprojectcrud.dao.AlunoDao;
import fucturaprojectcrud.dao.CursoDao;
import fucturaprojectcrud.dao.DaoFactory;
import fucturaprojectcrud.dao.DisciplinaDao;
import fucturaprojectcrud.dao.EnderecoDao;
import fucturaprojectcrud.dao.MatriculaDao;
import fucturaprojectcrud.dao.ProfessorDao;
import fucturaprojectcrud.entities.Aluno;
import fucturaprojectcrud.entities.Curso;
import fucturaprojectcrud.entities.Disciplina;
import fucturaprojectcrud.entities.Endereco;
import fucturaprojectcrud.entities.Matricula;
import fucturaprojectcrud.entities.Professor;

public class Program {
	
	public static void main(String [] args) throws ParseException {
					
		EnderecoDao edao = DaoFactory.createEnderecoDao();
		AlunoDao adao = DaoFactory.createAlunoDao();
		ProfessorDao pdao = DaoFactory.createProfessorDao();
		CursoDao cdao = DaoFactory.createCursoDao();
		MatriculaDao mdao = DaoFactory.createMatriculaDao();
		DisciplinaDao ddao = DaoFactory.createDisciplinaDao();
		
		// Populando a tabela
		Endereco endereco_um = new Endereco("Tv. Coronel Frederico Lundgreen", 50, "Rio Doce", "Olinda", "PE");
		Endereco endereco_dois = new Endereco("Rua Ferreiros", 60, "Paulista", "Olinda", "PE");
		Endereco endereco_tres = new Endereco("Rua Jose Lima", 101, "Paulista", "Olinda", "PE");
		
		Aluno aluno_um = new Aluno("Ivisson Pereira", "111.222.333-44", "11/11/2011", 'M', endereco_um);
		Aluno aluno_dois = new Aluno("Lucas Martins", "222.333.444-55", "27/05/2003", 'M', endereco_dois);
		Aluno aluno_tres = new Aluno("Argus Lima", "333.444.555-66", "06/02/2003", 'M', endereco_tres);
		
		Aluno alunoNovo = new Aluno(aluno_um.getNome(), aluno_um.getCpf(), "11/12/2003", aluno_um.getSexo(), endereco_dois);
		
		Professor professor_um = new Professor("Aluisio Azevedo", "Bacharelado em CC", "99999-9999");
		Professor professor_dois = new Professor("Pedro Augusto", "Bacharelado em SI", "88888-8888");
		
		Curso curso_um = new Curso("Java FullStack Software Developer", 4);
		Curso curso_dois = new Curso("Formação FullStack Cloud AWS", 4);
		Curso curso_tres = new Curso("Formação FrontEnd", 2);
		
		Matricula matricula_um = new Matricula(aluno_um, curso_um);
		Matricula matricula_dois = new Matricula(aluno_dois, curso_dois);
		Matricula matricula_tres = new Matricula(aluno_tres, curso_tres);
		
		Disciplina disciplina_um = new Disciplina("Java - Operators e Arithmetic Expressions", curso_um, professor_um);
		Disciplina disciplina_dois = new Disciplina("Java - POO", curso_um, professor_um);
		Disciplina disciplina_tres = new Disciplina("Java - Collections", curso_um, professor_dois);
		Disciplina disciplina_quatro = new Disciplina("Java - JPA/Hibernate", curso_um, professor_um);
		
		// Criacao de listas para facilitar a manipulacao de dados
		List <Aluno> listAlunos = Arrays.asList(aluno_um,aluno_dois,aluno_tres);
		List <Professor> listProfessores = Arrays.asList(professor_um,professor_dois);
		List <Curso> listCursos = Arrays.asList(curso_um,curso_dois,curso_tres);
		
		List <Matricula> listMatriculas = Arrays.asList(matricula_um,matricula_dois,matricula_tres);
		List <Disciplina> listDisciplinas = Arrays.asList(disciplina_um,disciplina_dois,disciplina_tres,disciplina_quatro);
		
		
		// C - Create	
		listAlunos.forEach(adao::insert);
		listCursos.forEach(cdao::insert);
		listProfessores.forEach(pdao::insert);
		
		listDisciplinas.forEach(ddao::insert);
		listMatriculas.forEach(mdao::insert);
		
		// R - Review
		edao.findAll().forEach(System.out::println);
		adao.findAll().forEach(System.out::println);
		pdao.findAll().forEach(System.out::println);
		cdao.findAll().forEach(System.out::println);
		
		// U - Update
		adao.updateAluno(1L, alunoNovo);
		
		// D - Delete
		adao.deleteById(3L);
		cdao.deleteById(3L);
		pdao.deleteById(2L);

	}
}