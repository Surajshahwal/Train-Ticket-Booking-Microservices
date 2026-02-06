package in.train.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Entity class representing the "tickets" table in the database.
 * This class is used by JPA/Hibernate to map Java objects to database records.
 */
@Entity
@Table(name = "tickets")
public class TicketEntity {

    // Primary key of the tickets table
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_id")
    private Integer ticketId;

    // Passenger first name (cannot be null)
    @Column(name = "passenger_first_name", nullable = false)
    private String passengerFirstName;

    // Passenger last name (cannot be null)
    @Column(name = "passenger_last_name", nullable = false)
    private String passengerLastName;

    // Passenger gender
    @Column(name = "gender")
    private String gender;

    // Source station
    @Column(name = "from_station", nullable = false)
    private String fromStation;

    // Destination station
    @Column(name = "to_station", nullable = false)
    private String toStation;

    // Date of journey
    @Column(name = "journey_date")
    private LocalDate journeyDate;

    // Train number
    @Column(name = "train_number", nullable = false)
    private String trainNumber;

    // Ticket cost
    @Column(name = "ticket_cost")
    private Double ticketCost;

    // Ticket status (e.g., CONFIRMED, CANCELLED)
    @Column(name = "ticket_status")
    private String ticketStatus;

    // Unique PNR number for each ticket
    @Column(name = "pnr", unique = true)
    private String pnr;

    // Time when ticket was booked
    @Column(name = "booking_time")
    private LocalDateTime bookingTime;

    // Default constructor required by JPA
    public TicketEntity() {
    }

    // Getters and Setters

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public String getPassengerFirstName() {
        return passengerFirstName;
    }

    public void setPassengerFirstName(String passengerFirstName) {
        this.passengerFirstName = passengerFirstName;
    }

    public String getPassengerLastName() {
        return passengerLastName;
    }

    public void setPassengerLastName(String passengerLastName) {
        this.passengerLastName = passengerLastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFromStation() {
        return fromStation;
    }

    public void setFromStation(String fromStation) {
        this.fromStation = fromStation;
    }

    public String getToStation() {
        return toStation;
    }

    public void setToStation(String toStation) {
        this.toStation = toStation;
    }

    public LocalDate getJourneyDate() {
        return journeyDate;
    }

    public void setJourneyDate(LocalDate journeyDate) {
        this.journeyDate = journeyDate;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    public Double getTicketCost() {
        return ticketCost;
    }

    public void setTicketCost(Double ticketCost) {
        this.ticketCost = ticketCost;
    }

    public String getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(String ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public String getPnr() {
        return pnr;
    }

    public void setPnr(String pnr) {
        this.pnr = pnr;
    }

    public LocalDateTime getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(LocalDateTime bookingTime) {
        this.bookingTime = bookingTime;
    }
}
