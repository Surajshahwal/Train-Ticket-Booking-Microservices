package in.train.responce;

import java.time.LocalDateTime;

/**
 * Ticket response DTO.
 * This class is sent back to client after successful ticket booking
 * or when fetching ticket details.
 */
public class Ticket {

    // Unique ticket ID
    private Integer ticketId;

    // Full name of passenger
    private String passengerName;

    // Source station
    private String from;

    // Destination station
    private String to;

    // Train number
    private String trainNum;

    // Ticket cost
    private String tktCost;

    // Ticket status (e.g., CONFIRMED, WAITING, CANCELLED)
    private String ticketStatus;

    // PNR number for the ticket
    private String pnr;

    // Ticket booking date and time
    private LocalDateTime bookingTime;

    // Getters and Setters

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
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

    public String getTrainNum() {
        return trainNum;
    }

    public void setTrainNum(String trainNum) {
        this.trainNum = trainNum;
    }

    public String getTktCost() {
        return tktCost;
    }

    public void setTktCost(String tktCost) {
        this.tktCost = tktCost;
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
