package DesignPatterns.elevator;

public class Floor {

    private int floorId;
    private ExternalButton liftButton;

    public Floor() {
    }

    public Floor(int floorId, ExternalButton liftButton) {
        this.floorId = floorId;
        this.liftButton = liftButton;
    }

    public int getFloorId() {
        return floorId;
    }

    public void setFloorId(int floorId) {
        this.floorId = floorId;
    }

    public ExternalButton getLiftButton() {
        return liftButton;
    }

    public void setLiftButton(ExternalButton liftButton) {
        this.liftButton = liftButton;
    }
}
