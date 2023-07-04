package DesignPatterns.strategypattern;

public class AirStrategy implements RouteStrategy {
    @Override
    public void buildRoute() {
        System.out.println("Take the air route");
    }
}
