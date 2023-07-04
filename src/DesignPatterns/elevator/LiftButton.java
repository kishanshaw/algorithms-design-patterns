package DesignPatterns.elevator;

public class LiftButton {
    private InternalDispatcher internalDispatcher;

    public LiftButton() {
    }

    public LiftButton(int liftId, InternalDispatcher internalDispatcher) {
        this.internalDispatcher = internalDispatcher;
    }


    public InternalDispatcher getInternalDispatcher() {
        return internalDispatcher;
    }

    public void setInternalDispatcher(InternalDispatcher internalDispatcher) {
        this.internalDispatcher = internalDispatcher;
    }

    public void pressButton(int targetFloor, Elevator elevator) {
        internalDispatcher.submitRequest(targetFloor, elevator);
    }
}
