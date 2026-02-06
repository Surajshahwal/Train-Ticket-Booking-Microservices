package in.train.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.train.entity.TicketEntity;

/**
 * Repository interface for TicketEntity.
 * This interface is responsible for all database operations related to tickets.
 * Spring Data JPA automatically provides implementation at runtime.
 */
@Repository
public interface TicketRepository extends JpaRepository<TicketEntity, Integer> {

    /**
     * Find tickets by exact PNR number.
     */
    List<TicketEntity> findByPnr(String pnr);

    /**
     * Find tickets by passenger first name (case-insensitive and partial match).
     */
    List<TicketEntity> findByPassengerFirstNameContainingIgnoreCase(String firstName);

    /**
     * Find tickets by passenger last name (case-insensitive and partial match).
     */
    List<TicketEntity> findByPassengerLastNameContainingIgnoreCase(String lastName);

    /**
     * Find tickets by passenger first name OR last name (case-insensitive and partial match).
     */
    List<TicketEntity> findByPassengerFirstNameContainingIgnoreCaseOrPassengerLastNameContainingIgnoreCase(
            String firstName, String lastName);
}
