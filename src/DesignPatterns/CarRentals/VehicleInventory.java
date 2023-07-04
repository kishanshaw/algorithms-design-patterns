package DesignPatterns.CarRentals;

import java.util.ArrayList;
import java.util.List;

public class VehicleInventory {
    private List<Vehicle> vehicles;

    public VehicleInventory() {
        vehicles = new ArrayList<>();
    }

    public VehicleInventory(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public void addVehicle(Vehicle vehicle) {
        this.vehicles.add(vehicle);
    }

    public Vehicle getVehicle(int vehicleId) {
        return vehicles.stream().filter(vehicle -> vehicle.getStatus() == Status.ACTIVE && vehicle.getVehicleId() == vehicleId).findAny().orElse(null);
    }

    public void updateStatus(int vehicleId, Status status) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getVehicleId() == vehicleId) {
                vehicle.setStatus(status);
                break;
            }
        }
    }
}
