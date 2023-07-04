package DesignPatterns.elevator;

import java.util.ArrayList;
import java.util.List;

public class InternalDispatcher {
    private List<ElevatorController> elevatorControllerList;
    private int liftId;

    public InternalDispatcher() {
        elevatorControllerList = new ArrayList<>();
    }

    public InternalDispatcher(List<ElevatorController> elevatorControllerList, int liftId) {
        this.elevatorControllerList = elevatorControllerList;
        this.liftId = liftId;
    }

    public int getLiftId() {
        return liftId;
    }

    public void setLiftId(int liftId) {
        this.liftId = liftId;
    }

    public List<ElevatorController> getElevatorControllerList() {
        return elevatorControllerList;
    }

    public void setElevatorControllerList(List<ElevatorController> elevatorControllerList) {
        this.elevatorControllerList = elevatorControllerList;
    }

    public void submitRequest(int targetFloor, Elevator elevator) {
        int liftId = elevator.getElevatorId();
        for (ElevatorController elevatorController : elevatorControllerList) {
            if (elevatorController.getElevator().getElevatorId() == liftId) {
                elevatorController.submitInternalRequest(targetFloor);
            }
        }
    }
}
