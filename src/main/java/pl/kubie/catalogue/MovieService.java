package pl.kubie.catalogue;
import java.util.*;
import java.util.regex.Pattern;


public class MovieService {
    private MovieDatabase movieDatabase;
    private View view;

    public MovieService(MovieDatabase movieDatabase,View view) {
        this.movieDatabase = movieDatabase;
        this.view=view;
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
        Movie movie = new Movie(-1, movieTitle, type, comment, rate);
        movieDatabase.save(movie);
    }
    public void DeleteMovie(Integer Index) {


        movieDatabase.remove(Index);
        System.out.println("Movie  deleted" + "\n");
    }

    public void AddComment(Integer index) {
        Scanner sc = new Scanner(System.in);
        String comment = sc.nextLine();
        movieDatabase.findById(index).setComment(comment);
    }
    public void showComments(Integer index) {
        Scanner sc = new Scanner(System.in);
        movieDatabase.findById(index).getComment();
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

    public void setRate(Integer index) {
        Scanner sc = new Scanner(System.in);
        Pattern wzóroceny = Pattern.compile("[0-9]?");
        String OcenaPobrana;
        do {
            System.out.print("Give a rating [0-9]: ");
            OcenaPobrana = sc.nextLine();
            if (wzóroceny.matcher(OcenaPobrana).matches()) {
                movieDatabase.findById(index).addRate(Integer.valueOf(OcenaPobrana));

            }
        } while (wzóroceny.matcher(OcenaPobrana).matches());
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

        int numberChoice = view.getUserNumber("Do you want to search by title (1), rate (2), type(3) or date(4).");


        switch (numberChoice) {
            case 1: {
                String titleToSearch = view.getUserChoice(("You are searching by title, input text:"));
                System.out.println(movieDatabase.findByTitle(titleToSearch));
            }break;
            case 2: {
                System.out.println("You are searching by rate");
                int smalerRate = view.getUserNumber("First please input smaller number");
                int bigerRate = view.getUserNumber("Now input bigger number");
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
                movieDatabase.findByDate(view.returnDate());
                break;
            }
            default: {
                System.out.println("Bad chose");
            }break;

        }
    }
}
