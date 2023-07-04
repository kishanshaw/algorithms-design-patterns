package DesignPatterns.CarRentals;

public class Vehicle {
    private String vehicleNumber;
    private int vehicleId;
    private VehicleType vehicleType;
    private Status status;

    public Vehicle(String vehicleNumber, int vehicleId, VehicleType vehicleType, Status status) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleId = vehicleId;
        this.vehicleType = vehicleType;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleNumber='" + vehicleNumber + '\'' +
                ", vehicleId=" + vehicleId +
                ", vehicleType=" + vehicleType +
                ", status=" + status +
                '}';
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
