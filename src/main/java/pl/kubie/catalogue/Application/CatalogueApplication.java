package pl.kubie.catalogue.Application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kubie.catalogue.Configuration.WebConfiguration;
import pl.kubie.catalogue.Functions.Comments;
import pl.kubie.catalogue.Functions.MovieService;
import pl.kubie.catalogue.Functions.Rate;
import pl.kubie.catalogue.database.Movie;
import pl.kubie.catalogue.database.MovieDatabase;
import pl.kubie.catalogue.ViewFunctions.View;

import javax.persistence.NoResultException;
import java.util.Scanner;
@SpringBootApplication
@RequestMapping("/home")
public class CatalogueApplication {

    static MovieDatabase movieDatabase = new MovieDatabase();
    static Scanner scanner = new Scanner(System.in);
    static View view = new View(scanner, movieDatabase);
    static UserInput userInput = new UserInput(scanner);

    static MovieService movieService = new MovieService(movieDatabase, view, userInput);



    public static void main(String[] args) {
        SpringApplication.run(CatalogueApplication.class, args);


        do {
            view.showMenu();
           int switchCase =  userInput.getUserNumber();
            switch (switchCase) {
                case View.AD_MOVIE:


                    break;
                case View.SHOW_MOVIES:

                    break;
                case View.ADD_RATE: {
                    view.ShowMovieDatabase(movieDatabase.findAll());
                    int numberChoice = userInput.getUserNumber("Chose movie to change it rating");
                    movieService.addRate(numberChoice);
                }
                break;
                case View.CHANGE_CATEGORY: {
                    view.ShowMovieDatabase(movieDatabase.findAll());
                    int numberChoice = userInput.getUserNumber("Chose movie to change it category");
                    movieService.setCategory(numberChoice);
                }
                break;
                case View.SORT_MOVIES:
                    System.out.println("This function has been deleted");
                    break;
                case View.SEARCH_MOVIE: {
                    movieService.search();
                }

                break;
                case View.DELETE_MOVIE: {
                    view.ShowMovieDatabase(movieDatabase.findAll());
                    int numberChoice = userInput.getUserNumber("Chose movie to change it category");
                    movieService.DeleteMovie(numberChoice);
                }
                break;
                case View.AD_COMMENT: {
                    view.ShowMovieDatabase(movieDatabase.findAll());
                    int numberChoice = userInput.getUserNumber("Chose movie add Commentary");
                    movieService.AddComment(numberChoice);
                }
                break;
                case View.SHOW_COMMENTS: {
                    view.ShowMovieDatabase(movieDatabase.findAll());
                    int numberChoice = userInput.getUserNumber("Chose movie to show comments");
                    movieService.showComments(numberChoice);
                }
                break;
                case View.CLOSE_PROGRAM: {
                    System.exit(0);
                    movieDatabase.close();
                }
            }
        } while (true);

    }


    }








}
