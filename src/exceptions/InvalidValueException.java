package exceptions;

public class InvalidValueException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidValueException() {
		super("The value entered not is valid");
	}
}
