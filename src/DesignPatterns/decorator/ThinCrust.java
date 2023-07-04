package DesignPatterns.decorator;

public class ThinCrust extends ToppingDecorator {

    BasePizza basePizza;

    public ThinCrust(BasePizza basePizza) {
        this.basePizza = basePizza;
    }

    @Override
    public int cost() {
        return this.basePizza.cost() + 35;
    }
}
