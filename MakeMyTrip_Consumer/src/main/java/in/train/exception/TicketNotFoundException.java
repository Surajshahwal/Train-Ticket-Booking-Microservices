package in.train.exception;

/**
 * Custom exception thrown when a ticket is not found in the system.
 * 
 * This exception is used in both Provider and Consumer services
 * when a requested ticket ID does not exist in the database
 * or when the provider returns a 404 response.
 */
public class TicketNotFoundException extends RuntimeException {

	/**
	 * Default constructor.
	 */
	public TicketNotFoundException() {
		super();
	}

	/**
	 * Constructor with custom error message.
	 * 
	 * @param message detailed error message
	 */
	public TicketNotFoundException(String message) {
		super(message);
	}
}
