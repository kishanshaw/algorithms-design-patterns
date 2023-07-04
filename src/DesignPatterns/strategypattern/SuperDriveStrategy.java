package DesignPatterns.strategypattern;

public class SuperDriveStrategy implements DriveStrategy {
    @Override
    public void drive() {
        System.out.println("The vehicle runs with super drive strategy!");
    }
}
