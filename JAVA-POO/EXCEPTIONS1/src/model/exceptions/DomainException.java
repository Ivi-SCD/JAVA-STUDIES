package model.exceptions;

public class DomainException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	// Runtime é um tipo de exceção que o compilador não obriga a tratar
	// Se for Exception o compilador o obriga a tratar
	// Ex: ParseException é um Exception
	
	public DomainException(String msg) {
		super(msg);
	}
}