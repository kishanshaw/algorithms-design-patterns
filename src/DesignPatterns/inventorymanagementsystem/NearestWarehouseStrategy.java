package DesignPatterns.inventorymanagementsystem;

import java.util.List;

public class NearestWarehouseStrategy implements WarehouseStrategy {

    public NearestWarehouseStrategy() {
    }


    @Override
    public Warehouse getWarehouse(List<Warehouse> warehouses, User user) {
        int pinCodeForUser = user.getLocation().getPinCode();
        for (Warehouse warehouse : warehouses) {
            if (warehouse.getLocation().getPinCode() == pinCodeForUser) {
                return warehouse;
            }
        }
        return warehouses.get(0);
    }
}
