package com.example.demo.mapper;

import com.example.demo.dto.MovieDto;
import com.example.demo.dto.UserDto;
import com.example.demo.model.Movie;
import com.example.demo.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class MovieMapper {

    public MovieDto movieEntityToDto(Movie movie){
        return MovieDto.builder()
                .id(movie.getId())
                .name(movie.getName())
                .genre(movie.getGenre())
                .year(movie.getYear())
                .build();
    }

    public List<MovieDto> movieListEntityToDto(List<Movie> movies){
        return movies.stream()
                .map(movie -> movieEntityToDto(movie))
                .toList();
    }

    public List<Movie> movieListDtoToEntity(List<MovieDto> movieDtos) {
        return movieDtos.stream()
                .map(this::movieDtoToEntity)
                .collect(Collectors.toList());
    }

    public Movie movieDtoToEntity(MovieDto movieDto){
        return Movie.builder()
                .id(movieDto.id())
                .name(movieDto.name())
                .genre(movieDto.genre())
                .year(movieDto.year())
                .build();
    }

}
