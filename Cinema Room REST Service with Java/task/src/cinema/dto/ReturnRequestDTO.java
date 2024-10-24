package cinema.dto;

/**
 * DTO class for return requests.
 * Contains the token to identify the ticket.
 */
public class ReturnRequestDTO {
    private String token;

    public ReturnRequestDTO() {}

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
