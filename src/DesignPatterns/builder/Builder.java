package DesignPatterns.builder;

import enums.CarType;

public interface Builder {
    void setCarType(CarType carType);

    void setSeats(int seats);

    void setEngine(Engine engine);
}
