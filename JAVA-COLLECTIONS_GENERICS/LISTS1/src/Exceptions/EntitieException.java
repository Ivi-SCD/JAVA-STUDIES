package Exceptions;

public class EntitieException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public EntitieException (String msg) {
		super(msg);
	}
}