package cinema.dto;

import cinema.model.Seat;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * DTO class for the purchase response.
 * Contains the row, column, and price of the purchased seat.
 */
public class PurchaseResponseDTO {
    String token;
    @JsonProperty("ticket")
    Seat seat;

    public PurchaseResponseDTO(String token, Seat seat) {
        this.token = token;
        this.seat = seat;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }
}
