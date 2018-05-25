package pl.kubie.catalogue.database;

import pl.kubie.catalogue.Functions.Comments;
import pl.kubie.catalogue.Functions.Rate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

public class MovieDatabase {
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("filmoteka");
    private static EntityManager entityManager = entityManagerFactory.createEntityManager();


    public void save(Movie movie) {

        entityManager.getTransaction().begin();
        entityManager.persist(movie);
        entityManager.getTransaction().commit();

    }

    public void saveRate(Rate rate) {

        entityManager.getTransaction().begin();
        entityManager.persist(rate);
        entityManager.getTransaction().commit();

    }

    public void saveComment(Comments comment) {

        entityManager.getTransaction().begin();
        entityManager.persist(comment);
        entityManager.getTransaction().commit();

    }

    public void close() {
        entityManager.close();
        entityManagerFactory.close();
    }


    public void remove(Movie movie) {

        entityManager.getTransaction().begin();
        entityManager.remove(movie);
        entityManager.getTransaction().commit();
    }

    public List<Movie> findAll() {
        TypedQuery<Movie> querry = entityManager.createQuery("select m from Movie m", Movie.class);
        List<Movie> movies = querry.getResultList();
        return movies;
    }

    public Movie findById(long id) {
        TypedQuery<Movie> querry = entityManager.createQuery("select m from Movie m where  m.id=?1", Movie.class);
        querry.setParameter(1, id);

        return querry.getSingleResult();
    }

    public List<Movie> findByTitle(String title) {
        TypedQuery<Movie> querry = entityManager.createQuery("select m from Movie m where  m.title = ?1", Movie.class);
        querry.setParameter(1, title);
        List<Movie> movies = querry.getResultList();
        return movies;
    }

    public List<Movie> findByType(String type) {
        TypedQuery<Movie> querry = entityManager.createQuery("select m from Movie m where  m.type=?1", Movie.class);
        querry.setParameter(1, type);
        List<Movie> movies = querry.getResultList();
        return movies;
    }

    public List<Movie> findByAverageRate(Integer rate1, Integer rate2) {
        TypedQuery<Movie> querry = entityManager.createQuery("select m from Movie m where  m.rate between ?1 and ?2", Movie.class);
        querry.setParameter(1, rate1);
        querry.setParameter(2, rate2);
        List<Movie> movies = querry.getResultList();
        return movies;
    }

    public List<Movie> findByDate(LocalDate date) {
        TypedQuery<Movie> querry = entityManager.createQuery("select m from Movie m where  m.dateOffAdd =?1", Movie.class);
        querry.setParameter(1, date);
        List<Movie> movies = querry.getResultList();
        return movies;
    }


}



