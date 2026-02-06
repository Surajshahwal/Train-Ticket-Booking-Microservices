package in.train.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientException;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import in.train.api.ApiResponse;
import in.train.exception.TicketNotFoundException;
import in.train.request.Passenger;
import in.train.responce.Ticket;

/**
 * Service class for MakeMyTrip Consumer.
 * 
 * This service communicates with the IRCTC Provider microservice
 * using Spring WebClient to:
 *  - Book a ticket
 *  - Fetch ticket details by ID
 *  - Cancel a ticket
 */
@Service
public class MakeMyTripService {

	private final WebClient webClient;

	/**
	 * Provider service base URL (configured in application.properties/yml)
	 */
	@Value("${irctc.provider.url}")
	private String providerUrl;

	public MakeMyTripService(WebClient.Builder webClientBuilder) {
		this.webClient = webClientBuilder.build();
	}

	/**
	 * Book a ticket via IRCTC Provider service.
	 * 
	 * This method sends a POST request with passenger details
	 * and expects an ApiResponse<Ticket> from the Provider.
	 * 
	 * @param passenger Passenger request data
	 * @return Booked Ticket details
	 */
	public Ticket bookTicket(Passenger passenger) {
		try {
			ApiResponse<Ticket> response = webClient
					.post()
					.uri(providerUrl)
					.contentType(MediaType.APPLICATION_JSON)
					.bodyValue(passenger)
					.retrieve()
					.bodyToMono(new ParameterizedTypeReference<ApiResponse<Ticket>>() {})
					.block();

			// Return only the actual Ticket data from ApiResponse
			return response.getData();

		} catch (WebClientResponseException.BadRequest ex) {
			// 400 Bad Request from Provider
			throw ex;
		} catch (WebClientResponseException ex) {
			// Other HTTP errors from Provider
			throw ex;
		} catch (Exception ex) {
			// Any unexpected error
			throw new RuntimeException("Error booking ticket : " + ex.getMessage());
		}
	}

	/**
	 * Get ticket details by ticket ID via IRCTC Provider service.
	 * 
	 * @param ticketId Ticket ID
	 * @return Ticket details
	 */
	public Ticket getTicketById(Integer ticketId) {
		try {
			return webClient.get()
					.uri(providerUrl + "/" + ticketId)
					.retrieve()
					.bodyToMono(Ticket.class)
					.block();

		} catch (WebClientResponseException.NotFound ex) {
			// 404 Not Found from Provider
			throw new TicketNotFoundException("Ticket not found with ID: " + ticketId);
		} catch (WebClientException ex) {
			// Client-side WebClient error
			throw ex;
		} catch (Exception ex) {
			// Any unexpected error
			throw new RuntimeException("Error fetching ticket: " + ex.getMessage());
		}
	}

	/**
	 * Cancel a ticket via IRCTC Provider service.
	 * 
	 * @param ticketId Ticket ID
	 * @return Cancellation response message
	 */
	public String cancelTicket(Integer ticketId) {
		try {
			return webClient
					.delete()
					.uri(providerUrl + "/" + ticketId)
					.retrieve()
					.bodyToMono(String.class)
					.block();

		} catch (WebClientResponseException.NotFound ex) {
			// 404 Not Found from Provider
			throw new TicketNotFoundException("Ticket not found with ID: " + ticketId);
		} catch (WebClientResponseException ex) {
			// Other HTTP errors from Provider
			throw ex;
		} catch (Exception ex) {
			// Any unexpected error
			throw new RuntimeException("Error cancelling ticket: " + ex.getMessage());
		}
	}
}
