package DesignPatterns.builder;

public class Engine {
    private double mileage;
    private boolean started;

    public Engine(double mileage, boolean started) {
        this.mileage = mileage;
        this.started = started;
    }

    public void on() {
        started = true;
    }

    public void off() {
        started = false;
    }

    public void addMileage(double mileage) {
        if (started) {
            this.mileage = this.mileage + mileage;
        } else {
            System.out.println("Can't add mileage as engine not started");
        }
    }

    @Override
    public String toString() {
        return "Engine{" +
                "mileage=" + mileage +
                ", started=" + started +
                '}';
    }
}
