package cinema.repository;

import cinema.model.Seat;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Repository class that acts as an in-memory database for storing and managing seat data.
 * Holds the state of the seats in the cinema.
 */
@Repository
public class SeatRepository {

    private final List<Seat> seats;

    /**
     * Constructor that initializes the seat data.
     * Creates a 9x9 grid of seats and marks all of them as available.
     */
    public SeatRepository() {
        seats = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 9; j++) {
                seats.add(new Seat(i, j, true, 10));  // By default, all seats are available
            }
        }

        for (int i = 5; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                seats.add(new Seat(i, j, true, 8));  // By default, all seats are available
            }
        }
    }

    /**
     * Finds a seat by its row and column.
     *
     * @param row    the row number of the seat.
     * @param column the column number of the seat.
     * @return the Seat object if found, or null otherwise.
     */
    public Seat findSeat(int row, int column) {
        Optional<Seat> seat = seats.stream()
                .filter(s -> s.getRow() == row && s.getColumn() == column)
                .findFirst();

        return seat.orElse(null);
    }

    /**
     * Returns all seats.
     *
     * @return list of all seats.
     */
    public List<Seat> getAllSeats() {
        return seats;
    }

}
