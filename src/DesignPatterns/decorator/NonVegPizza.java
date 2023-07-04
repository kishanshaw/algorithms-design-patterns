package DesignPatterns.decorator;

public class NonVegPizza extends BasePizza {
    @Override
    public int cost() {
        return 150;
    }
}
