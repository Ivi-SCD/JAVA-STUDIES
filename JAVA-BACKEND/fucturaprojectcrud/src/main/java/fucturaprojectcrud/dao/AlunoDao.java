package fucturaprojectcrud.dao;

import java.util.List;

import fucturaprojectcrud.entities.Aluno;

public interface AlunoDao {
	
	void insert(Aluno aluno);
	void deleteById(Long id);
	void updateAluno(Long id, Aluno aluno);
	List <Aluno> findAll();
	Aluno findById(Long id);
	void closeConnections();
}