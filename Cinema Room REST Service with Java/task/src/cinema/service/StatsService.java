package cinema.service;

import cinema.model.Seat;
import cinema.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class that handles statistics calculation for the cinema.
 */
@Service
public class StatsService {
    private final SeatRepository seatRepository;

    /**
     * Autowired constructor to inject the SeatRepository.
     *
     * @param seatRepository the repository that holds the seat data.
     */
    @Autowired
    public StatsService(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    /**
     * Calculates and returns the statistics for the cinema room.
     *
     * @return Statistics object containing the total income, number of available seats, and number of purchased tickets.
     */
    public Statistics getStatistics() {
        List<Seat> seats = seatRepository.getAllSeats();

        int income = 0;
        int availableSeats = 0;
        int purchasedTickets = 0;

        for (Seat seat : seats) {
            if (seat.isAvailable()) {
                availableSeats++;
            } else {
                purchasedTickets++;
                income += seat.getPrice();
            }
        }

        return new Statistics(income, availableSeats, purchasedTickets);
    }

    /**
     * Statistics inner class used to represent cinema statistics.
     */
    public static class Statistics {
        private final int income;
        private final int available;
        private final int purchased;

        public Statistics(int income, int available, int purchased) {
            this.income = income;
            this.available = available;
            this.purchased = purchased;
        }

        // Getters for JSON serialization

        public int getIncome() {
            return income;
        }

        public int getAvailable() {
            return available;
        }

        public int getPurchased() {
            return purchased;
        }
    }
}
