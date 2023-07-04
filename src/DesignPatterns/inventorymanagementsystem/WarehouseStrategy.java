package DesignPatterns.inventorymanagementsystem;

import java.util.List;

public interface WarehouseStrategy {
    Warehouse getWarehouse(List<Warehouse> warehouses, User user);
}
