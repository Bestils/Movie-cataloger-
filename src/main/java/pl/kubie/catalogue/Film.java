package pl.kubie.catalogue;

/**
 * Created by Gladus on 02.02.2018.
 */
public class Film {


    // TODO: 02.02.2018

    // Zmienić oceny na rate
    //Dodać klase enum  z typami filmów



private String title,type;
private Integer rate;


    Film(String title, Integer rate, String type){
this.rate=rate;
this.title=title;
this.type=type;

    }

    void setType(String Type){

        this.type=type;
    }
    void setmovietitle(String title){

        this.title=title;
    }
}
