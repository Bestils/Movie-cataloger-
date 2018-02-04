package pl.kubie.catalogue;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by Gladus on 04.02.2018.
 */
public class MovieDatabase {

    private List<Movie> movies = new ArrayList<>();

    public void save(Movie movie) {

        movies.add(movie);
    }

    public List<Movie> findall() {
        return movies;

    }
    public  void  remove(Integer index){

        movies.remove(index);
    }
  public Movie findById(int id){
        return movies.stream()
                .filter(f ->f.getId()==id)
                .findAny()
                .orElseThrow(NoSuchElementException::new);

  }

}
