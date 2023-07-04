package DesignPatterns.CarRentals;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Reservation {
    private User user;
    private Vehicle vehicle;
    private int reservationId;
    private ReservationStatus reservationStatus;
    private LocalDateTime bookedFrom;
    private LocalDateTime bookedTill;
    private LocalDate bookingDate;
    private Location pickUpLocation;
    private Location dropLocation;

    public Reservation(User user, Vehicle vehicle, int reservationId, ReservationStatus reservationStatus, LocalDateTime bookedFrom, LocalDateTime bookedTill, LocalDate bookingDate, Location pickUpLocation, Location dropLocation) {
        this.user = user;
        this.vehicle = vehicle;
        this.reservationId = reservationId;
        this.reservationStatus = reservationStatus;
        this.bookedFrom = bookedFrom;
        this.bookedTill = bookedTill;
        this.bookingDate = bookingDate;
        this.pickUpLocation = pickUpLocation;
        this.dropLocation = dropLocation;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public ReservationStatus getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(ReservationStatus reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

    public LocalDateTime getBookedFrom() {
        return bookedFrom;
    }

    public void setBookedFrom(LocalDateTime bookedFrom) {
        this.bookedFrom = bookedFrom;
    }

    public LocalDateTime getBookedTill() {
        return bookedTill;
    }

    public void setBookedTill(LocalDateTime bookedTill) {
        this.bookedTill = bookedTill;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Location getPickUpLocation() {
        return pickUpLocation;
    }

    public void setPickUpLocation(Location pickUpLocation) {
        this.pickUpLocation = pickUpLocation;
    }

    public Location getDropLocation() {
        return dropLocation;
    }

    public void setDropLocation(Location dropLocation) {
        this.dropLocation = dropLocation;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "user=" + user +
                ", vehicle=" + vehicle +
                ", reservationId=" + reservationId +
                ", reservationStatus=" + reservationStatus +
                ", bookedFrom=" + bookedFrom +
                ", bookedTill=" + bookedTill +
                ", bookingDate=" + bookingDate +
                ", pickUpLocation=" + pickUpLocation +
                ", dropLocation=" + dropLocation +
                '}';
    }
}
