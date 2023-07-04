package DesignPatterns.bookmyshow;

public class Movie {
    private int movieId;
    private String name;
    private int durationInMin;

    public Movie() {
    }

    public Movie(int id, String name, int durationInMin) {
        this.movieId = id;
        this.name = name;
        this.durationInMin = durationInMin;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDurationInMin() {
        return durationInMin;
    }

    public void setDurationInMin(int durationInMin) {
        this.durationInMin = durationInMin;
    }
}
