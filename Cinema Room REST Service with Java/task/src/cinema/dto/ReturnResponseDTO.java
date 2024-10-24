package cinema.dto;

import cinema.model.Seat;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * DTO class for return response.
 * Contains the seat that was made available after return.
 */
public class ReturnResponseDTO {
    @JsonProperty("ticket")
    private Seat seat;

    public ReturnResponseDTO(Seat seat) {
        this.seat = seat;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }
}
