package pl.kubie.catalogue;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * Created by Gladus on 18.02.2018.
 */
public class UserInput {
   static Scanner sc;
   static  boolean isNumber;
   static  int number;
    UserInput(Scanner sc) {
        this.sc = sc;
    }
    public int getUserNumber(String message) {
            System.out.println(message);
            return getUserNumber();

    }

    public String getUserChoice(String message) {
        System.out.println(message);
        return sc.nextLine();
    }

    public static int getUserNumber() {
do {

    if (sc.hasNextInt()) {
         number= Integer.parseInt(sc.nextLine());
        isNumber=false;

    }else{
        System.out.println("It's not number");
        isNumber=true;
    }
}while (isNumber);
        return number;
    }

    public String getUserChoice() {

        return sc.nextLine();
    }



    public LocalDate dateToFind() {
        return LocalDate.parse(getUserChoice("Enter date (format: yyyy-MM-dd):"));
    }

    public LocalDate returnDate() {
        int year = getUserNumber("Type in year");
        int month = getUserNumber("Type in month");
        int day = getUserNumber("Type in day");
        LocalDate date = LocalDate.of(year, month, day);
        return date;
    }
}



