package pl.kubie.catalogue.database;

import pl.kubie.catalogue.Functions.Comments;
import pl.kubie.catalogue.Functions.Rate;

/**
 * Created by Gladus on 28.05.2018.
 */
public class CreateNewMovie {

    private static void CreateNewMovie() {


        String title = userInput.getUserChoice("Please, enter movie Title: ");
        String comment = userInput.getUserChoice("Please add comment to movie ");
        Integer rate = movieService.returnRate();
        System.out.println("Please choose category of  this movie");
        movieService.showCategories();
        String category = movieService.returnCategory();
        Movie movie = new Movie(title, category);
        Comments commentObject = new Comments(comment, movie);
        Rate rateObject = new Rate(rate, movie);
        movieDatabase.save(movie);
        movieDatabase.saveComment(commentObject);
        movieDatabase.saveRate(rateObject);

    }
}
