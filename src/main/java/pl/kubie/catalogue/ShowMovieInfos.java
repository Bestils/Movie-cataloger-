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
        System.out.println("Dziękuję, dodałem Movie do kolekcji" + "\n");
    }

    public void DeleteMovie(Integer  Index) {
        Movies.remove(Index);
        System.out.println("Dziękuję, Usunąłem Movie z kolekcji" + "\n");
    }
    public void ShowMovies() {
        System.out.println("#############################################################");
        System.out.println("#                                                           #");
        System.out.println("#                     ***Lista Movieów***                    #");
        System.out.println("#                                                           #");
        System.out.println("#############################################################");
        for (Movie ExampleMovie : Movies) {
            System.out.println("Movie [" + Movies.indexOf(ExampleMovie) + "]: " + ExampleMovie.getTitle());
        }
    }

    public void ShowMovieInformations(Integer indeksMovieu) {
        System.out.println("\n");
        System.out.println("#############################################################");
        System.out.println("#                                                           #");
        System.out.println("#                 ***Przedstawiam Movie***                   #");
        System.out.println("#                                                           #");
        System.out.println("#############################################################");
        System.out.println("Tytół: " + Movies.get(indeksMovieu).getTitle());
        System.out.println("Gatunek: " + Movies.get(indeksMovieu).getType());
        System.out.println("Aktualna Ocena: " + Movies.get(indeksMovieu).getRate());
        System.out.println("\n");
    }
    public void SetRate(Integer indeksMovieu) {
        Scanner sc = new Scanner(System.in);
        Pattern wzóroceny = Pattern.compile("[0-9]?");
        String  OcenaPobrana;
        do {
            System.out.print("Podaj Ocene Movie 0-9: ");
            OcenaPobrana = sc.nextLine();

            if (wzóroceny.matcher(OcenaPobrana).matches()) {
                Movies.get(indeksMovieu).SetMovieRate(Integer.valueOf(OcenaPobrana));
            }
        } while (Movies.get(indeksMovieu).getRate() == null);

    }  public void SetCategory(Integer indeksMovieu) {
        Scanner sc = new Scanner(System.in);


        Map<Integer, String> GatunkiMovieowe = new HashMap<>();


        GatunkiMovieowe.put(1,"Dramat");
        GatunkiMovieowe.put(2,"Komedia");
        GatunkiMovieowe.put(3,"Romans");
        GatunkiMovieowe.put(4,"Akcji");
        GatunkiMovieowe.put(5,"Thriler");
        GatunkiMovieowe.put(6,"Dokumentalny");
        GatunkiMovieowe.put(7,"Fantasy");
        GatunkiMovieowe.put(8,"Kriminał");
        GatunkiMovieowe.put(9,"Psychologiczny");
        GatunkiMovieowe.put(10,"Przygodowy");
        GatunkiMovieowe.put(11,"Rodzinny");

        System.out.println("Wybierz cyfre przy gatunku");
        for(Map.Entry<Integer, String> entry : GatunkiMovieowe.entrySet()) {
            Integer key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + ": " + value);
        }			Integer Gatunek = sc.nextInt();

        Movies.get(indeksMovieu).SetMovieType(GatunkiMovieowe.get(Gatunek));

    }
}




