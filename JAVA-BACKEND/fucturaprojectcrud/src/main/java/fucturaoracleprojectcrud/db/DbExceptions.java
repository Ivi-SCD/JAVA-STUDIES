package fucturaoracleprojectcrud.db;

public class DbExceptions extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public DbExceptions(String msg, Integer code) {
		super("ERRORMESSAGE: " + msg + "\nCODEERROR: " 
	+ code + "\nSTACKTRACE: ");
	}

}
