package in.train.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import in.train.api.ApiResponse;
import in.train.request.Passenger;
import in.train.responce.Ticket;
import in.train.service.TicketService;

import java.time.LocalDateTime;
import java.util.List;

/**
 * TicketController ---------------- This controller exposes REST APIs for Train
 * Ticket Booking system (IRCTC Provider). It handles: - Booking a ticket -
 * Fetching ticket by ID - Cancelling a ticket - Fetching all tickets with
 * pagination - Searching tickets by PNR or Passenger Name
 */

@RestController
@RequestMapping("/api/tickets")
@Tag(name = "Train Ticket Booking API", description = "IRCTC Provider - RESTful APIs for ticket booking")
public class TicketController {
	// Injecting TicketService to handle business logic
	@Autowired
	private TicketService ticketService;

	// Book a new train ticket for a passenger

	@PostMapping
	@Operation(summary = "Book a train ticket", description = "Books a new train ticket for passenger")
	public ResponseEntity<ApiResponse<Ticket>> bookTicket(@Valid @RequestBody Passenger passenger) {

		// Call service layer to book ticket

		Ticket ticket = ticketService.bookTicket(passenger);
		// Wrap response in a standard ApiResponse object
		ApiResponse<Ticket> response = new ApiResponse<Ticket>(true, "Ticket booked successfully", ticket,
				LocalDateTime.now());
		return new ResponseEntity<ApiResponse<Ticket>>(response, HttpStatus.OK);
	}

	// Get ticket details by Ticket ID.
	@GetMapping("/{ticketId}")
	@Operation(summary = "Get ticket by ID", description = "Retrieves ticket details by ticket ID")
	public ResponseEntity<Ticket> getTicket(@PathVariable Integer ticketId) {
		// Fetch ticket from service layer
		Ticket ticket = ticketService.getTicketById(ticketId);
		return new ResponseEntity<>(ticket, HttpStatus.OK);
	}

	// Cancel a booked ticket by Ticket ID.

	@DeleteMapping("/{ticketId}")
	@Operation(summary = "Cancel ticket", description = "Cancels a booked ticket")
	public ResponseEntity<String> cancelTicket(@PathVariable Integer ticketId) {
		// Call service layer to cancel ticket
		ticketService.cancelTicket(ticketId);
		return new ResponseEntity<>("Ticket cancelled successfully", HttpStatus.OK);
	}

	// Get all tickets with pagination support.
	@GetMapping
	@Operation(summary = "Get all tickets", description = "Retrieves all booked tickets")
	public ResponseEntity<Page<Ticket>> getAllTickets(@RequestParam(defaultValue = "0") int pageNo,
			@RequestParam(defaultValue = "10") int pageSize

	) {

		// Create Pageable object for pagination
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		// Fetch paginated tickets from service layer
		Page<Ticket> tickets = ticketService.getAllTickets(pageable);
		return new ResponseEntity<Page<Ticket>>(tickets, HttpStatus.OK);
	}

	/*
	 * Search tickets by PNR or Passenger Name. Both parameters are optional: - If
	 * PNR is provided, search by PNR - Else if passengerName is provided, search by
	 * name - Else return all tickets
	 */

	@GetMapping("/search")
	@Operation(summary = "Search tickets by PNR or passenger name", description = "Searches tickets using PNR or passenger first/last name. Both parameters are optional.")
	public ResponseEntity<List<Ticket>> searchTickets(@RequestParam(required = false) String pnr,
			@RequestParam(required = false) String passengerName) {
		// Call service layer to search tickets
		List<Ticket> tickets = ticketService.searchTickets(pnr, passengerName);
		return new ResponseEntity<List<Ticket>>(tickets, HttpStatus.OK);

	}
}