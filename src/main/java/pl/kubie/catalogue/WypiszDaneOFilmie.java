package pl.kubie.catalogue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Gladus on 02.02.2018.
 */

    public class WypiszDaneOFilmie {

        public List<Film> Filmy = new ArrayList<Film>();

        public void dodajFilmDoKolekcji(Film ExampleMovie) {
            Filmy.add(ExampleMovie);
            System.out.println("Dziękuję, dodałem Filma do kolekcji" + "\n");
        }

        public void wyswietlFilmy() {
            System.out.println("#############################################################");
            System.out.println("#                                                           #");
            System.out.println("#                     ***Lista Filmów***                    #");
            System.out.println("#                                                           #");
            System.out.println("#############################################################");
            for (Film ExampleMovie : Filmy) {
                System.out.println("Film [" + Filmy.indexOf(ExampleMovie) + "]: " + ExampleMovie.getTitle());
            }
        }

        public void przedstawSie(Integer indeksFilmu) {
            System.out.println("\n");
            System.out.println("#############################################################");
            System.out.println("#                                                           #");
            System.out.println("#                 ***Przedstawiam Film***                   #");
            System.out.println("#                                                           #");
            System.out.println("#############################################################");
            System.out.println("Tytół: " + Filmy.get(indeksFilmu).getTitle());
            System.out.println("Gatunek: " + Filmy.get(indeksFilmu).getType());
            System.out.println("Aktualna Ocena: " + Filmy.get(indeksFilmu).getRate());
            System.out.println("\n");
        }
    public void Ustawocenę(Integer indeksFilmu) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Wprowadz nową ocenę");
        Filmy.get(indeksFilmu).SetMovieRate(sc.nextInt());
    }
    }


