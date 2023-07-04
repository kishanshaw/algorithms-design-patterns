package DesignPatterns.strategypattern;

public class RoadStrategy implements RouteStrategy {
    @Override
    public void buildRoute() {
        System.out.println("Take the road route");
    }
}
