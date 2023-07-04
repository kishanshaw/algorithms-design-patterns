package DesignPatterns.elevator;

public class Display {
    private int floor;
    private Direction direction;

    public Display() {
    }

    public Display(int floor, Direction direction) {
        this.floor = floor;
        this.direction = direction;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void display() {
        System.out.println(this.floor + " " + direction.name());
    }
}
