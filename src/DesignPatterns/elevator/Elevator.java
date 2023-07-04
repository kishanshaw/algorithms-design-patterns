package DesignPatterns.elevator;

public class Elevator {
    private int elevatorId;
    private Direction direction;
    private LiftButton elevatorButton;
    private Display display;
    private Status status;
    private int currentFloor;

    public Elevator() {
        display = new Display();
        elevatorButton = new LiftButton();
        status = Status.IDLE;
        currentFloor = 0;
        direction = Direction.UP;
    }

    public int getElevatorId() {
        return elevatorId;
    }

    public void setElevatorId(int elevatorId) {
        this.elevatorId = elevatorId;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public LiftButton getElevatorButton() {
        return elevatorButton;
    }

    public void setElevatorButton(LiftButton elevatorButton) {
        this.elevatorButton = elevatorButton;
    }

    public Display getDisplay() {
        return display;
    }

    public void setDisplay(Display display) {
        this.display = display;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public void showDisplay() {
        display.display();
    }

    public void pressButton(int targetFloor) {
        elevatorButton.pressButton(targetFloor, this);
    }


    public boolean move(int targetFloor, Direction direction) {
        int floor = currentFloor;
        if (direction == Direction.UP) {
            for (int i = floor; i <= targetFloor; i++) {
                this.currentFloor = i;
                this.setDisplay(new Display(this.currentFloor, direction));
                this.showDisplay();
                if (targetFloor == i) {
                    return true;
                }
            }
        } else {
            for (int i = floor; i >= targetFloor; i--) {
                this.currentFloor = i;
                this.setDisplay(new Display(this.currentFloor, direction));
                this.showDisplay();
                if (targetFloor == i) {
                    return true;
                }
            }
        }
        return false;
    }
}
