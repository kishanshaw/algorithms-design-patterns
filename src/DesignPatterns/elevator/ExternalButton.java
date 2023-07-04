package DesignPatterns.elevator;

public class ExternalButton {
    private ExternalDispatcher externalDispatcher;

    public ExternalButton(int liftId, ExternalDispatcher externalDispatcher) {
        this.externalDispatcher = externalDispatcher;
    }


    public ExternalDispatcher getExternalDispatcher() {
        return externalDispatcher;
    }

    public void setExternalDispatcher(ExternalDispatcher externalDispatcher) {
        this.externalDispatcher = externalDispatcher;
    }

    public void pressButton(int targetFloor, Direction direction) {
        externalDispatcher.submitRequest(targetFloor, direction);
    }
}
