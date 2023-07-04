package DesignPatterns.strategypattern;

public class HumanNavigator extends Navigator {
    public HumanNavigator() {
        super(new RoadStrategy());
    }
}
