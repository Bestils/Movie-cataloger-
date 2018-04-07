package pl.kubie.catalogue;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

@Entity
public class Movie {
    @Id
    @GeneratedValue
    private long id;
    private String title;
    private String type;
    private LocalDate dateOfAdd;

    @OneToMany(mappedBy = "movieRate" ,fetch = FetchType.LAZY, cascade = CascadeType.ALL)

    private List<Rate> rate;



    @OneToMany(mappedBy = "movieCom" , fetch = FetchType.LAZY, cascade = CascadeType.ALL)

    private List<Comments> comment;

    public Movie() {
    }

    public Movie(String title, String type) {

        this.title = title;
        this.type = type;
        this.dateOfAdd = LocalDate.now();

    }
    public LocalDate getDateOfAdd() {
        return dateOfAdd;
    }

    public List<Rate> getRate() {
        return rate;
    }

    public List<Comments> getComment() {
        return comment;
    }


    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }



    public LocalDate getDate() {
        return dateOfAdd;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", dateOfAdd=" + dateOfAdd +
                '}';
    }

    public void setDateOfAdd(LocalDate dateOfAdd) {
        this.dateOfAdd = dateOfAdd;
    }
}



