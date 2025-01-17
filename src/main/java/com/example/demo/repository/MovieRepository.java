package com.example.demo.repository;

import com.example.demo.model.Movie;
import com.example.demo.model.Genre;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.List;
public interface MovieRepository extends JpaRepository<Movie, Integer>
{
    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH, attributePaths = {"genre"})
    Optional<Movie> findByName(String name);

    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH, attributePaths = {"genre"})
    List<Movie> findAll();

    List<Movie> findByGenre(Genre genre);

    List<Movie> findByYear(Integer year);

    boolean existsByName(String name);
}
