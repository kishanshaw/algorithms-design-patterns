package DesignPatterns.bookmyshow;

import java.util.*;

public class TheatreController {
    private Map<City, List<Theatre>> cityVsTheatres;
    private List<Theatre> allTheatres;

    public TheatreController() {
        cityVsTheatres = new HashMap<>();
        allTheatres = new ArrayList<>();
    }

    public TheatreController(Map<City, List<Theatre>> cityVsTheatres, List<Theatre> allTheatres) {
        this.cityVsTheatres = cityVsTheatres;
        this.allTheatres = allTheatres;
    }

    private static void createTheatres(MovieController movieController, TheatreController theatreController) {
        List<Show> shows = new ArrayList<>();
        List<Seat> seats = new ArrayList<>();
        seats.add(new Seat(5, "A7", SeatCategory.GOLD));
        seats.add(new Seat(6, "A8", SeatCategory.GOLD));
        Screen screen = new Screen(1, seats);
        Show s1 = new Show(1, movieController.getMovieByName(City.BENGALURU, "Avatar"), "09:30", Arrays.asList(1, 2), screen);
        shows.add(s1);
        List<Screen> screens = new ArrayList<>();
        screens.add(screen);
        Theatre theatre1 = new Theatre(1, "Inox", City.BENGALURU, shows, screens, "address");
        Theatre theatre2 = new Theatre(2, "PVR", City.BENGALURU, shows, screens, "address");
        theatreController.getAllTheatres().addAll(Arrays.asList(theatre1, theatre2));
        theatreController.getCityVsTheatres().put(City.BENGALURU, Arrays.asList(theatre1, theatre2));

    }

    public Map<City, List<Theatre>> getCityVsTheatres() {
        return cityVsTheatres;
    }

    public void setCityVsTheatres(Map<City, List<Theatre>> cityVsTheatres) {
        this.cityVsTheatres = cityVsTheatres;
    }

    public List<Theatre> getAllTheatres() {
        return allTheatres;
    }

    public void setAllTheatres(List<Theatre> allTheatres) {
        this.allTheatres = allTheatres;
    }

    public void addMovie(City city, Theatre theatre) {
        List<Theatre> theatres = cityVsTheatres.getOrDefault(city, new ArrayList<>());
        theatres.add(theatre);
        cityVsTheatres.put(city, theatres);
    }

    public Theatre getTheatreByName(City city, String name) {
        for (Theatre theatre : allTheatres) {
            if (theatre.getName().equalsIgnoreCase(name) && city.name().equals(theatre.getCity().name())) {
                return theatre;
            }
        }
        return null;
    }

    public Show getShowById(Theatre theatre, int showId) {
        Theatre bookedTheatre = getTheatreByName(City.BENGALURU, theatre.getName());
        for (Show show : bookedTheatre.getShows()) {
            if (show.getShowId() == showId) {
                return show;
            }
        }
        return null;
    }
}
