package DesignPatterns.bookmyshow;

import java.util.ArrayList;
import java.util.List;

public class Theatre {
    private int theatreId;
    private String name;
    private City city;
    private List<Show> shows;
    private List<Screen> screens;
    private String address;

    public Theatre() {
        shows = new ArrayList<>();
        screens = new ArrayList<>();
    }

    public Theatre(int theatreId, String name, City city, List<Show> shows, List<Screen> screens, String address) {
        this.theatreId = theatreId;
        this.name = name;
        this.city = city;
        this.shows = shows;
        this.screens = screens;
        this.address = address;
    }

    public int getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(int theatreId) {
        this.theatreId = theatreId;
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

    public List<Show> getShows() {
        return shows;
    }

    public void setShows(List<Show> shows) {
        this.shows = shows;
    }

    public List<Screen> getScreens() {
        return screens;
    }

    public void setScreens(List<Screen> screens) {
        this.screens = screens;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
