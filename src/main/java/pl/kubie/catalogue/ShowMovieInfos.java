package pl.kubie.catalogue;

import java.util.*;
import java.util.regex.Pattern;

/**
 * Created by Gladus on 02.02.2018.
 */

public class ShowMovieInfos {

    public List<Movie> Movies = new ArrayList<Movie>();

    public void AddMovieToCollection(Movie ExampleMovie) {
        Movies.add(ExampleMovie);
        System.out.println("Movie  added" + "\n");
    }

    public void DeleteMovie(Integer  Index) {
        Movies.remove(Index);
        System.out.println("Movie  deleted" + "\n");
    }
    public void ShowMovies() {
        System.out.println("#############################################################");
        System.out.println("#                                                           #");
        System.out.println("#                     *** Movie List***                    #");
        System.out.println("#                                                           #");
        System.out.println("#############################################################");
        for (Movie ExampleMovie : Movies) {
            System.out.println("Movie [" + Movies.indexOf(ExampleMovie) + "]: " + ExampleMovie.getTitle());
        }
    }

    public void ShowMovieInformations(Integer indeksMovieu) {
        System.out.println("\n");

        System.out.println("Title: " + Movies.get(indeksMovieu).getTitle());
        System.out.println("Category : " + Movies.get(indeksMovieu).getType());
        System.out.println("Actual rating of movie: " + Movies.get(indeksMovieu).getRate());
        System.out.println("\n");
    }


    public void AddComment(Integer MovieIndex) {
        Scanner sc = new Scanner(System.in);

        String  Comment = sc.nextLine();
        Movies.get(MovieIndex).SetMovieComment(Comment);}

    public void SetRate(Integer indeksMovieu) {
        Scanner sc = new Scanner(System.in);
        Pattern wzóroceny = Pattern.compile("[0-9]?");
        String  OcenaPobrana;
        do {
            System.out.print("Give a rating [0-9]: ");
            OcenaPobrana = sc.nextLine();

            if (wzóroceny.matcher(OcenaPobrana).matches()) {
                Movies.get(indeksMovieu).SetMovieRate(Integer.valueOf(OcenaPobrana));
            }
        } while (Movies.get(indeksMovieu).getRate() == null);

    }  public void SetCategory(Integer MovieIndex ){
        Scanner sc = new Scanner(System.in);


        Map<Integer, String> MovieCategorys = new HashMap<>();


        MovieCategorys.put(1,"Dramat");
        MovieCategorys.put(2,"Komedia");
        MovieCategorys.put(3,"Romans");
        MovieCategorys.put(4,"Akcji");
        MovieCategorys.put(5,"Thriler");
        MovieCategorys.put(6,"Dokumentalny");
        MovieCategorys.put(7,"Fantasy");
        MovieCategorys.put(8,"Kriminał");
        MovieCategorys.put(9,"Psychologiczny");
        MovieCategorys.put(10,"Przygodowy");
        MovieCategorys.put(11,"Rodzinny");

        System.out.println("Chose number with category of movie");
        for(Map.Entry<Integer, String> entry : MovieCategorys.entrySet()) {
            Integer key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + ": " + value);
        }			Integer Gatunek = sc.nextInt();

        Movies.get(MovieIndex).SetMovieType(MovieCategorys.get(Gatunek));

    }
}




