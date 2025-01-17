package com.example.demo.service;

import com.example.demo.dto.MovieDto;
import com.example.demo.mapper.MovieMapper;
import com.example.demo.model.Genre;
import com.example.demo.model.Movie;
import com.example.demo.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService{

    private final MovieRepository movieRepository;

    private final MovieMapper movieMapper;

    @Override
    public MovieDto getMovieById(Integer id) {
        return movieMapper.movieEntityToDto(movieRepository.findById(id).orElse(null));
    }

    @Override
    public List<MovieDto> getAllMovies() {
        return movieMapper.movieListEntityToDto(movieRepository.findAll());
    }

    @Override
    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }



    @Override
    public Movie updateMovie(MovieDto movieDto) {

        return movieRepository.save(movieMapper.movieDtoToEntity(movieDto));
    }

    @Override
    public void deleteMovie(Movie movie) {
        movieRepository.delete(movie);
    }

    @Override
    public void deleteMovieById(Integer id) {
        movieRepository.deleteById(id);
    }

    @Override
    public List<MovieDto> getMoviesByGenre(Genre genre) {
        return movieMapper.movieListEntityToDto(movieRepository.findByGenre(genre));
    }

    @Override
    public List<MovieDto> getMoviesByYear(Integer year) {
        return movieMapper.movieListEntityToDto(movieRepository.findByYear(year));
    }

    @Override
    public boolean checkMovieExistsByName(String name) {
        return movieRepository.existsByName(name);
    }

}
