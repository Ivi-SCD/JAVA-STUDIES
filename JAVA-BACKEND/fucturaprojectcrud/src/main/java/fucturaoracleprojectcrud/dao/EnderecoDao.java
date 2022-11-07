package fucturaoracleprojectcrud.dao;

import java.util.List;

import fucturaprojectcrud.entities.Endereco;

public interface EnderecoDao {
	
	void insert(Endereco endereco);
	void deleteById(Long id);
	void updateEndereco(Long id, Endereco endereco);
	List <Endereco> findAll();
	Endereco findById(Long id);
	void closeConnections();
}