package pl.kubie.catalogue;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class MovieDatabase {
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("filmoteka");
    private static EntityManager entityManager = entityManagerFactory.createEntityManager();


    public void save(Movie movie, Comments comment, Rate rate) {


        entityManager.getTransaction().begin();
        entityManager.persist(comment);
        entityManager.persist(rate);
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

    public  void findAll(){
        TypedQuery<Movie> querry = entityManager.createQuery("select m from Movie m, Rate r,Comments c  where c.movie_id=r.movie_id and c.movie_id=m.movie_id",Movie.class) ;

    }

    public Movie findById(int id) {
      TypedQuery<Movie> querry = entityManager.createQuery("select title ,avg(rate.rate) from rate ,movie where rate.movie_id=movie.id  and id =" + id,Movie.class);

    }

    public Movie findByTitle(String title) {
        TypedQuery<Movie> querry = entityManager.createQuery("select m from Movie m, Rate r,Comments c  where c.movie_id=r.movie_id and c.movie_id=m.movie_id and m.title="+title,Movie.class) ;

    }

    public Movie findByType(String type) {
        TypedQuery<Movie> querry = entityManager.createQuery("select m from Movie m, Rate r,Comments c  where c.movie_id=r.movie_id and c.movie_id=m.movie_id and m.type="+type,Movie.class) ;
    }

    public List<Movie> findByAverageRate(Integer rate1, Integer rate2) {
        TypedQuery<Movie> querry = entityManager.createQuery("select m from Movie m, Rate r,Comments c  where c.movie_id=r.movie_id and c.movie_id=m.movie_id and  r.rate between "+rate1 +"and "+rate2,Movie.class) ;

    }

    public Movie findByDate(LocalDate date) {
        TypeQuery<> querry = entityManager.createQuery("select title ,avg(rate.rate) from rate ,movie, comment where rate.movie_id=movie.id " +
                "and comments.movie.id=movie.id  and dateOfAdd=" + date);
    }

    public List<Movie> findAllSortByTitle() {
        TypeQuery<> querry = entityManager.createQuery("select title ,avg(rate.rate) from rate ,movie, comment where rate.movie_id=movie.id " +
                "and comments.movie.id=movie.id Order by  title");

    }

    public List<Movie> findAllSortByRate() {
        TypeQuery<> querry = entityManager.createQuery("select title ,avg(rate.rate) from rate ,movie, comment where rate.movie_id=movie.id " +
                "and comments.movie.id=movie.id Order by  rate");
    }

    public List<Movie> findAllSortByDate() {
        TypeQuery<> querry = entityManager.createQuery("select title ,avg(rate.rate) from rate ,movie, comment where rate.movie_id=movie.id " +
                "and comments.movie.id=movie.id Order by  dateOfAdd");
    }

    public List<Movie> findAllSortByCategory() {
        TypeQuery<> querry = entityManager.createQuery("select title ,avg(rate.rate) from rate ,movie, comment where rate.movie_id=movie.id " +
                "and comments.movie.id=movie.id Order by  movie.type");
    }

    public List<Movie> findAllSortByCategory() {
        TypedQuery<Comments> querry = entityManager.createQuery("select title ,avg(rate.rate) from rate ,movie, comment where rate.movie_id=movie.id " +
                "and comments.movie.id=movie.id Order by  movie.type");
        List<Comments> comments = querry.getResultList();
    }

}



