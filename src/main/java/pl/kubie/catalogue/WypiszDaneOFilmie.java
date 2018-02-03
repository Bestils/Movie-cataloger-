package pl.kubie.catalogue;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by Gladus on 02.02.2018.
 */

    public class WypiszDaneOFilmie {

        public List<Film> Filmy = new ArrayList<Film>();

        public void dodajFilm(Film film) {
            Filmy.add(film);
            System.out.println("Dziękuję, dodałem Filma do kolekcji" + "\n");
        }

        public void wyswietlFilmy() {
            System.out.println("#############################################################");
            System.out.println("#                                                           #");
            System.out.println("#                     ***Lista Filmów***                     #");
            System.out.println("#                                                           #");
            System.out.println("#############################################################");
            for (Film film : Filmy) {
                System.out.println("Film [" + Filmy.indexOf(film) + "]: " + film.getTitle());
            }
        }

        public void przedstawSie(Integer indeksFilma) {
            System.out.println("\n");
            System.out.println("#############################################################");
            System.out.println("#                                                           #");
            System.out.println("#                 ***Przedstawiam Film***                   #");
            System.out.println("#                                                           #");
            System.out.println("#############################################################");
            System.out.println("Tytół: " + Filmy.get(indeksFilma).getTitle());
            System.out.println("Gatunek: " + Filmy.get(indeksFilma).getType());
            System.out.println("Aktualna Ocena: " + Filmy.get(indeksFilma).getRate());
            System.out.println("\n");
        }
    }


