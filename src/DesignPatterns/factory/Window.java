package DesignPatterns.factory;

public abstract class Window {
    public void renderButton() {
        Button button = createButton();
        button.render();
    }

    public abstract Button createButton();
}
