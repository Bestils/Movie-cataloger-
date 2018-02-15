package pl.kubie.catalogue;

import java.time.LocalDate;
import java.util.*;

/**
 * Created by Gladus on 02.02.2018.
 */
public class Movie {
    private int id;
    private String title;
    private String type;
    private LocalDate dateOfAdd;
    private List<Integer> rate = new ArrayList<>();
    private List<String> comment = new ArrayList<>();

    public Movie(int id, String title, String type, String comment, Integer rate) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.comment.add(comment);
        this.rate.add(rate);
        this.dateOfAdd = LocalDate.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public void getComment() {
        Iterator<String> myListIterator = comment.iterator();
        while (myListIterator.hasNext()) {
            String coord = myListIterator.next();
            System.out.print("\r");
            System.out.print(coord);

        }
    }

    public LocalDate getDate() {
        return dateOfAdd;
    }

    public void getRate() {
        Iterator<Integer> myListIterator = rate.iterator();
        while (myListIterator.hasNext()) {
            Integer coord = myListIterator.next();
            System.out.print("\r");
            System.out.print(coord);
        }
    }

    public double getAverageRate() {
        Integer sum = 0;
        if (!rate.isEmpty()) {
            for (Integer mark : rate) {
                sum += mark;
            }
            return sum.doubleValue() / rate.size();
        }
        return sum;
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
                ", rate=" + rate +
                ", comment=" + comment +
                '}';
    }
    public void setComment(String comment) {
        this.comment.add(comment);
    }
    public void addRate(Integer rate) {
        this.rate.add(rate);
    }


    public void setDateOfAdd(LocalDate dateOfAdd) {
        this.dateOfAdd = dateOfAdd;
    }

}



