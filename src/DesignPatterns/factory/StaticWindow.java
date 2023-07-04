package DesignPatterns.factory;

public class StaticWindow extends Window {
    @Override
    public Button createButton() {
        return new ManualButton();
    }
}
