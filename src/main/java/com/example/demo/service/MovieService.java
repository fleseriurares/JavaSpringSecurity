package com.example.demo.service;


import com.example.demo.dto.MovieDto;
import com.example.demo.model.Genre;
import com.example.demo.model.Movie;

import java.util.List;

public interface MovieService {

    boolean checkMovieExistsByName(String name);

    MovieDto getMovieById(Integer id);

    List<MovieDto> getAllMovies();

    List<MovieDto> getMoviesByGenre(Genre genre);

    List<MovieDto> getMoviesByYear(Integer year);

    Movie createMovie(Movie movie);

    Movie updateMovie(MovieDto movieDto);

    void deleteMovie(Movie movie);
    void deleteMovieById(Integer id);
}
