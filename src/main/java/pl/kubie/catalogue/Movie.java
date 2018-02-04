package pl.kubie.catalogue;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Gladus on 02.02.2018.
 */
public class Movie {
    private int id;
    private String title;
    private String type;
    private String comment;
    private Integer rate;

    public Movie(int id, String title, String type, String comment, Integer rate) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.comment = comment;
        this.rate = rate;
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

    public Integer getRate() {
        return rate;
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

    public void setRate(Integer rate) {
        this.rate = rate;
    }
}


