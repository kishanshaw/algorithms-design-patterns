package DesignPatterns.builder;

import enums.CarType;

public class Director {

    public void constructSportsCar(Builder builder) {
        builder.setCarType(CarType.SPORTS);
        builder.setEngine(new Engine(90, false));
        builder.setSeats(3);
    }

    public void constructSUVCar(Builder builder) {
        builder.setCarType(CarType.SUV);
        builder.setEngine(new Engine(70, false));
        builder.setSeats(4);
    }

    public void constructHatchBackCar(Builder builder) {
        builder.setCarType(CarType.HATCHBACK);
        builder.setEngine(new Engine(68, false));
        builder.setSeats(4);
    }
}
