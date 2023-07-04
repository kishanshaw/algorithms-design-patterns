package DesignPatterns.factory;

public class DynamicWindow extends Window {
    @Override
    public Button createButton() {
        return new AutomaticButton();
    }
}
