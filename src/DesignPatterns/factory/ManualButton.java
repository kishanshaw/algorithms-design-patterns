package DesignPatterns.factory;

public class ManualButton implements Button {
    @Override
    public void render() {
        System.out.println("This is a manual button!");
    }
}
