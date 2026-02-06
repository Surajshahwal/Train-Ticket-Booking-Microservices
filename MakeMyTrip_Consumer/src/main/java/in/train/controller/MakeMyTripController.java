package in.train.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import in.train.request.Passenger;
import in.train.responce.Ticket;
import in.train.service.MakeMyTripService;
import jakarta.validation.Valid;

/**
 * REST Controller for MakeMyTrip Consumer Service.
 * 
 * This controller exposes endpoints to:
 *  - Book a ticket via Provider service
 *  - Get ticket details by ticket ID
 *  - Cancel a ticket
 * 
 * It acts as a Consumer that communicates with the IRCTC Provider service
 * using WebClient through MakeMyTripService.
 */
@RestController
@RequestMapping("/api/makemytrip")
public class MakeMyTripController {

	@Autowired
	private MakeMyTripService service;

	/**
	 * Book a new ticket.
	 * 
	 * This endpoint accepts passenger details, validates them,
	 * and forwards the request to the Provider service via MakeMyTripService.
	 * 
	 * @param passenger Passenger request data
	 * @return Booked Ticket details with HTTP 201 (CREATED)
	 */
	@PostMapping("/book")
	public ResponseEntity<Ticket> bookTicket(@Valid @RequestBody Passenger passenger) {
		Ticket ticket = service.bookTicket(passenger);
		return new ResponseEntity<>(ticket, HttpStatus.CREATED);
	}

	/**
	 * Get ticket details by ticket ID.
	 * 
	 * This endpoint fetches ticket information from the Provider service
	 * using the given ticket ID.
	 * 
	 * @param ticketId Ticket ID
	 * @return Ticket details with HTTP 200 (OK)
	 */
	@GetMapping("/ticket/{ticketId}")
	public ResponseEntity<Ticket> getTicket(@PathVariable Integer ticketId) {
		Ticket ticket = service.getTicketById(ticketId);
		return new ResponseEntity<>(ticket, HttpStatus.OK);
	}

	/**
	 * Cancel a ticket by ticket ID.
	 * 
	 * This endpoint sends a cancel request to the Provider service
	 * and returns the response message.
	 * 
	 * @param ticketId Ticket ID
	 * @return Cancellation response message with HTTP 200 (OK)
	 */
	@DeleteMapping("/cancel/{ticketId}")
	public ResponseEntity<String> cancelTicket(@PathVariable Integer ticketId) {
		String response = service.cancelTicket(ticketId);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
