package cinema.service;

import cinema.dto.ErrorDTO;
import cinema.dto.PurchaseRequestDTO;
import cinema.dto.PurchaseResponseDTO;
import cinema.dto.ReturnResponseDTO;
import cinema.model.Seat;
import cinema.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Service class that contains the business logic for purchasing tickets.
 * Handles seat availability checking and marking seats as purchased.
 */
@Service
public class PurchaseService {
    private final SeatRepository seatRepository;
    private final Map<String, Seat> purchasedTickets;  // Stores purchased tickets with their tokens

    /**
     * Autowired constructor to inject the SeatRepository.
     *
     * @param seatRepository the repository that holds the seat data.
     */
    @Autowired
    public PurchaseService(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
        this.purchasedTickets = new HashMap<>();
    }

    /**
     * Handles the purchase of a seat based on the provided row and column.
     *
     * @param requestDTO the purchase request containing the row and column of the desired seat.
     * @return ResponseEntity with the purchase response or an error.
     */
    public ResponseEntity<?> purchaseSeat(PurchaseRequestDTO requestDTO) {
        // Validate if the requested seat is within valid range
        if (requestDTO.getRow() < 1 || requestDTO.getRow() > 9 ||
                requestDTO.getColumn() < 1 || requestDTO.getColumn() > 9) {
            ErrorDTO errorDTO = new ErrorDTO("The number of a row or a column is out of bounds!");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDTO);
        }

        // Check if the seat is available
        Seat seat = seatRepository.findSeat(requestDTO.getRow(), requestDTO.getColumn());
        if (seat == null || !seat.isAvailable()) {
            ErrorDTO errorDTO = new ErrorDTO("The ticket has been already purchased!");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDTO);
        }

        // Mark the seat as purchased
        seat.setAvailable(false);

        // Generate a unique token for the purchase
        String token = UUID.randomUUID().toString();
        purchasedTickets.put(token, seat);

        PurchaseResponseDTO responseDTO = new PurchaseResponseDTO(token, seat);
        return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
    }

    // Method to handle the return based on token
    public ResponseEntity<?> returnTicket(String token) {
        Seat seat = purchasedTickets.remove(token);
        if (seat == null) {
            ErrorDTO errorDTO = new ErrorDTO("Wrong token!");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDTO);
        }

        // Mark the seat as available again
        seat.setAvailable(true);
        ReturnResponseDTO responseDTO = new ReturnResponseDTO(seat);

        // Create response for returned ticket
        return ResponseEntity.status(HttpStatus.OK).body(responseDTO);

    }
}
