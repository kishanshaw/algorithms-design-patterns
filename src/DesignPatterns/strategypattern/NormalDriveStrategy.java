package DesignPatterns.strategypattern;

public class NormalDriveStrategy implements DriveStrategy {
    @Override
    public void drive() {
        System.out.println("The vehicle runs with normal drive strategy");
    }
}
