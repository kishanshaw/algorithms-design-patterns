package DesignPatterns.elevator;

import java.util.ArrayList;
import java.util.List;

public class Building {
    List<Floor> floors;

    public Building() {
        floors = new ArrayList<>();
    }

    public Building(List<Floor> floors) {
        this.floors = floors;
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public void setFloors(List<Floor> floors) {
        this.floors = floors;
    }

    public void addFloor(Floor floor) {
        this.floors.add(floor);
    }

    public void removeFloor(Floor floor) {
        this.floors.remove(floor);
    }
}
