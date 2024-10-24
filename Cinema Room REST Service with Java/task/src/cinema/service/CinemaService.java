package cinema.service;

import cinema.model.Seat;
import cinema.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Service class that handles seat data retrieval logic.
 * Delegates data generation and storage to SeatRepository.
 */
@Service
public class CinemaService {
    private SeatRepository seatRepository;

    /**
     * Autowired constructor to inject the SeatRepository.
     *
     * @param seatRepository the repository that provides seat data.
     */
    @Autowired
    public CinemaService(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    /**
     * Retrieves all seats in the cinema.
     *
     * @return List of Seat objects representing all available seats.
     */
    public List<Seat> getAllSeats() {
        return seatRepository.getAllSeats(); // Fetch seats directly from repository
    }
}

