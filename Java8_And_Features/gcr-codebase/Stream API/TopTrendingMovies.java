import java.util.*;
import java.util.stream.Collectors;

class Movie {
    private String title;
    private double rating;
    private int releaseYear;
    
    public Movie(String title, double rating, int releaseYear) {
        this.title = title;
        this.rating = rating;
        this.releaseYear = releaseYear;
    }
    
    public String getTitle() { return title; }
    public double getRating() { return rating; }
    public int getReleaseYear() { return releaseYear; }
    
    @Override
    public String toString() {
        return title + " (" + releaseYear + ") - Rating: " + rating;
    }
}

public class TopTrendingMovies {
    public static void main(String[] args) {
        List<Movie> movies = Arrays.asList(
            new Movie("Avengers: Endgame", 8.4, 2019),
            new Movie("The Dark Knight", 9.0, 2008),
            new Movie("Inception", 8.8, 2010),
            new Movie("Parasite", 8.6, 2019),
            new Movie("Interstellar", 8.6, 2014),
            new Movie("The Godfather", 9.2, 1972),
            new Movie("Pulp Fiction", 8.9, 1994),
            new Movie("Joker", 8.4, 2019),
            new Movie("Spider-Man: No Way Home", 8.2, 2021),
            new Movie("Dune", 8.0, 2021)
        );
        
        System.out.println("Top 5 Trending Movies (Rating >= 8.0, Recent Years):");
        
        movies.stream()
            .filter(movie -> movie.getRating() >= 8.0)
            .filter(movie -> movie.getReleaseYear() >= 2010)
            .sorted(Comparator.comparing(Movie::getRating).reversed()
                .thenComparing(Comparator.comparing(Movie::getReleaseYear).reversed()))
            .limit(5)
            .forEach(System.out::println);
    }
}