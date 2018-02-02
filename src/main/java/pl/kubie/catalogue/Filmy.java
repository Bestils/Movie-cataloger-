package pl.kubie.catalogue;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by Gladus on 02.02.2018.
 */
public class Filmy {
    
    



    /**
     * Created by dobry on 02.10.16.
     */
    public class Film {

        public List<Film> Filmy = new ArrayList<Film>();

        public void dodajFilma(Film Film) {
            Filmy.add(Film);
            System.out.println("Dziękuję, dodałem Filma do kolekcji" + "\n");
        }

        public void wyswietlFilmy() {
            System.out.println("#############################################################");
            System.out.println("#                                                           #");
            System.out.println("#                     ***Lista Filmów***                     #");
            System.out.println("#                                                           #");
            System.out.println("#############################################################");
            for (Film Film : Filmy) {
                System.out.println("Film [" + Filmy.indexOf(Film) + "]: " + Film.getTitleFilma());
            }
        }

        public void przedstawSie(int indeksFilma) {
            System.out.println("\n");
            System.out.println("#############################################################");
            System.out.println("#                                                           #");
            System.out.println("#                 ***Przedstawiam Film***                   #");
            System.out.println("#                                                           #");
            System.out.println("#############################################################");
            System.out.println("Tytół: " + Filmy.get(indeksFilma).getmovietitle());
            System.out.println("Gatunek: " + Filmy.get(indeksFilma).getMovieType());
            System.out.println("Aktualna Ocena: " + Filmy.get(indeksFilma).getOcena());
            System.out.println("\n");
        }
    }
    
}
