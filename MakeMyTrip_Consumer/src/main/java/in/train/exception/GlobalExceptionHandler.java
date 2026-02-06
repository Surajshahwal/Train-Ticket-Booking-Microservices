package in.train.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.reactive.function.client.WebClientResponseException;

/**
 * Global exception handler for MakeMyTrip Consumer application.
 * 
 * This class handles:
 *  - Custom application exceptions
 *  - Validation errors
 *  - Errors coming from IRCTC Provider via WebClient
 *  - Generic/unexpected exceptions
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

	/**
	 * Handle TicketNotFoundException thrown by the application.
	 * 
	 * @param ex TicketNotFoundException
	 * @return 404 NOT FOUND response with error details
	 */
	@ExceptionHandler(TicketNotFoundException.class)
	public ResponseEntity<Map<String, Object>> handleTicketNotFound(TicketNotFoundException ex) {
		Map<String, Object> errorResponse = new HashMap<>();
		errorResponse.put("timestamp", LocalDateTime.now());
		errorResponse.put("status", HttpStatus.NOT_FOUND.value());
		errorResponse.put("error", "Not Found");
		errorResponse.put("message", ex.getMessage());

		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}

	/**
	 * Handle validation errors triggered by @Valid annotations.
	 * 
	 * @param ex MethodArgumentNotValidException
	 * @return 400 BAD REQUEST response with field-wise validation errors
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, Object>> handleValidationExceptions(MethodArgumentNotValidException ex) {
		Map<String, Object> errorResponse = new HashMap<>();
		Map<String, String> errors = new HashMap<>();

		// Collect all field validation errors
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});

		errorResponse.put("timestamp", LocalDateTime.now());
		errorResponse.put("status", HttpStatus.BAD_REQUEST.value());
		errorResponse.put("error", "Validation Failed");
		errorResponse.put("validationErrors", errors);

		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}

	/**
	 * Handle 400 Bad Request errors coming from IRCTC Provider via WebClient.
	 * 
	 * @param ex WebClientResponseException.BadRequest
	 * @return 400 BAD REQUEST response with custom message
	 */
	@ExceptionHandler(WebClientResponseException.BadRequest.class)
	public ResponseEntity<Map<String, Object>> handleWebClientBadRequest(WebClientResponseException.BadRequest ex) {
		Map<String, Object> errorResponse = new HashMap<>();
		errorResponse.put("timestamp", LocalDateTime.now());
		errorResponse.put("status", HttpStatus.BAD_REQUEST.value());
		errorResponse.put("error", "Bad Request");
		errorResponse.put("message", "Invalid request data");

		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}

	/**
	 * Handle all other HTTP errors coming from IRCTC Provider via WebClient.
	 * 
	 * @param ex WebClientResponseException
	 * @return Response with same HTTP status as provider
	 */
	@ExceptionHandler(WebClientResponseException.class)
	public ResponseEntity<Map<String, Object>> handleWebClientException(WebClientResponseException ex) {
		Map<String, Object> errorResponse = new HashMap<>();
		errorResponse.put("timestamp", LocalDateTime.now());
		errorResponse.put("status", ex.getStatusCode().value());
		errorResponse.put("error", "Provider Service Error");
		errorResponse.put("message", "Error communicating with IRCTC provider");

		return new ResponseEntity<>(errorResponse, ex.getStatusCode());
	}

	/**
	 * Handle any uncaught / generic exceptions.
	 * 
	 * @param ex Exception
	 * @return 500 INTERNAL SERVER ERROR response
	 */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Map<String, Object>> handleGenericException(Exception ex) {
		Map<String, Object> errorResponse = new HashMap<>();
		errorResponse.put("timestamp", LocalDateTime.now());
		errorResponse.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
		errorResponse.put("error", "Internal Server Error");
		errorResponse.put("message", "Something went wrong. Please try again later.");

		return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
