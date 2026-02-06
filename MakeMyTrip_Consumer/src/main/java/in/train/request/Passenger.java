package in.train.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

/**
 * Passenger DTO (Data Transfer Object)
 * 
 * This class is used to receive passenger details from the client
 * while booking a ticket. It also contains validation rules using
 * Jakarta Bean Validation annotations.
 */
public class Passenger {

	/**
	 * Passenger first name.
	 * Must not be blank and should be between 2 to 50 characters.
	 */
	@NotBlank(message = "First name is required")
	@Size(min = 2, max = 50)
	private String fname;

	/**
	 * Passenger last name.
	 * Must not be blank and should be between 2 to 50 characters.
	 */
	@NotBlank(message = "Last name is required")
	@Size(min = 2, max = 50)
	private String lname;

	/**
	 * Passenger gender.
	 * Allowed values: Male, Female, Other.
	 */
	@NotBlank(message = "Gender is required")
	@Pattern(regexp = "^(Male|Female|Other)$", message = "Gender must be Male, Female, or Other")
	private String gender;

	/**
	 * Source station code/name.
	 */
	@NotBlank(message = "Source station is required")
	private String from;

	/**
	 * Destination station code/name.
	 */
	@NotBlank(message = "Destination station is required")
	private String to;

	/**
	 * Date of journey in format: yyyy-MM-dd.
	 */
	@NotBlank(message = "Date of journey is required")
	@Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "Date format should be yyyy-MM-dd")
	private String doj;

	/**
	 * Train number.
	 * Must be exactly 5 digits.
	 */
	@NotBlank(message = "Train number is required")
	@Size(min = 5, max = 5, message = "Train number must be 5 digits")
	private String trainNum;

	// Getters and Setters

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getDoj() {
		return doj;
	}

	public void setDoj(String doj) {
		this.doj = doj;
	}

	public String getTrainNum() {
		return trainNum;
	}

	public void setTrainNum(String trainNum) {
		this.trainNum = trainNum;
	}

	/**
	 * toString method for logging and debugging purpose.
	 */
	@Override
	public String toString() {
		return "Passenger [fname=" + fname + ", lname=" + lname + ", gender=" + gender + ", from=" + from + ", to=" + to
				+ ", doj=" + doj + ", trainNum=" + trainNum + "]";
	}
}
