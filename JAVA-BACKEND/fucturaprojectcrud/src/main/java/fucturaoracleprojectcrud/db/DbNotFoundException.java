package fucturaoracleprojectcrud.db;

public class DbNotFoundException extends DbExceptions {

	private static final long serialVersionUID = 1L;
	
	public DbNotFoundException(Object id) {
		super("Not Found: " + id, 404);
	}
}