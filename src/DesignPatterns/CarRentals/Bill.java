package DesignPatterns.CarRentals;

public class Bill {
    private Reservation reservation;
    private double amountToBePaid;
    private boolean isPaid;

    public Bill(Reservation reservation, double amountToBePaid, boolean isPaid) {
        this.reservation = reservation;
        this.amountToBePaid = amountToBePaid;
        this.isPaid = isPaid;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "reservation=" + reservation +
                ", amountToBePaid=" + amountToBePaid +
                ", isPaid=" + isPaid +
                '}';
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public double getAmountToBePaid() {
        return amountToBePaid;
    }

    public void setAmountToBePaid(double amountToBePaid) {
        this.amountToBePaid = amountToBePaid;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }
}
