package in.train.api;

import java.time.LocalDateTime;

/**
 * Generic API response wrapper class.
 * 
 * This class is used to send a standard response structure
 * for all REST APIs in the application.
 *
 * @param <T> the type of data returned in the response
 */
public class ApiResponse<T> {

    // Indicates whether the API call was successful or not
    private boolean success;

    // Message related to the API response (success/failure info)
    private String message;

    // Actual response data (can be any type)
    private T data;

    // Time when the response was generated
    private LocalDateTime timestamp;

    // Default constructor
    public ApiResponse() {
    }

    // Parameterized constructor
    public ApiResponse(boolean success, String message, T data, LocalDateTime timestamp) {
        super();
        this.success = success;
        this.message = message;
        this.data = data;
        this.timestamp = timestamp;
    }

    // Getters and Setters

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
