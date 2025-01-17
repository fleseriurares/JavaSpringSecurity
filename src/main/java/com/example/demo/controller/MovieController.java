package com.example.demo.controller;

import com.example.demo.dto.MovieDto;
import com.example.demo.dto.UserDto;
import com.example.demo.model.Genre;
import com.example.demo.model.Movie;
import com.example.demo.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping({"movies", "/movies/"})
public class MovieController {

    @Autowired
    private final MovieService movieService;

    @GetMapping("/create")
    public String displayCreateMovieForm(Model model) {
        model.addAttribute("title", "Create Movie");
        model.addAttribute("movie", new Movie());
        model.addAttribute("genres", Genre.values());
        return "create";
    }

    @PostMapping("/create")
    public String processCreateMovieForm(@ModelAttribute Movie movie, Errors errors, Model model ){
        System.out.println("OkAtentie");
        if (errors.hasErrors()) {
            model.addAttribute("genres", Genre.values());
            return "redirect:/movies";
        }


        movieService.createMovie(movie);

        return "redirect:/movies";
    }

    @GetMapping
    public String getMovies(Model model){
        List<MovieDto> movieDtos = movieService.getAllMovies();
        model.addAttribute("title", "Movies");
        model.addAttribute("movies", movieDtos);
        return "movies";
    }

    @GetMapping("/deleteMovie")
    public String displayDeleteMovieForm(Model model){
        model.addAttribute("title", "Delete Events");
        model.addAttribute("movies", movieService.getAllMovies());
        return "deleteMovie";

    }

    @PostMapping("/deleteMovie")
    public String processDeleteMoviesForm(@RequestParam(required = false) int[] movieIds){
        if(movieIds != null) {
            for (int id : movieIds) {
                movieService.deleteMovieById(id);
            }
            System.out.println("Daaaa");
        }
        System.out.println("Nuuu");
        return "redirect:";
    }

    @GetMapping("/editMovie/{id}")
    public String displayEditMovieForm(@PathVariable Integer id, Model model) {
        MovieDto movieDto = movieService.getMovieById(id);

        if (movieDto == null) {
            model.addAttribute("deletionStatus", "Failed");
            return "redirect:/movies";
        }

        model.addAttribute("title", "Edit Movie");
        model.addAttribute("movie", movieDto);
        model.addAttribute("genres", Genre.values());
        return "editMovie";
    }

    @PostMapping("/editMovie/{id}")
    public String processEditMovieForm(@PathVariable Integer id, @ModelAttribute MovieDto movieDto, Model model) {
            movieService.updateMovie(movieDto);
        return "redirect:/movies";
    }


    @GetMapping("/movies/{id}")
    public MovieDto getMovieById(@PathVariable Integer id){
        return movieService.getMovieById(id);
    }




}
