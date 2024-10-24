package cinema.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Model class that represents a seat in the cinema room.
 * Contains the row and column attributes that define the seat's location.
 */
public class Seat {
    private int row;
    private int column;
    private boolean isAvailable;
    private int price;

    public Seat(int row, int column, boolean isAvailable, int price) {
        this.row = row;
        this.column = column;
        this.isAvailable = isAvailable;
        this.price = price;
    }

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

    @JsonIgnore
    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
