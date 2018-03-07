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
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("filmoteka"); ;
    private static EntityManager entityManager = entityManagerFactory.createEntityManager();

    public static void main(String[] args) {
        insertSampleData();
        do {
            view.showMenu();

            switch (userInput.getUserNumber()) {
                case View.AD_MOVIE:
                    CreateNewMovie();

                    break;
                case View.SHOW_MOVIES:
                    showAllMovies();
                    break;
                case View.ADD_RATE: {
                    view.ShowMovieDatabase(movieDatabase.findall());
                    int numberChoice = userInput.getUserNumber("Chose movie to change it rating");
                    movieService.addRate(numberChoice);
                }
                break;
                case View.CHANGE_CATEGORY: {
                    view.ShowMovieDatabase(movieDatabase.findall());
                    int numberChoice = userInput.getUserNumber("Chose movie to change it category");
                    movieService.setCategory(numberChoice);
                }
                break;
                case View.SORT_MOVIES:
                    showSortMenu();
                    break;
                case View.SEARCH_MOVIE: {
                    movieService.search();
                }

                break;
                case View.DELETE_MOVIE: {
                    view.ShowMovieDatabase(movieDatabase.findall());
                    int numberChoice = userInput.getUserNumber("Chose movie to change it category");
                    movieService.DeleteMovie(numberChoice);
                }
                break;
                case View.AD_COMMENT: {
                    view.ShowMovieDatabase(movieDatabase.findall());
                    int numberChoice = userInput.getUserNumber("Chose movie add Commentary");
                    movieService.AddComment(numberChoice);
                }
                break;
                case View.SHOW_COMMENTS: {
                    view.ShowMovieDatabase(movieDatabase.findall());
                    int numberChoice = userInput.getUserNumber("Chose movie to show comments");
                    movieService.showComments(numberChoice);
                }
                break;
                case View.CLOSE_PROGRAM: {
                    System.exit(0);
                }
            }
        } while (true);
    }

    private static void showAllMovies() {
        boolean poprawny;

        if (movieDatabase.findall().size() > 0) {
            view.ShowMovieDatabase(movieDatabase.findall());
            System.out.println("Chose number of movie whose you want and push ENTER");
            Integer movieNumber;
            do {
                movieNumber = scanner.nextInt();
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
        int numberChoice = userInput.getUserNumber();
        if (numberChoice == 1)
            view.ShowMovieDatabase(movieDatabase.findAllSortByTitle());
        else if (numberChoice == 2)
            view.ShowMovieDatabase(movieDatabase.findAllSortByCategory());
        else if (numberChoice == 3)
            view.ShowMovieDatabase(movieDatabase.findAllSortByRate());
        else if (numberChoice == 4)
            view.ShowMovieDatabase(movieDatabase.findAllSortByDate());
        else {
            System.out.println("Wrong number !");
        }
    }

    private static void CreateNewMovie() {
        userInput.getUserChoice(); //prevents you from skipping the next item
        int id = movieDatabase.findall().size();
        String title = userInput.getUserChoice("Please, enter movie Title: ");
        String comment = userInput.getUserChoice("Please add comment to movie ");
        Integer rate = movieService.returnRate();
        System.out.println("Please choose category of  this movie");
        movieService.showCategories();
        String category = movieService.returnCategory();
        Movie movie = new Movie(id, title, category, comment, rate);
        movieDatabase.save(movie);

        entityManager.getTransaction().begin();
        entityManager.persist(movie);
        entityManager.getTransaction().commit();

    }

    static private void insertSampleData() {
        Arrays.asList(
                new Movie(1, "Interstellar", "Sci-Fi", "Best Movie Ever!", 10),
                new Movie(2, "Incepcja", "Sci-Fi", "When dreams comes true ", 9),
                new Movie(3, "Ojciec chrzestny ", "Kryminał", "", 7),
                new Movie(4, "Shape of Water", "Fantasy", "Simple Movie for evening", 7),
                new Movie(4, "Efekt Motyla", "Sci-Fi", "Simple Movie for evening", 10)
        )
                .forEach( movieDatabase::save);



    }
}