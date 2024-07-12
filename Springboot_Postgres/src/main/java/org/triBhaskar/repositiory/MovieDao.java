package org.triBhaskar.repositiory;

import org.triBhaskar.model.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieDao {
    List<Movie> selectMovies();
    int insertMovie(Movie movie);
    int deleteMovie(int id);
    Optional<Movie> selectMovieById(int id);
    // TODO: Update
}
