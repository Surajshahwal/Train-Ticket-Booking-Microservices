package in.train.api;

import java.time.LocalDateTime;

/**
 * Generic API response wrapper class.
 * 
 * This class is used to send a standard and consistent response structure from
 * the Consumer service to the client.
 * 
 * @param <T> the type of data that will be sent in the response
 */
public class ApiResponse<T> {

	// Indicates whether the API call was successful or not
	private boolean success;

	// Message describing the result of the API call
	private String message;

	// Actual response data (can be any type)
	private T data;

	// Timestamp when the response was generated
	private LocalDateTime timestamp;

	// Default constructor (required for serialization/deserialization)
	public ApiResponse() {

	}

	/**
	 * Parameterized constructor to create ApiResponse with all fields.
	 * 
	 * @param success   status of the API call
	 * @param message   message for the client
	 * @param data      actual response data
	 * @param timestamp time when response is created
	 */
	public ApiResponse(boolean success, String message, T data, LocalDateTime timestamp) {
		super();
		this.success = success;
		this.message = message;
		this.data = data;
		this.timestamp = timestamp;
	}

	// Getter and Setter methods

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

}
