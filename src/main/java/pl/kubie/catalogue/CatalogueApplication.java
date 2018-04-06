package pl.kubie.catalogue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Arrays;
import java.util.Scanner;

public class CatalogueApplication {

    static MovieDatabase movieDatabase = new MovieDatabase();
    static Scanner scanner = new Scanner(System.in);
    static View view = new View(scanner, movieDatabase);
    static UserInput userInput = new UserInput(scanner);

    static MovieService movieService = new MovieService(movieDatabase, view, userInput);

    //
    public static void main(String[] args) {
        insertSampleData();
//        movieDatabase.findById(userInput.getUserNumber());
        do {
            view.showMenu();
            userInput.getUserNumber()
            switch () {
                case View.AD_MOVIE:
                    CreateNewMovie();

                    break;
                case View.SHOW_MOVIES:
                    showAllMovies();
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
//                    showSortMenu();
                    break;
                case View.SEARCH_MOVIE: {
//                    movieService.search();
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

    private static void showAllMovies() {
        boolean poprawny;

        if (movieDatabase.findAll().size() > 0) {
            view.ShowMovieDatabase(movieDatabase.findAll());
            System.out.println("Chose number of movie whose you want and push ENTER");
            Integer movieNumber;
                movieNumber = scanner.nextInt();

                    view.showMovieInformations(movieDatabase.findById(movieNumber));




        }
    }

//    private static void showSortMenu() {
//        System.out.println("#############################################################");
//        System.out.println("#                                                           #");
//        System.out.println("#                 ***Sort movie by:***                      #");
//        System.out.println("#                                                           #");
//        System.out.println("#############################################################");
//        System.out.println("[1] Title");
//        System.out.println("[2] Category");
//        System.out.println("[3] Rating");
//        System.out.println("[4] Date");
//        int numberChoice = userInput.getUserNumber();
//        if (numberChoice == 1)
//            view.ShowMovieDatabase(movieDatabase.findAllSortByTitle());
//        else if (numberChoice == 2)
//            view.ShowMovieDatabase(movieDatabase.findAllSortByCategory());
//        else if (numberChoice == 3)
//            view.ShowMovieDatabase(movieDatabase.findAllSortByRate());
//        else if (numberChoice == 4)
//            view.ShowMovieDatabase(movieDatabase.findAllSortByDate());
//        else {
//            System.out.println("Wrong number !");
//        }
//    }

    private static void CreateNewMovie() {
        userInput.getUserChoice(); //prevents you from skipping the next item

        String title = userInput.getUserChoice("Please, enter movie Title: ");
        String comment = userInput.getUserChoice("Please add comment to movie ");
        Integer rate = movieService.returnRate();
        System.out.println("Please choose category of  this movie");
        movieService.showCategories();
        String category = movieService.returnCategory();
        Movie movie = new Movie(title, category);
        Comments commentObject = new Comments(comment, movie);
        Rate rateObject = new Rate(rate, movie);
        movieDatabase.save(movie);
        movieDatabase.saveComment(commentObject);
        movieDatabase.saveRate(rateObject);

    }

    static private void insertSampleData() {
        Movie example = new Movie("Interstellar", "Sci-Fi");
        Comments comment = new Comments("Idealny film ! ", example);
        Comments comment1 = new Comments("Majstersztyk! ", example);
        movieDatabase.saveComment(comment);
        movieDatabase.saveComment(comment1);
        Rate rate = new Rate(10, example);
        Rate rate1 = new Rate(9, example);
        Rate rate11 = new Rate(10, example);
        movieDatabase.saveRate(rate);
        movieDatabase.saveRate(rate1);
        movieDatabase.saveRate(rate11);
        movieDatabase.save(example);
        Movie example2 = new Movie("Incepcja", "Sci-Fi");
        Comments comment2 = new Comments(" When dreams comes true  ! ", example2);
        movieDatabase.saveComment(comment2);
        Rate rate2 = new Rate(10, example2);
        Rate rate21 = new Rate(7, example2);
        Rate rate22 = new Rate(8, example2);
        Rate rate23 = new Rate(9, example2);
        movieDatabase.saveRate(rate2);
        movieDatabase.saveRate(rate21);
        movieDatabase.saveRate(rate22);
        movieDatabase.saveRate(rate23);
        movieDatabase.save(example2);
        Movie example3 = new Movie("Efekt Motyla", "Thriler");
        Comments comment3 = new Comments("świetny film, polecam! ", example3);
        movieDatabase.saveComment(comment3);
        Rate rate3 = new Rate(10, example3);
        Rate rate31 = new Rate(9, example3);
        Rate rate32 = new Rate(9, example3);
        movieDatabase.saveRate(rate3);
        movieDatabase.saveRate(rate31);
        movieDatabase.saveRate(rate32);
        movieDatabase.save(example3);
        Movie example4 = new Movie("Ojciec chrzestny ", "Kryminał");
        Comments comment4 = new Comments("Na weselu córki  ", example4);
        Rate rate4 = new Rate(9, example4);
        Rate rate41 = new Rate(8, example4);
        Rate rate42 = new Rate(7, example4);
        movieDatabase.saveRate(rate4);
        movieDatabase.saveRate(rate41);
        movieDatabase.saveRate(rate42);
        movieDatabase.save(example4);
        Movie example5 = new Movie("Shape of Water", "Fantasy");
        Comments comment5 = new Comments("Simple Movie for evening", example5);
        Rate rate5 = new Rate(6, example5);
        Rate rate51 = new Rate(5, example5);
        Rate rate52 = new Rate(6, example5);
        movieDatabase.saveRate(rate5);
        movieDatabase.saveRate(rate51);
        movieDatabase.saveRate(rate52);
        movieDatabase.save(example5);

    }

//    static private void insertSampleData() {
//        Arrays.asList(
//                new Movie( "Interstellar", "Sci-Fi"),
//                new Comments("Best Movie Ever!" ),
//                new Movie( "Incepcja", "Sci-Fi" ),
//                new Movie( "Ojciec chrzestny ", "Kryminał"),
//                new Movie( "Shape of Water", "Fantasy"),
//                new Movie( "Efekt Motyla", "Sci-Fi")
//        )
//                .forEach( movieDatabase::save);
//        Arrays.asList(
// new Rate(10, example);
// new Rate(9, example);
// new Rate(10, example);
//new Rate(10, example2);
// new Rate(7, example2);
// new Rate(8, example2);
// new Rate(9, example2);
//new Rate(10, example3);
// new Rate(9, example3);
//new Rate(9, example3);
// new Rate(9, example4);
// new Rate(8, example4);
// new Rate(7, example4);
// new Rate(6, example5);
// new Rate(5, example5);
// new Rate(6, example5);
//        )
//                .forEach( movieDatabase::saveRAte);
//
//

}
