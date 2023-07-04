package DesignPatterns.bookmyshow;

import java.util.*;

public class MovieController {
    Map<City, List<Movie>> cityVsMovies;
    List<Movie> allMovies;

    public MovieController() {
        cityVsMovies = new HashMap<>();
        allMovies = new ArrayList<>();
    }

    public MovieController(Map<City, List<Movie>> cityVsMovies, List<Movie> allMovies) {
        this.cityVsMovies = cityVsMovies;
        this.allMovies = allMovies;
    }

    public Map<City, List<Movie>> getCityVsMovies() {
        return cityVsMovies;
    }

    public void setCityVsMovies(Map<City, List<Movie>> cityVsMovies) {
        this.cityVsMovies = cityVsMovies;
    }

    public List<Movie> getAllMovies() {
        return allMovies;
    }

    public void setAllMovies(List<Movie> allMovies) {
        this.allMovies = allMovies;
    }

    public List<Movie> getMovieByCity(City city) {
        return cityVsMovies.get(city);
    }

    public void addMovie(City city, Movie movie) {
        List<Movie> movies = cityVsMovies.getOrDefault(city, new ArrayList<>());
        movies.add(movie);
        cityVsMovies.put(city, movies);
    }

    public Movie getMovieByName(City city, String name) {
        for (Movie movie : allMovies) {
            if (movie.getName().equalsIgnoreCase(name)) {
                return movie;
            }
        }
        return null;
    }

    private void createMovies() {
        Movie movie1 = new Movie(1, "Avatar", 210);
        Movie movie2 = new Movie(1, "Avengers", 150);
        this.cityVsMovies.put(City.BENGALURU, new ArrayList<>(Arrays.asList(movie1, movie2)));
        cityVsMovies.put(City.DELHI, new ArrayList<>(Collections.singletonList(movie2)));
        cityVsMovies.put(City.CHENNAI, new ArrayList<>(Collections.singletonList(movie2)));
        cityVsMovies.put(City.KOLKATA, new ArrayList<>(Collections.singletonList(movie2)));
        this.allMovies.addAll(Arrays.asList(movie1, movie2));
    }
}
