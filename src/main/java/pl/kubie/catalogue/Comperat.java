package pl.kubie.catalogue;

import java.util.Comparator;

/**
 * Created by Gladus on 08.02.2018.
 */

public class Comperat {

    private MovieDatabase movieDatabase = new MovieDatabase();

    public static Comparator<Movie> movieNameComparator  = new Comparator<Movie>() {
        public int compare(Movie movie1, Movie movie2) {
            String movieName1 = movie1.getTitle().toUpperCase();
            String movieName2 = movie2.getTitle().toUpperCase();
            return movieName1.compareTo(movieName2);
        }
    };

    public void sortByTitle() {
        movieDatabase.findall().stream().sorted(Comparator.comparing(Movie::getTitle).reversed()).forEach(System.out::println);
    }

    public void sortByRate() {
        movieDatabase.findall().stream().sorted(Comparator.comparing(Movie::getAverageRate).reversed()).forEach(System.out::println);
    }

    public void sortByDate() {
        movieDatabase.findall().stream().sorted(Comparator.comparing(Movie::getDate).reversed()).forEach(System.out::println);
    }
    public void sortByCategory() {
        movieDatabase.findall().stream().sorted(Comparator.comparing(Movie::getType).reversed()).forEach(System.out::println);
    }
}
