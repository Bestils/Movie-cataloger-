package pl.kubie.catalogue;

import java.util.Arrays;
import java.util.Scanner;


public class CatalogueApplication {

    static MovieDatabase movieDatabase = new MovieDatabase();
    static Scanner NumberScanner = new Scanner(System.in);
    static View view = new View(NumberScanner, movieDatabase);
    static MovieService movieService = new MovieService(movieDatabase);
    static Searcher searcher = new Searcher(movieDatabase);

    public static void main(String[] args) {
        insertSampleData();

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
                    int numberChoice = view.getUserNumber("Chose movie to change it rating");
                    movieService.setRate(numberChoice);
                }break;
                case View.CHANGE_CATEGORY: {
                    showAllMovies();
                    int numberChoice =view.getUserNumber("Chose movie to change it category");
                    movieService.setCategory(  numberChoice );
                }
                break;
                case View.SORT_MOVIES:
                    showSortMenu();

                    break;
                case View.SEARCH_MOVIE: {
                    searcher.search();
                }

                break;  case View.DELETE_MOVIE: {
                    showAllMovies();
                    int numberChoice = view.getUserNumber("Chose movie to change it category");
                    movieService.DeleteMovie(numberChoice);
                }
                break;
                case View.AD_COMMENTARY: {
                    showAllMovies();
                    int numberChoice = view.getUserNumber("Chose movie add Commentary");
                    movieService.AddComment( numberChoice );
                }  break;
                case View.CLOSE_PROGRAM: {
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
                    view.showMovieInformations(movieDatabase.findById(movieNumber));
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
            view.ShowmovieDatabase(movieDatabase.findAllSortByTitle());
        else if (numberChoice == 2)
            view.ShowmovieDatabase(movieDatabase.findAllSortByCategory());
        else if (numberChoice == 3)
            view.ShowmovieDatabase(movieDatabase.findAllSortByRate());
        else if (numberChoice == 4)
            view.ShowmovieDatabase(movieDatabase.findAllSortByDate());
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
   static private void insertSampleData() {
        Arrays.asList(
                 new Movie(1, "Interstellar", "Sci-Fi", "Best Movie Ever!", 10),
                new Movie(2, "Incepcja", "Sci-Fi", "When dreams comes true ", 9),
                new Movie(3, "Ojciec chrzestny ", "Kryminał", "", 7),
                new Movie(4, "Shape of Water", "Fantasy", "Simple Movie for evening", 7),
                new Movie(4, "Efekt Motyla", "Sci-Fi", "Simple Movie for evening", 10)
        )
                .forEach(movieDatabase::save);
}}