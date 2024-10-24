package cinema.dto;

/**
 * DTO class for seat purchase requests.
 * Contains the row and column information of the seat to be purchased.
 */
public class PurchaseRequestDTO {
    private int row;
    private int column;

    public PurchaseRequestDTO() {}

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }
}
