package DesignPatterns.factory;

public class AutomaticButton implements Button {
    @Override
    public void render() {
        System.out.println("This is an automatic button!");
    }
}
