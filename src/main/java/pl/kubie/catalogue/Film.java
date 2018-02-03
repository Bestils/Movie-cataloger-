package pl.kubie.catalogue;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Gladus on 02.02.2018.
 */
public class Film {


    // TODO: 02.02.2018

    // Zmienić oceny na rate
    //Dodać klase enum  z typami filmów



private String title,type;



    private Integer rate;


    Film(){


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

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public Integer getRate() {
        return rate;
    }

    Map<Integer, String> GatunkiFilmowe = new HashMap<>();


    GatunkiFilmowe.put(1,"Dramat");
    GatunkiFilmowe.put(2,"Komedia");
    GatunkiFilmowe.put(3,"Romans");
    GatunkiFilmowe.put(4,"Akcji");
    GatunkiFilmowe.put(5,"Thriler");
    GatunkiFilmowe.put(6,"Dokumentalny");
    GatunkiFilmowe.put(7,"Fantasy");
    GatunkiFilmowe.put(8,"Kriminał");
    GatunkiFilmowe.put(9,"Psychologiczny");
    GatunkiFilmowe.put(10,"Przygodowy");
    GatunkiFilmowe.put(11,"Rodzinny");


}


