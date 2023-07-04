package DesignPatterns.strategypattern;

public class SeaStrategy implements RouteStrategy {
    @Override
    public void buildRoute() {
        System.out.println("Take the sea route");
    }
}
