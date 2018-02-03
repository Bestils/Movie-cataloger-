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


    Film(){


    }

    void SetMovieType(String Type){

        this.type=type;
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

}


