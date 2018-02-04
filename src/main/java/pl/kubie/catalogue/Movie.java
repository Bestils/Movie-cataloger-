package pl.kubie.catalogue;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Gladus on 02.02.2018.
 */
public class Movie {


    // TODO: 02.02.2018


// Dodać komentarze
    // Zrobić funkcje sortującą



    private String title,type,comment;



    private Integer rate;


    Movie(){



    }

    void SetMovieType(String Type){

        this.type=Type;
    }
    void SetMovieTitle(String title){

        this.title=title;
    }
    void SetMovieRate( Integer rate){

        this.rate=rate;
    }
    void SetMovieComment( String Comment){

        this.comment=comment;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public Integer getRate() {
        return rate;
    }

    public String GetComment() {
        return comment;
    }




}


