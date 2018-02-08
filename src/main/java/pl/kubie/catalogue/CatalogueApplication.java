package pl.kubie.catalogue;

import java.util.Scanner;


public class CatalogueApplication {

    static MovieDatabase movieDatabase = new MovieDatabase();
    static Scanner NumberScanner = new Scanner(System.in);
    static View view = new View(NumberScanner, movieDatabase);
    static MovieService movieService = new MovieService(movieDatabase);
    static Comperat comperator = new Comperat();

    public static void main(String[] args) {


        int choice;
        do {
            view.showMenu();

            switch (view.getUserNumber()) {
                case View.AD_MOVIE:
                    CreateNewMovie();
                    break;
                case View.SHOW_MOVIES:
                    showAllMovies();
                    break;
                case View.CHANGE_RATE: {
                    showAllMovies();
                    System.out.println("Chose movie to change it rating");
                    movieService.setRate(view.getUserNumber());
                }
                case View.CHANGE_CATEGORY: {
                    movieDatabase.findall();
                    System.out.println("Chose movie to change it category");
                    movieService.setCategory(view.getUserNumber());
                }
                break;
                case View.SORT_MOVIES:
                    showSortMenu();


                    break;
                case View.SEARCH_MOVIE: {

                }
                break;
                case View.AD_COMMENTARY: {
                    movieDatabase.findall();
                    System.out.println("Chose movie add Commentary");
                    System.exit(0);
                }
            }

        } while (true);
    }

    private static void showAllMovies() {
        boolean poprawny;

        if (movieDatabase.findall().size() > 0) {
            view.ShowmovieDatabase(movieDatabase.findall());
            System.out.println("Chose number of movie whose you want and push ENTER");
            Integer movieNumber;
            do {
                movieNumber = NumberScanner.nextInt();
                if (movieNumber >= 0 && movieNumber < movieDatabase.findall().size()) {
                    poprawny = true;
                    view.showMovieInformations(movieDatabase.findById(view.getUserNumber()));
                } else {
                    System.out.println("Bad  Movie number! Please give correct number");
                    poprawny = false;
                }
            }
            while (!poprawny);
        }
    }

    private static void showSortMenu() {
        System.out.println("#############################################################");
        System.out.println("#                                                           #");
        System.out.println("#                 ***Sort movie by:***                      #");
        System.out.println("#                                                           #");
        System.out.println("#############################################################");
        System.out.println("[1] Title");
        System.out.println("[2] Category");
        System.out.println("[3] Rating");
        System.out.println("[4] Date");
        int numberChoice = view.getUserNumber();
        if (numberChoice == 1)
            movieDatabase.findAllSortByTitle();
        else if (numberChoice == 2)
            movieDatabase.findAllSortByCategory();
        else if (numberChoice == 3)
            movieDatabase.findAllSortByRate();
        else if (numberChoice == 4)
             movieDatabase.findAllSortByDate();
        else {
            System.out.println("Wrong number !");
        }
    }

    private static void CreateNewMovie() {

        view.getUserChoice();
        int id = movieDatabase.findall().size();
        System.out.println("Please, enter movie Title: ");
        String title = view.getUserChoice();
        System.out.println("Please add comment to movie ");
        String comment = view.getUserChoice();
        Integer rate = movieService.returnRate();
        System.out.println("Please choose category of  this movie");
        movieService.showCategories();
        String category = movieService.returnCategory();
        Movie movie = new Movie(id, title, category, comment, rate);
        movieDatabase.save(movie);

    }
}