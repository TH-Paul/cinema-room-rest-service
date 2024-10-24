package cinema.dto;

/**
 * DTO class for error messages.
 * Used for returning structured error responses.
 */
public class ErrorDTO {
    private String error;

    public ErrorDTO(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
