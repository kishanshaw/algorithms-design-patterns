package DesignPatterns.bookmyshow;

public class Seat {
    private int seatId;
    private String seatName;
    private SeatCategory seatCategory;

    public Seat() {
    }

    public Seat(int id, String seatName, SeatCategory seatCategory) {
        this.seatId = id;
        this.seatName = seatName;
        this.seatCategory = seatCategory;
    }

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public String getSeatName() {
        return seatName;
    }

    public void setSeatName(String seatName) {
        this.seatName = seatName;
    }

    public SeatCategory getSeatCategory() {
        return seatCategory;
    }

    public void setSeatCategory(SeatCategory seatCategory) {
        this.seatCategory = seatCategory;
    }
}
