package fucturaoracleprojectcrud.dao;

import java.util.List;

import fucturaprojectcrud.entities.Matricula;

public interface MatriculaDao {
	
	void insert(Matricula matricula);
	List <Matricula> findAll();
	Matricula findById(Long id);
	void closeConnections();
}
