package cinema.controller;

import cinema.dto.CinemaResponseDTO;
import cinema.model.Seat;
import cinema.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * Controller class that handles the incoming HTTP requests.
 * This class provides REST endpoints for interacting with the cinema room.
 */
@RestController
public class CinemaController {
    private final CinemaService cinemaService;

    /**
     * Autowired constructor to inject the CinemaService.
     *
     * @param cinemaService the service that provides seat data.
     */
    @Autowired
    public CinemaController(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }

    /**
     * Endpoint to get the available seats in the cinema room.
     *
     * @return ResponseEntity containing the CinemaResponseDTO with all available seats.
     */
    @GetMapping("/seats")
    public ResponseEntity<CinemaResponseDTO> getAvailableSeats() {
        List<Seat> seats = cinemaService.getAllSeats();
        CinemaResponseDTO response = new CinemaResponseDTO(9, 9, seats);
        return ResponseEntity.ok(response);
    }

}
