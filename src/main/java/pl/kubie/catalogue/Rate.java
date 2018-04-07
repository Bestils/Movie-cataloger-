package pl.kubie.catalogue;

import javax.persistence.*;

@Entity
public class Rate {
    @Id
    @GeneratedValue
    private long id;

    private Integer rate;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "movie_id")
    private Movie movieRate;

    public Rate(){}
    public Rate(Integer rate, Movie movie) {
        this.rate = rate;
        this.movieRate = movie;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public Movie getMovie() {
        return movieRate;
    }

    public void setMovie(Movie movie) {
        this.movieRate = movie;
    }
}
