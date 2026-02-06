package in.train.exception;

/**
 * Custom exception thrown when a ticket is not found in the system.
 * 
 * This exception is used to indicate that the requested ticket ID
 * does not exist in the database.
 */
public class TicketNotFoundException extends RuntimeException {

    /**
     * Constructs a new TicketNotFoundException with the specified detail message.
     * 
     * @param message the detail message explaining why the exception occurred
     */
    public TicketNotFoundException(String message) {
        super(message);
    }
}
