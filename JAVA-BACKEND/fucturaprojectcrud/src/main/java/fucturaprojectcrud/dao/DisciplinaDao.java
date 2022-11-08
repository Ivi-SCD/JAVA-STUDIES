package fucturaprojectcrud.dao;

import java.util.List;

import fucturaprojectcrud.entities.Disciplina;

public interface DisciplinaDao {
	
	void insert(Disciplina disciplina);
	void deleteById(Long id);
	void updateDisciplina(Long id, Disciplina disciplina);
	List <Disciplina> findAll();
	Disciplina findById(Long id);
	void closeConnections();
}