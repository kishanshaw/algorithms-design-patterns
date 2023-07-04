package DesignPatterns.strategypattern;

public class PlaneNavigator extends Navigator {
    public PlaneNavigator() {
        super(new AirStrategy());
    }
}
