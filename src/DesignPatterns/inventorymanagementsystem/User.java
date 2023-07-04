package DesignPatterns.inventorymanagementsystem;

public class User {
    private int userId;
    private String name;
    private Location location;
    private Cart cart;
    private Warehouse warehouse;

    public User(int userId, String name, Location location, Cart cart) {
        this.userId = userId;
        this.name = name;
        this.location = location;
        this.cart = cart;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
