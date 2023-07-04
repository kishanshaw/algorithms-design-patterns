package DesignPatterns.builder;

import enums.CarType;

public class Car {
    private int seats;
    private Engine engine;
    private CarType carType;

    public Car(int seats, Engine engine, CarType carType) {
        this.seats = seats;
        this.engine = engine;
        this.carType = carType;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    @Override
    public String toString() {
        return "Car{" +
                "seats=" + seats +
                ", engine=" + engine +
                ", carType=" + carType +
                '}';
    }
}
