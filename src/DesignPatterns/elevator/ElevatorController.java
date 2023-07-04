package DesignPatterns.elevator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class ElevatorController {
    private Elevator elevator;
    private PriorityQueue<Integer> minPQ;
    private PriorityQueue<Integer> maxPQ;
    private List<Integer> pendingJobs;

    public ElevatorController() {
        elevator = new Elevator();
        minPQ = new PriorityQueue<>();
        maxPQ = new PriorityQueue<>(Collections.reverseOrder());
        pendingJobs = new ArrayList<>();
    }

    public ElevatorController(Elevator elevator) {
        this.elevator = elevator;
    }

    public Elevator getElevator() {
        return elevator;
    }

    public void setElevator(Elevator elevator) {
        this.elevator = elevator;
    }

    public PriorityQueue<Integer> getMinPQ() {
        return minPQ;
    }

    public void setMinPQ(PriorityQueue<Integer> minPQ) {
        this.minPQ = minPQ;
    }

    public PriorityQueue<Integer> getMaxPQ() {
        return maxPQ;
    }

    public void setMaxPQ(PriorityQueue<Integer> maxPQ) {
        this.maxPQ = maxPQ;
    }

    public List<Integer> getPendingJobs() {
        return pendingJobs;
    }

    public void setPendingJobs(List<Integer> pendingJobs) {
        this.pendingJobs = pendingJobs;
    }

    public void submitExternalRequest(int targetFloor, Direction direction) {
        if (direction == Direction.UP) {
            minPQ.add(targetFloor);
        } else {
            maxPQ.add(targetFloor);
        }
    }

    public void submitInternalRequest(int targetFloor) {

    }

    public void controlElevator() {

    }
}
