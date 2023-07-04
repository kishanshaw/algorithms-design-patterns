package DesignPatterns.elevator;

import java.util.ArrayList;
import java.util.List;

public class ExternalDispatcher {

    private List<ElevatorController> elevatorControllerList;

    public ExternalDispatcher() {
        elevatorControllerList = new ArrayList<>();
    }

    public ExternalDispatcher(List<ElevatorController> elevatorControllerList) {
        this.elevatorControllerList = elevatorControllerList;
    }


    public List<ElevatorController> getElevatorControllerList() {
        return elevatorControllerList;
    }

    public void setElevatorControllerList(List<ElevatorController> elevatorControllerList) {
        this.elevatorControllerList = elevatorControllerList;
    }

    public void submitRequest(int targetFloor, Direction direction) {
        for (ElevatorController elevatorController : elevatorControllerList) {
            int elevatorID = elevatorController.getElevator().getElevatorId();
            if (elevatorID % 2 == 1 && targetFloor % 2 == 1) {
                elevatorController.submitExternalRequest(targetFloor, direction);
            } else if (elevatorID % 2 == 0 && targetFloor % 2 == 0) {
                elevatorController.submitExternalRequest(targetFloor, direction);
            }
        }

    }
}
