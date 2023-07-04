package DesignPatterns.inventorymanagementsystem;

import java.util.List;

public class DefaultWarehouseStrategy implements WarehouseStrategy {


    public DefaultWarehouseStrategy() {
    }

    @Override
    public Warehouse getWarehouse(List<Warehouse> warehouses, User user) {
        return warehouses.get(0);
    }
}
