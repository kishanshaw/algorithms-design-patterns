package DesignPatterns.inventorymanagementsystem;

import java.util.ArrayList;
import java.util.List;

public class WarehouseController {
    private List<Warehouse> warehouses;
    private WarehouseStrategy warehouseStrategy;

    public WarehouseController() {
        warehouses = new ArrayList<>();
        warehouseStrategy = new DefaultWarehouseStrategy();
    }

    public WarehouseController(List<Warehouse> warehouses, WarehouseStrategy warehouseStrategy) {
        this.warehouses = warehouses;
        this.warehouseStrategy = warehouseStrategy;
    }

    public WarehouseController(List<Warehouse> warehouses) {
        this.warehouses = warehouses;
    }

    public WarehouseStrategy getWarehouseStrategy() {
        return warehouseStrategy;
    }

    public void addWarehouse(Warehouse warehouse) {
        warehouses.add(warehouse);
    }

    public void removeWarehouse(Warehouse warehouse) {
        warehouses.remove(warehouse);
    }

    public List<Warehouse> getWarehouses() {
        return warehouses;
    }

    public void setWarehouses(List<Warehouse> warehouses) {
        this.warehouses = warehouses;
    }

    public Warehouse getWarehouse(User user) {
        return warehouseStrategy.getWarehouse(warehouses, user);
    }
}
