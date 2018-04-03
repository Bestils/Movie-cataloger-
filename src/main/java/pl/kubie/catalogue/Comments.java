package pl.kubie.catalogue;

import javax.persistence.*;


@Entity
public class Comments {
    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movieCom;
    private String comment;

    public Comments(String comment, Movie movie) {
        this.comment = comment;
        this.movieCom = movie;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Movie getMovieCom() {
        return movieCom;
    }

    public void setMovieCom(Movie movieCom) {
        this.movieCom = movieCom;
    }


}
