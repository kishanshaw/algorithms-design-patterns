package DesignPatterns.inventorymanagementsystem;

public class Warehouse {
    private int warehouseId;
    private Inventory inventory;
    private Location location;

    public Warehouse() {
        location = new Location();
        inventory = new Inventory();
    }

    public Warehouse(int warehouseId, Inventory inventory, Location location) {
        this.warehouseId = warehouseId;
        this.inventory = inventory;
        this.location = location;
    }

    public int getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(int warehouseId) {
        this.warehouseId = warehouseId;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void removeItemFromInventory(int productCategoryId, int count) {
        inventory.removeProductsFromCategory(productCategoryId, count);
    }

}
