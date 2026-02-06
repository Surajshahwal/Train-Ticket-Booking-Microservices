package in.train.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import in.train.entity.TicketEntity;
import in.train.exception.TicketNotFoundException;
import in.train.repository.TicketRepository;
import in.train.request.Passenger;
import in.train.responce.Ticket;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

/**
 * Service class that contains all business logic related to
 * ticket booking, fetching, cancelling and searching tickets.
 */
@Service
public class TicketService {

    // Logger for logging important application events
    private static final Logger logger = LoggerFactory.getLogger(TicketService.class);

    // Repository to perform database operations on TicketEntity
    @Autowired
    private TicketRepository ticketRepository;

    /**
     * This method books a new ticket for a passenger.
     * It converts Passenger request to TicketEntity,
     * saves it into database and returns Ticket response DTO.
     */
    public Ticket bookTicket(Passenger passenger) {

        // Create entity object from passenger request
        TicketEntity entity = new TicketEntity();

        // Set passenger details
        entity.setPassengerFirstName(passenger.getFname());
        entity.setPassengerLastName(passenger.getLname());
        entity.setGender(passenger.getGender());

        // Set journey details
        entity.setFromStation(passenger.getFrom());
        entity.setToStation(passenger.getTo());
        entity.setJourneyDate(LocalDate.parse(passenger.getDoj()));
        entity.setTrainNumber(passenger.getTrainNum());

        // Calculate and set ticket cost
        entity.setTicketCost(calculateFare(passenger.getFrom(), passenger.getTo()));

        // Set ticket status as CONFIRMED
        entity.setTicketStatus("CONFIRMED");

        // Generate unique PNR number
        entity.setPnr(generatePNR());

        // Set current booking time
        entity.setBookingTime(LocalDateTime.now());

        // Save ticket details into database
        TicketEntity savedEntity = ticketRepository.save(entity);

        // Log booking information
        logger.info("Booking ticket for passenger: {} {}", passenger.getFname(), passenger.getLname());
        logger.info("Ticket booked successfully with ID: {}", savedEntity.getTicketId());

        // Convert saved entity to response DTO and return
        return convertToResponse(savedEntity);
    }

    /**
     * This method fetches ticket details by ticket ID.
     * If ticket is not found, it throws TicketNotFoundException.
     */
    public Ticket getTicketById(Integer ticketId) {
        TicketEntity entity = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new TicketNotFoundException("Ticket not found with ID: " + ticketId));

        // Convert entity to response DTO
        return convertToResponse(entity);
    }

    /**
     * This method cancels a ticket by changing its status to CANCELLED.
     */
    public void cancelTicket(Integer ticketId) {
        TicketEntity entity = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new TicketNotFoundException("Ticket not found with ID: " + ticketId));

        // Update ticket status
        entity.setTicketStatus("CANCELLED");

        // Save updated entity
        ticketRepository.save(entity);
    }

    /**
     * This method returns all tickets with pagination support.
     */
    public Page<Ticket> getAllTickets(Pageable pageable) {
        // Fetch paginated data from database and convert to response DTO
        return ticketRepository.findAll(pageable).map(this::convertToResponse);
    }

    /**
     * This method searches tickets by PNR or by passenger name.
     * If both are empty, it returns all tickets.
     */
    public List<Ticket> searchTickets(String pnr, String passengerName) {

        List<TicketEntity> results;

        // Search by PNR if provided
        if (pnr != null && !pnr.isBlank()) {
            results = ticketRepository.findByPnr(pnr);
        }
        // Otherwise search by passenger first or last name
        else if (passengerName != null && !passengerName.isBlank()) {
            results = ticketRepository
                    .findByPassengerFirstNameContainingIgnoreCaseOrPassengerLastNameContainingIgnoreCase(
                            passengerName, passengerName
                    );
        }
        // If no search parameter is provided, fetch all tickets
        else {
            results = ticketRepository.findAll();
        }

        // Convert entity list to response DTO list
        return results.stream()
                .map(this::convertToResponse)
                .toList();
    }

    /**
     * This method calculates fare between two stations.
     * Currently it returns a fixed price.
     */
    private Double calculateFare(String from, String to) {
        // Simple fare calculation - you can make it complex later
        return 500.00;
    }

    /**
     * This method generates a random 10-digit PNR number.
     */
    private String generatePNR() {
        Random random = new Random();
        return String.format("%010d", random.nextInt(1000000000));
    }

    /**
     * This method converts TicketEntity to Ticket response DTO.
     */
    private Ticket convertToResponse(TicketEntity entity) {
        Ticket ticket = new Ticket();

        // Set response fields from entity
        ticket.setTicketId(entity.getTicketId());
        ticket.setPassengerName(entity.getPassengerFirstName() + " " + entity.getPassengerLastName());
        ticket.setFrom(entity.getFromStation());
        ticket.setTo(entity.getToStation());
        ticket.setTrainNum(entity.getTrainNumber());
        ticket.setTktCost(entity.getTicketCost() + " INR");
        ticket.setTicketStatus(entity.getTicketStatus());
        ticket.setPnr(entity.getPnr());
        ticket.setBookingTime(entity.getBookingTime());

        return ticket;
    }
}
