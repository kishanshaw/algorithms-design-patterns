package DesignPatterns.bookmyshow;

import java.util.ArrayList;
import java.util.List;

public class Show {
    List<Integer> bookedSeatIds;
    private int showId;
    private Movie movie;
    private String showStartsAt;
    private Screen screen;

    public Show() {
        movie = new Movie();
        bookedSeatIds = new ArrayList<>();
        screen = new Screen();
        showStartsAt = "00:00";
    }

    public Show(int showId, Movie movie, String showStartsAt, List<Integer> bookedSeatIds, Screen screen) {
        this.showId = showId;
        this.movie = movie;
        this.showStartsAt = showStartsAt;
        this.bookedSeatIds = bookedSeatIds;
        this.screen = screen;
    }

    public List<Integer> getBookedSeatIds() {
        return bookedSeatIds;
    }

    public void setBookedSeatIds(List<Integer> bookedSeatIds) {
        this.bookedSeatIds = bookedSeatIds;
    }

    public int getShowId() {
        return showId;
    }

    public void setShowId(int showId) {
        this.showId = showId;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public String getShowStartsAt() {
        return showStartsAt;
    }

    public void setShowStartsAt(String showStartsAt) {
        this.showStartsAt = showStartsAt;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }
}
