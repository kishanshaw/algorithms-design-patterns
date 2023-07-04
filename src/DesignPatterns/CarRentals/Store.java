package DesignPatterns.CarRentals;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private int storeId;
    private VehicleInventory vehicleInventory;
    private Location location;
    private List<Reservation> reservations;

    public Store() {
        reservations = new ArrayList<>();
        vehicleInventory = new VehicleInventory();
    }

    public Store(int storeId, VehicleInventory vehicleInventory, Location location, List<Reservation> reservations) {
        this.storeId = storeId;
        this.vehicleInventory = vehicleInventory;
        this.location = location;
        this.reservations = reservations;
    }

    public VehicleInventory getVehicleInventory() {
        return vehicleInventory;
    }

    public void setVehicleInventory(VehicleInventory vehicleInventory) {
        this.vehicleInventory = vehicleInventory;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    public void completeReservation(Reservation reservation) {
        for (Reservation reservation1 : reservations) {
            if (reservation1.getReservationId() == reservation.getReservationId()) {
                reservation1.setReservationStatus(ReservationStatus.COMPLETED);
                break;
            }
        }
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public Reservation getReservation(int reservationId) {
        for (Reservation reservation : reservations) {
            if (reservationId == reservation.getReservationId()) {
                return reservation;
            }
        }
        return null;
    }
}
