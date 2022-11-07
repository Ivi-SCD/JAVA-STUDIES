package fucturaoracleprojectcrud.dao;

import java.util.List;

import fucturaprojectcrud.entities.Curso;

public interface CursoDao {
	
	void insert(Curso curso);
	void deleteById(Long id);
	void updateCurso(Long id, Curso aluno);
	List <Curso> findAll();
	Curso findById(Long id);
	void closeConnections();
}