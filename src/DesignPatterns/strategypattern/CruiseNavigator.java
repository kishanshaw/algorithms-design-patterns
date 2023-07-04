package DesignPatterns.strategypattern;

public class CruiseNavigator extends Navigator {
    public CruiseNavigator() {
        super(new SeaStrategy());
    }
}
