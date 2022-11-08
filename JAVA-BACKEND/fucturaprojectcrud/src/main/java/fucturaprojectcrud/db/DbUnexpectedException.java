package fucturaprojectcrud.db;

public class DbUnexpectedException extends DbExceptions {

	private static final long serialVersionUID = 1L;

	public DbUnexpectedException(String msg) {
		super("Unexpected Error " + msg, 21);
	}
}