package pl.kubie.catalogue.Temporary;

import pl.kubie.catalogue.Functions.Comments;
import pl.kubie.catalogue.Functions.Rate;
import pl.kubie.catalogue.database.Movie;

/**
 * Created by Gladus on 28.05.2018.
 */
public class InsertNewData {

    static private void insertSampleData() {
        Movie example = new Movie("Interstellar", "Sci-Fi");
        Comments comment = new Comments("Idealny film ! ", example);
        Comments comment1 = new Comments("Majstersztyk! ", example);
        movieDatabase.saveComment(comment);
        movieDatabase.saveComment(comment1);
        Rate rate = new Rate(10, example);
        Rate rate1 = new Rate(9, example);
        Rate rate11 = new Rate(10, example);
        movieDatabase.saveRate(rate);
        movieDatabase.saveRate(rate1);
        movieDatabase.saveRate(rate11);
        movieDatabase.save(example);
        Movie example2 = new Movie("Incepcja", "Sci-Fi");
        Comments comment2 = new Comments(" When dreams comes true  ! ", example2);
        movieDatabase.saveComment(comment2);
        Rate rate2 = new Rate(10, example2);
        Rate rate21 = new Rate(7, example2);
        Rate rate22 = new Rate(8, example2);
        Rate rate23 = new Rate(9, example2);
        movieDatabase.saveRate(rate2);
        movieDatabase.saveRate(rate21);
        movieDatabase.saveRate(rate22);
        movieDatabase.saveRate(rate23);
        movieDatabase.save(example2);
        Movie example3 = new Movie("Efekt Motyla", "Thriler");
        Comments comment3 = new Comments("świetny film, polecam! ", example3);
        movieDatabase.saveComment(comment3);
        Rate rate3 = new Rate(10, example3);
        Rate rate31 = new Rate(9, example3);
        Rate rate32 = new Rate(9, example3);
        movieDatabase.saveRate(rate3);
        movieDatabase.saveRate(rate31);
        movieDatabase.saveRate(rate32);
        movieDatabase.save(example3);
        Movie example4 = new Movie("Ojciec chrzestny ", "Kryminał");
        Comments comment4 = new Comments("Na weselu córki  ", example4);
        Rate rate4 = new Rate(9, example4);
        Rate rate41 = new Rate(8, example4);
        Rate rate42 = new Rate(7, example4);
        movieDatabase.saveRate(rate4);
        movieDatabase.saveRate(rate41);
        movieDatabase.saveRate(rate42);
        movieDatabase.save(example4);
        Movie example5 = new Movie("Shape of Water", "Fantasy");
        Comments comment5 = new Comments("Simple Movie for evening", example5);
        Rate rate5 = new Rate(6, example5);
        Rate rate51 = new Rate(5, example5);
        Rate rate52 = new Rate(6, example5);
        movieDatabase.saveRate(rate5);
        movieDatabase.saveRate(rate51);
        movieDatabase.saveRate(rate52);
        movieDatabase.save(example5);

    }
}
