package pl.kubie.catalogue;

import java.util.*;
import java.util.regex.Pattern;

/**
 * Created by Gladus on 02.02.2018.
 */

public class View {
    public static final int AD_MOVIE=1;
    public static final int SHOW_MOVIES=2;
    public static final int CHANGE_RATE=3;
    public static final int CHANGE_CATEGORY=4;
    public static final int SORT_MOVIES=5;
    public static final int SEARCH_MOVIE=6;
    public static final int AD_COMMENTARY=7;
    public static final int DELETE_MOVIE=8;
    public static final int CLOSE_PROGRAM=9;

    private Scanner sc;
    private MovieDatabase movieDatabase = new MovieDatabase();

    public View(Scanner sc, MovieDatabase movieDatabase) {
        this.sc = sc;
        this.movieDatabase = movieDatabase;
    }


    public  void  showMenu(){

        System.out.println("#############################################################");
        System.out.println("#                                                           #");
        System.out.println("#                        ***MENU***                         #");
        System.out.println("#                                                           #");
        System.out.println("#############################################################");
        System.out.println("["+AD_MOVIE+"] Add Movie");
        System.out.println("["+ SHOW_MOVIES+"] Show all  Movies");
        System.out.println("["+CHANGE_RATE+" ]Movie Rate");
        System.out.println("["+CHANGE_CATEGORY +"] Change Movie Category ");
        System.out.println("["+SORT_MOVIES+"] Sort Movies By //niedziała");
        System.out.println("["+SEARCH_MOVIE+"] Search Movies By //niedziała");
        System.out.println("["+AD_COMMENTARY+"] Add Commentary to Movie");
        System.out.println("["+DELETE_MOVIE+"] Delete Movie  ");
        System.out.println("["+CLOSE_PROGRAM+"] Close Program" + "\n");



    }


    public void ShowmovieDatabase(List<Movie> movies) {
        System.out.println("#############################################################");
        System.out.println("#                                                           #");
        System.out.println("#                     *** Movie List***                    #");
        System.out.println("#                                                           #");
        System.out.println("#############################################################");

        Integer iterator = 0;
        for (Movie ExampleMovie : movies) {
            System.out.println("Movie [" + iterator++ + "]: " + ExampleMovie.getTitle());
        }
    }

    public void showMovieInformations(Movie movie) {
        System.out.println("Title: " + movie.getTitle());
        System.out.println("Category : " + movie.getType());
        System.out.println("Actual rating of movie: " ); movie.getRate();
        System.out.println("\n");
    }
    public int getUserNumber() {
        return sc.nextInt();
    }
    public String getUserChoice() {
        return sc.nextLine();
    }
}




