package fucturaprojectcrud.db;

public class DbPersistenceException extends DbExceptions {

	private static final long serialVersionUID = 1L;

	public DbPersistenceException(String msg) {
		super(msg, 1);
	}
}