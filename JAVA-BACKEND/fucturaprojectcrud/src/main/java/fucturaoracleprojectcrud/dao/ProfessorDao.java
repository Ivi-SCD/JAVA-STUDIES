package fucturaoracleprojectcrud.dao;

import java.util.List;

import fucturaprojectcrud.entities.Professor;

public interface ProfessorDao {

	void insert(Professor professor);
	void deleteById(Long id);
	void updateProfessor(Long id, Professor aluno);
	List <Professor> findAll();
	Professor findById(Long id);
	void closeConnections();
}