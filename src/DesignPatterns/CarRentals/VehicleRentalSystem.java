package DesignPatterns.CarRentals;

import java.util.ArrayList;
import java.util.List;

public class VehicleRentalSystem {
    private List<Store> stores;
    private List<Vehicle> vehicles;

    public VehicleRentalSystem() {
        stores = new ArrayList<>();
        vehicles = new ArrayList<>();
    }

    public VehicleRentalSystem(List<Store> stores, List<Vehicle> vehicles) {
        this.stores = stores;
        this.vehicles = vehicles;
    }

    public List<Store> getStores() {
        return stores;
    }

    public void setStores(List<Store> stores) {
        this.stores = stores;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public void addVehicle(int storeId, Vehicle vehicle) {
        for (Store store : stores) {
            if (store.getStoreId() == storeId) {
                store.getVehicleInventory().addVehicle(vehicle);
            }
        }
    }

    public void removeVehicle(int storeId, Vehicle vehicle) {
        for (Store store : stores) {
            if (store.getStoreId() == storeId) {
                store.getVehicleInventory().updateStatus(vehicle.getVehicleId(), Status.INACTIVE);
            }
        }
    }

    public void addStores(Store store) {
        stores.add(store);
    }

}
