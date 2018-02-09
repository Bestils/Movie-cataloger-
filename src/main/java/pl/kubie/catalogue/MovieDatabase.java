package pl.kubie.catalogue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Gladus on 04.02.2018.
 */
public class MovieDatabase {

    private List<Movie> movies = new ArrayList<>();

    public void save(Movie movie) {

        movies.add(movie);
    }

    public List<Movie> findall() {
        return movies;

    }

    public void remove(Integer index) {

        movies.remove(index);
    }

    public Movie findById(int id) {
        return movies.stream()
                .filter(f -> f.getId() == id)
                .findAny()
                .orElseThrow(NoSuchElementException::new);

    }

    public Movie findByTitle(String title) {
        return movies.stream()
                .filter(f -> f.getTitle().equals(title))
                .findAny()
                .orElseThrow(NoSuchElementException::new);

    }

    public Movie findByType(String type) {
        return movies.stream()
                .filter(f -> f.getTitle().equals(type))
                .findAny()
                .orElseThrow(NoSuchElementException::new);

    }

    public Movie findByAverageRate(int rate1, int rate2) {
        return movies.stream()
                .filter(f -> (f.getAverageRate() <= rate2) && (f.getAverageRate() >= rate1))
                .findAny()
                .orElseThrow(NoSuchElementException::new);

    }

    public Movie findByDate(LocalDate date) {
        return movies.stream()
                .filter(f -> f.getDate().equals(date))
                .findAny()
                .orElseThrow(NoSuchElementException::new);

    }



    public List<Movie> findAllSortByTitle() {

       return  movies.stream().sorted(Comparator.comparing(Movie::getTitle).reversed()).collect(Collectors.toList());
    }

    public List<Movie>  findAllSortByRate() {
        return movies.stream().sorted(Comparator.comparing(Movie::getAverageRate).reversed()).collect(Collectors.toList());
    }

    public List<Movie>  findAllSortByDate() {
        return  movies.stream().sorted(Comparator.comparing(Movie::getDate).reversed()).collect(Collectors.toList());
    }
    public List<Movie>  findAllSortByCategory() {
        return movies.stream().sorted(Comparator.comparing(Movie::getType).reversed()).collect(Collectors.toList());
    }


}


