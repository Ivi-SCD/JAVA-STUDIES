package fucturaoracleprojectcrud.dao;

import fucturaoracleprojectcrud.dao.impl.AlunoDaoEm;
import fucturaoracleprojectcrud.dao.impl.CursoDaoEm;
import fucturaoracleprojectcrud.dao.impl.DisciplinaDaoEm;
import fucturaoracleprojectcrud.dao.impl.EnderecoDaoEm;
import fucturaoracleprojectcrud.dao.impl.MatriculaDaoEm;
import fucturaoracleprojectcrud.dao.impl.ProfessorDaoEm;

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