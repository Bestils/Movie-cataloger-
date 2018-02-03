package pl.kubie.catalogue;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by Gladus on 02.02.2018.
 */

    public class WypiszDaneOFilmie {

        public List<Film> WypiszDaneOFilmie = new ArrayList<Film>();

        public void dodajFilm(Film film) {
            WypiszDaneOFilmie.add(film);
            System.out.println("Dziękuję, dodałem Filma do kolekcji" + "\n");
        }

        public void wyswietlFilmy() {
            System.out.println("#############################################################");
            System.out.println("#                                                           #");
            System.out.println("#                     ***Lista Filmów***                     #");
            System.out.println("#                                                           #");
            System.out.println("#############################################################");
            for (Film film : WypiszDaneOFilmie) {
                System.out.println("Film [" + WypiszDaneOFilmie.indexOf(film) + "]: " + film.getTitle());
            }
        }

        public void przedstawSie(int indeksFilma) {
            System.out.println("\n");
            System.out.println("#############################################################");
            System.out.println("#                                                           #");
            System.out.println("#                 ***Przedstawiam Film***                   #");
            System.out.println("#                                                           #");
            System.out.println("#############################################################");
            System.out.println("Tytół: " + WypiszDaneOFilmie.get(indeksFilma).getTitle());
            System.out.println("Gatunek: " + WypiszDaneOFilmie.get(indeksFilma).getType());
            System.out.println("Aktualna Ocena: " + WypiszDaneOFilmie.get(indeksFilma).getRate());
            System.out.println("\n");
        }
    }

}
