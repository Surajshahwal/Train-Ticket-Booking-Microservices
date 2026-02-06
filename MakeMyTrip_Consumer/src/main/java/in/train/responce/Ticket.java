package in.train.responce;

import java.time.LocalDateTime;

/**
 * Ticket Response DTO
 *
 * This class is used in the Consumer API (e.g., MakeMyTrip) to receive
 * and hold the ticket details returned by the Provider API (IRCTC).
 * It represents the final booking information sent back to the client.
 */
public class Ticket {

    // Unique identifier generated for each ticket
    private Integer ticketId;

    // Full name of the passenger for whom the ticket is booked
    private String passengerName;

    // Source station of the journey
    private String from;

    // Destination station of the journey
    private String to;

    // Train number associated with this journey
    private String trainNum;

    // Total fare/cost of the ticket
    private String tktCost;

    // Current booking status (e.g., CONFIRMED, CANCELLED, WAITING, etc.)
    private String ticketStatus;

    // PNR number (unique reference number for the booking)
    private String pnr;

    // Date and time when the ticket was successfully booked
    private LocalDateTime bookingTime;

    // ================== Getters and Setters ==================

    // Returns the unique ticket ID
    public Integer getTicketId() {
        return ticketId;
    }

    // Sets the unique ticket ID
    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    // Returns the passenger's full name
    public String getPassengerName() {
        return passengerName;
    }

    // Sets the passenger's full name
    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    // Returns the source station
    public String getFrom() {
        return from;
    }

    // Sets the source station
    public void setFrom(String from) {
        this.from = from;
    }

    // Returns the destination station
    public String getTo() {
        return to;
    }

    // Sets the destination station
    public void setTo(String to) {
        this.to = to;
    }

    // Returns the train number
    public String getTrainNum() {
        return trainNum;
    }

    // Sets the train number
    public void setTrainNum(String trainNum) {
        this.trainNum = trainNum;
    }

    // Returns the total ticket cost
    public String getTktCost() {
        return tktCost;
    }

    // Sets the total ticket cost
    public void setTktCost(String tktCost) {
        this.tktCost = tktCost;
    }

    // Returns the current ticket status
    public String getTicketStatus() {
        return ticketStatus;
    }

    // Sets the current ticket status
    public void setTicketStatus(String ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    // Returns the PNR number
    public String getPnr() {
        return pnr;
    }

    // Sets the PNR number
    public void setPnr(String pnr) {
        this.pnr = pnr;
    }

    // Returns the booking date and time
    public LocalDateTime getBookingTime() {
        return bookingTime;
    }

    // Sets the booking date and time
    public void setBookingTime(LocalDateTime bookingTime) {
        this.bookingTime = bookingTime;
    }

    // Returns a string representation of the Ticket object (useful for logging and debugging)
    @Override
    public String toString() {
        return "Ticket [ticketId=" + ticketId +
                ", passengerName=" + passengerName +
                ", from=" + from +
                ", to=" + to +
                ", trainNum=" + trainNum +
                ", tktCost=" + tktCost +
                ", ticketStatus=" + ticketStatus +
                ", pnr=" + pnr +
                ", bookingTime=" + bookingTime + "]";
    }
}
