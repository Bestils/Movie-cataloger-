package pl.kubie.Services;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.kubie.catalogue.Application.UserInput;
import pl.kubie.catalogue.ViewFunctions.View;
import pl.kubie.catalogue.database.MovieDatabase;

import javax.persistence.NoResultException;

/**
 * Created by Gladus on 28.05.2018.
 */
public class Services {
   static View view;
   static UserInput userInput;
   @RequestMapping(value =  "/{id}", method = RequestMethod.GET)
    private static void showCertainMovie(MovieDatabase movieDatabase) {

       System.out.println("Chose number of movie whose you want and push ENTER");
       Integer movieNumber;
       boolean poprawny = true;
       do {
           try {
               view.showMovieInformations(movieDatabase.findById(userInput.getUserNumber()));
               poprawny = false;
           } catch (NoResultException e) {
               poprawny = true;
               System.out.println("Podano błędne id filmu");
               view.ShowMovieDatabase(movieDatabase.findAll());
           }
       } while (poprawny);

   }
public static void movieSearch(MovieDatabase movieDatabase){
        showMovies(movieDatabase);
    showCertainMovie(movieDatabase);



        }

    public static void showMovies(MovieDatabase movieDatabase){

        if (movieDatabase.findAll().size() > 0) {
            view.ShowMovieDatabase(movieDatabase.findAll());}

    }



}
