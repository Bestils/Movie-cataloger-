package pl.kubie.catalogue;

import java.util.*;

/**
 * Created by Gladus on 02.02.2018.
 */
public class Movie {
    private int id;
    private String title;
    private String type;
    private String comment;
  private List<Integer> rate = new ArrayList<>();

    public Movie(int id, String title, String type, String comment, Integer rate) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.comment = comment;
        this.rate.add(rate);
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

    public String getComment() {
        return comment;
    }

    public void getRate() {
        Iterator<Integer> myListIterator = rate.iterator();
        while (myListIterator.hasNext()) {
            Integer coord = myListIterator.next();
            System.out.print("\r");
            System.out.print(coord);
        }
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void addRate(Integer rate) {
        this.rate.add(rate);
    }
}


