package pl.kubie.catalogue;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gladus on 04.02.2018.
 */
public class CreatingMovie {

    public List<Movie> Movies = new ArrayList<Movie>();

    public void AddMovieToCollection(Movie ExampleMovie) {
        Movies.add(ExampleMovie);
        System.out.println("Movie  added" + "\n");
    }

    public void DeleteMovie(Integer  Index) {
        Movies.remove(Index);
        System.out.println("Movie  deleted" + "\n");
    }
}
