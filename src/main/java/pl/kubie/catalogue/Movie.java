package pl.kubie.catalogue;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;
@Entity
public class Movie {
    @Id
    @GeneratedValue
    private int id;
    private String title;
    private String type;
    private LocalDate dateOfAdd;

    @OneToMany(mappedBy = "movieRate")
//    @JoinTable(
//            name="Movie rates",
//            joinColumns= {@JoinColumn( name = "movieRates")},
//            inverseJoinColumns = {@JoinColumn(name = "id")}
//    )
    private List<Rate> rate ;

    @OneToMany(mappedBy = "movieCom")
//    @JoinTable(
//            name="Comments",
//            joinColumns= {@JoinColumn( name = "Id_com")},
//            inverseJoinColumns = {@JoinColumn(name = "movieCom")}
//    )
    private List<Comments> comment ;



    public Movie( String title, String type) {

        this.title = title;
        this.type = type;
        this.dateOfAdd = LocalDate.now();

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

//    public void getComment() {
//        Iterator<String> myListIterator = comment.iterator();
//        while (myListIterator.hasNext()) {
//            String coord = myListIterator.next();
//            System.out.print("\r");
//            System.out.print(coord);
//
//        }
//    }

    public LocalDate getDate() {
        return dateOfAdd;
    }

//    public void getRate() {
//        Iterator<Integer> myListIterator = rate.iterator();
//        while (myListIterator.hasNext()) {
//            Integer coord = myListIterator.next();
//            System.out.print("\r");
//            System.out.print(coord);
//        }
//    }
//
//    public double getAverageRate() {
//        Integer sum = 0;
//        if (!rate.isEmpty()) {
//            for (Integer mark : rate) {
//                sum += mark;
//            }
//            return sum.doubleValue() / rate.size();
//        }
//        return sum;
//    }

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
                ", rate=" + rate +
                ", comment=" + comment +
                '}';
    }

//    public void setComment(String comment) {
//        this.comment.add(comment);
//    }
//
//    public void addRate(Integer rate) {
//        this.rate.add(rate);
//    }

    public void setDateOfAdd(LocalDate dateOfAdd) {
        this.dateOfAdd = dateOfAdd;
    }
}



