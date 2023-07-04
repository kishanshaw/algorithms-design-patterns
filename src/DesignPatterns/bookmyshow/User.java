package DesignPatterns.bookmyshow;

public class User {
    private int userId;
    private String name;
    private City city;

    public User() {
    }

    public User(int userId, String name, City city) {
        this.userId = userId;
        this.name = name;
        this.city = city;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
