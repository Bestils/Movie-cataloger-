package pl.kubie.catalogue;

import java.util.*;
import java.util.regex.Pattern;

public class MovieService {
    private MovieDatabase movieDatabase;
    private View view;
    private UserInput userInput;

    public MovieService(MovieDatabase movieDatabase, View view, UserInput userInput) {
        this.movieDatabase = movieDatabase;
        this.view = view;
        this.userInput = userInput;
    }

    private void createMovie() {
        System.out.println("#############################################################");
        System.out.println("#                                                           #");
        System.out.println("#                   ***Adding Movie***                     #");
        System.out.println("#                                                           #");
        System.out.println("#############################################################");

        Scanner sc = new Scanner(System.in);

        System.out.println("title");
        String movieTitle = sc.nextLine();
        System.out.println("type");
        String type = sc.nextLine();
        System.out.println("comment");
        String comment = sc.nextLine();
        System.out.println("rate");
        Integer rate = Integer.parseInt(sc.nextLine());
        Movie movie = new Movie(movieTitle, type);
        Rate rateObject = new Rate(rate, movie);
        Comments commentObject = new Comments(comment, movie);
        movieDatabase.save(movie);
        movieDatabase.saveComment(commentObject);
        movieDatabase.saveRate(rateObject);
    }

    public void DeleteMovie(Integer Index) {


//        movieDatabase.remove(Index);
        System.out.println("Movie  deleted" + "\n");
    }

    public void AddComment(Integer index) {
        Scanner sc = new Scanner(System.in);
        String comment = sc.nextLine();
        Comments commentObject = new Comments(comment, movieDatabase.findById(index));
        movieDatabase.saveComment(commentObject);
    }

    public void showComments(Integer index) {
        Scanner sc = new Scanner(System.in);
//        movieDatabase.findById(index).getComment();
    }

    public Integer returnRate() {
        Scanner sc = new Scanner(System.in);
        Pattern wzóroceny = Pattern.compile("[0-9]?");
        String OcenaPobrana;
        do {
            System.out.print("Give a rating [0-9]: ");
            OcenaPobrana = sc.nextLine();
            if (wzóroceny.matcher(OcenaPobrana).matches()) {
                return Integer.valueOf(OcenaPobrana);

            } else
                return 0;
        } while (wzóroceny.matcher(OcenaPobrana).matches());
    }

    public void addRate(Integer index) {
        int inputRate;
        Pattern ratePattern = Pattern.compile("[0-9]?");
        String numberToMatch;
        do {
            System.out.print("Give a rating [0-9]: ");
            inputRate = UserInput.getUserNumber();
            numberToMatch = Integer.toString(inputRate);
            if (ratePattern.matcher(numberToMatch).matches()) {
                Rate rate = new Rate((Integer.valueOf(inputRate)), movieDatabase.findById(index));
                movieDatabase.saveRate(rate);

            }
        } while (!ratePattern.matcher(numberToMatch).matches());
    }

    public Map<Integer, String> getCategories() {

        Map<Integer, String> MovieCategorys = new HashMap<>();
        MovieCategorys.put(1, "Dramat");
        MovieCategorys.put(2, "Komedia");
        MovieCategorys.put(3, "Romans");
        MovieCategorys.put(4, "Akcji");
        MovieCategorys.put(5, "Thriler");
        MovieCategorys.put(6, "Dokumentalny");
        MovieCategorys.put(7, "Fantasy");
        MovieCategorys.put(8, "Kriminał");
        MovieCategorys.put(9, "Psychologiczny");
        MovieCategorys.put(10, "Przygodowy");
        MovieCategorys.put(11, "Rodzinny");

        return MovieCategorys;
    }

    public void showCategories() {
        Map<Integer, String> categories = getCategories();
        for (Map.Entry<Integer, String> entry : categories.entrySet()) {
            Integer key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + ": " + value);
        }
    }

    public void setCategory(Integer movieIndex) {
        Map<Integer, String> categories = getCategories();

        Scanner sc = new Scanner(System.in);
        Integer Gatunek = sc.nextInt();
        System.out.println("Chose number with category of movie");
        movieDatabase.findById(movieIndex).setType(categories.get(Gatunek));
    }

    public String returnCategory() {
        Map<Integer, String> categories = getCategories();

        Scanner sc = new Scanner(System.in);
        Integer Gatunek = sc.nextInt();
        System.out.println("Chose number with category of movie");
        return categories.get(Gatunek);

    }
    public  void search() {
        String titleToSearch;
        int numberChoice = userInput.getUserNumber("Do you want to search by title (1), rate (2), type(3) or date(4).");

        switch (numberChoice) {
            case 1: {
                titleToSearch = userInput.getUserChoice(("You are searching by title, input text:"));
                titleToSearch = userInput.getUserChoice(("You are searching by title, input text:"));
                movieDatabase.findByTitle(titleToSearch);
                System.out.println();
            }break;
            case 2: {
                System.out.println("You are searching by rate");
                int smalerRate = userInput.getUserNumber("First please input smaller number");
                int bigerRate = userInput.getUserNumber("Now input bigger number");
                if (smalerRate > bigerRate) {
                    int temp = smalerRate;
                    smalerRate = bigerRate;
                    bigerRate = temp;
                }
                System.out.println(movieDatabase.findByAverageRate(smalerRate, bigerRate));
            }
            break;
            case 3: {
                System.out.println("You are searching by type, chose your type:");
               returnCategory();
              String category  =returnCategory();
               System.out.println(movieDatabase.findByType(category));
            }break;
            case 4: {
                movieDatabase.findByDate(userInput.returnDate());
                break;
            }
            default: {
                System.out.println("Bad chose");
            }break;
        }
    }
}
