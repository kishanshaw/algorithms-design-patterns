package DesignPatterns.bookmyshow;

import java.util.List;

public class BookMyShow {
    private TheatreController theatreController;
    private MovieController movieController;

    public BookMyShow() {
        theatreController = new TheatreController();
        movieController = new MovieController();
    }

    public BookMyShow(TheatreController theatreController, MovieController movieController) {
        this.theatreController = theatreController;
        this.movieController = movieController;
    }

    public TheatreController getTheatreController() {
        return theatreController;
    }

    public void setTheatreController(TheatreController theatreController) {
        this.theatreController = theatreController;
    }

    public MovieController getMovieController() {
        return movieController;
    }

    public void setMovieController(MovieController movieController) {
        this.movieController = movieController;
    }

    public Booking createBooking(User user, Show show, List<Seat> seats, City city) throws Exception {
        Movie bookedMovie = show.getMovie();
        boolean isMovieAvailable = false;
        List<Movie> availableMovies = movieController.getMovieByCity(city);
        for (Movie movie : availableMovies) {
            if (movie.getName().equalsIgnoreCase(bookedMovie.getName())) {
                isMovieAvailable = true;
                break;
            }
        }
        if (!isMovieAvailable) {
            throw new Exception("Movie is not available in the city: " + city.name());
        }
        return new Booking(user, show, seats, new Payment(1, true));
    }
}
