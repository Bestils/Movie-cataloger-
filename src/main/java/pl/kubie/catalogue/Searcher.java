package pl.kubie.catalogue;

import java.awt.print.Book;
import java.util.List;

/**
 * Created by Gladus on 08.02.2018.
 */
public class Searcher {

    static MovieDatabase movieDatabase= new MovieDatabase();
static View view = new View();
    public static void search() {
        System.out.println("Do you want to search by title (1), rate (2), type(3) or date(4).");
        int numberChoice = view.getUserNumber();
        if (numberChoice == 1) {
            System.out.println( "You are searching by title, input text:");
            String titleToSearch = view.getUserChoice();
            System.out.println( movieDatabase.findByTitle(titleToSearch));
        } else if (numberChoice == 2) {
            System.out.println( "You are searching by rate, input 2 numbers to to specify the range :");
            int smalerRate = view.getUserNumber();
            int bigerRate = view.getUserNumber();
            if (smalerRate>bigerRate){
                int temp=smalerRate;
                smalerRate=bigerRate;
                bigerRate=temp;
            }
            System.out.println(movieDatabase.findByAverageRate(smalerRate,bigerRate));

        } else if (numberChoice == 3) {
            System.out.println( "You are searching by type, chose your type:");


        }
        else if (numberChoice == 4) {
            System.out.println("You are searching by date of add. Input year:");
            int y = view.getUserNumber();
            System.out.println("You are searching by date of add. Input year:");
            int m = view.getUserNumber();
            System.out.println("You are searching by date of add. Input year:");
            int d = view.getUserNumber();
            System.out.println( movieDatabase.findByDate(y, m, d));

        } else {
            System.out.println("Bad chose");
        }

    }
}
