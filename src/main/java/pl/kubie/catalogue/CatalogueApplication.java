package pl.kubie.catalogue;

import java.util.Scanner;


public class CatalogueApplication {

    static MovieDatabase movieDatabase = new MovieDatabase();
    static Scanner NumberScanner = new Scanner(System.in);
    static View view = new View(NumberScanner,movieDatabase);

    public static void main(String[] args) {

        //MENU
        Integer wyborUzytkownika;
        boolean poprawny;
        do {
            view.showMenu();

            switch (view.getUserChoice()) {


                case View.AD_MOVIE:
                    CreateNewMovie();
                    break;
                case View.SHOW_MOVIES:
                    showAllMovies();
                    break;
                case View.CHANGE_RATE: {
                    view.ShowmovieDatabase(movieDatabase.findById(numerMovieu));
                    System.out.println("Chose movie to change it rating");
                    view.SetRate(NumberScanner.nextInt());

                }
                case View.CHANGE_CATEGORY: {

                    view.ShowMovies();
                    System.out.println("Chose movie to change it category");
                    view.SetCategory(NumberScanner.nextInt());

                }
                break;
                case View.SORT_MOVIES:
                    showSortMenu();

                break;
                case View.AD_COMMENTARY: {
                    movieDatabase.findall();
                    System.out.println("Chose movie add Commentary");
                    view.AddComment(NumberScanner.nextInt());
                }
                break;
                case View.DELETE_MOVIE: {
                    movieDatabase.findall();
                    System.out.println("Chose movie to delete ");
                    view.DeleteMovie(NumberScanner.nextInt());
                }
                break;
                case View.CLOSE_PROGRAM{
                    System.out.print("Program is closed ");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.exit(0);
                }
            }

        } while (true);
    }

    private static void showAllMovies() {
        boolean poprawny;
        view.ShowmovieDatabase();

        //WYBIERZ Movie Z LISTY
        System.out.println("Chose number of movie whose you want and push ENTER");
        Integer numerMovieu;
        do {
            numerMovieu = NumberScanner.nextInt();
            if (numerMovieu >= 0 && numerMovieu <  movieDatabase.findById(numerMovieu).size()) {
                poprawny = true;

                //PRZEDSTAW Movie
                view.showMovieInformations(MovieDatabase.find);
            } else {
                System.out.println("Bad  Movie number! Please give correct number");
                poprawny = false;
            }
        }
        while (!poprawny); //WALIDUJ WYBÓR}}
    }

    private static void showSortMenu() {
        System.out.println("#############################################################");
        System.out.println("#                                                           #");
        System.out.println("#                 ***Search movie by:***                  #");
        System.out.println("#                                                           #");
        System.out.println("#############################################################");
        System.out.println("[1] Title");
        System.out.println("[2] Category");
        System.out.println("[3] Rating");
    }

    private static void CreateNewMovie() {

    }
}