package pl.kubie.catalogue;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * Created by Gladus on 18.02.2018.
 */
public class UserInput {
    Scanner sc;
    UserInput(Scanner sc) {
        this.sc = sc;
    }
    public int getUserNumber(String message) {
        System.out.println(message);
        return sc.nextInt();
    }

    public String getUserChoice(String message) {
        System.out.println(message);
        return sc.nextLine();
    }

    public int getUserNumber() {

        return sc.nextInt();
    }

    public String getUserChoice() {

        return sc.nextLine();
    }

    public LocalDate returnDate() {
        int year = getUserNumber("Type in year");
        int month = getUserNumber("Type in month");
        int day = getUserNumber("Type in day");
        LocalDate date = LocalDate.of(year, month, day);
        return date;
    }

    public LocalDate dateToFind() {
        return LocalDate.parse(getUserChoice("Enter date (format: yyyy-MM-dd):"));
    }


}



