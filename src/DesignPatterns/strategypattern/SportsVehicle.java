package DesignPatterns.strategypattern;

public class SportsVehicle extends Vehicle {
    public SportsVehicle() {
        super(new SuperDriveStrategy());
    }
}
