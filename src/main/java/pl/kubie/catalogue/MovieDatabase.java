package pl.kubie.catalogue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class MovieDatabase {
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("filmoteka");
    private static EntityManager entityManager = entityManagerFactory.createEntityManager();

    private List<Movie> movies = new ArrayList<>();

    public void save(Movie movie) {
        entityManager.getTransaction().begin();
        entityManager.persist(movie);
        entityManager.getTransaction().commit();
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
    public List<Movie> findByAverageRate(int rate1, int rate2) {
        return movies.stream()
                .filter(f -> (f.getAverageRate() <= rate2) && (f.getAverageRate() >= rate1))
                .collect(Collectors.toList());
    }
    public Movie findByDate(LocalDate date) {
        return movies.stream()
                .filter(f -> f.getDate().equals(date))
                .findAny()
                .orElseThrow(NoSuchElementException::new);
    }
    public List<Movie> findAllSortByTitle() {
        return movies.stream().sorted(Comparator.comparing(Movie::getTitle).reversed()).collect(Collectors.toList());
    }

    public List<Movie> findAllSortByRate() {
        return movies.stream().sorted(Comparator.comparing(Movie::getAverageRate).reversed()).collect(Collectors.toList());
    }
    public List<Movie> findAllSortByDate() {
        return movies.stream().sorted(Comparator.comparing(Movie::getDate).reversed()).collect(Collectors.toList());
    }
    public List<Movie> findAllSortByCategory() {
        return movies.stream().sorted(Comparator.comparing(Movie::getType).reversed()).collect(Collectors.toList());
    }
}


