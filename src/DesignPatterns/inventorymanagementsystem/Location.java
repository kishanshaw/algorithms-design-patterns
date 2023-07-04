package DesignPatterns.inventorymanagementsystem;

public class Location {
    private String address;
    private String state;
    private int pinCode;

    public Location() {
    }

    public Location(String address, String state, int pinCode) {
        this.address = address;
        this.state = state;
        this.pinCode = pinCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }
}
