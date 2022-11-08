package fucturaprojectcrud.dao;

import fucturaprojectcrud.dao.impl.AlunoDaoEm;
import fucturaprojectcrud.dao.impl.CursoDaoEm;
import fucturaprojectcrud.dao.impl.DisciplinaDaoEm;
import fucturaprojectcrud.dao.impl.EnderecoDaoEm;
import fucturaprojectcrud.dao.impl.MatriculaDaoEm;
import fucturaprojectcrud.dao.impl.ProfessorDaoEm;

public class DaoFactory {
	
	public static EnderecoDao createEnderecoDao() {
		return new EnderecoDaoEm();
	}
	
	public static AlunoDao createAlunoDao () {
		return new AlunoDaoEm();
	}
	
	public static ProfessorDao createProfessorDao () {
		return new ProfessorDaoEm();
	}
	
	public static CursoDao createCursoDao () {
		return new CursoDaoEm();
	}
	
	public static MatriculaDao createMatriculaDao () {
		return new MatriculaDaoEm();
	}
	
	public static DisciplinaDao createDisciplinaDao () {
		return new DisciplinaDaoEm();
	}
}