package DesignPatterns.strategypattern;

public class Navigator {
    RouteStrategy routeStrategy;

    public Navigator(RouteStrategy routeStrategy) {
        this.routeStrategy = routeStrategy;
    }

    public void buildRoute() {
        routeStrategy.buildRoute();
    }
}
