package DesignPatterns.CarRentals;

public class User {
    private int userId;
    private String drivingLicence;

    public User(int userId, String drivingLicence) {
        this.userId = userId;
        this.drivingLicence = drivingLicence;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", drivingLicence='" + drivingLicence + '\'' +
                '}';
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getDrivingLicence() {
        return drivingLicence;
    }

    public void setDrivingLicence(String drivingLicence) {
        this.drivingLicence = drivingLicence;
    }
}
