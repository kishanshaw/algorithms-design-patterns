package DesignPatterns.decorator;

public class ChickenTikka extends ToppingDecorator {
    BasePizza basePizza;

    public ChickenTikka(BasePizza basePizza) {
        this.basePizza = basePizza;
    }

    @Override
    public int cost() {
        return this.basePizza.cost() + 45;
    }
}
