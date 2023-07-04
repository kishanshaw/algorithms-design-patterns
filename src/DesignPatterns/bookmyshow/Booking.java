package DesignPatterns.bookmyshow;

import java.util.List;

public class Booking {
    private User user;
    private Show show;
    private List<Seat> seats;
    private Payment payment;

    public Booking() {
    }

    public Booking(User user, Show show, List<Seat> seats, Payment payment) {
        this.user = user;
        this.show = show;
        this.seats = seats;
        this.payment = payment;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }
}
