package com.MoviesLibrary.movies.controller;

import com.MoviesLibrary.movies.exception.MovieNotFoundException;
import com.MoviesLibrary.movies.model.Movies;
import com.MoviesLibrary.movies.repository.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping
public class MoviesController {

    @Autowired
    MoviesRepository moviesRepository;

    @GetMapping("/movies")
    public List<Movies> getAllNotes(){
        return moviesRepository.findAll();
    }

    @PostMapping("/movies")
    public Movies createNote(@RequestBody Movies movies){
        return moviesRepository.save(movies);
    }

    @GetMapping("/movies/{id}")
    public Movies updateNote(@PathVariable(value = "id") Integer id) throws MovieNotFoundException {
        return moviesRepository.findById(id)
                .orElseThrow(() -> new MovieNotFoundException("Movie with id:" + id + " was not found"));

    }

    @PutMapping("/movies/{id}")
    public Movies updateNote(@PathVariable(value = "id") Integer id,
                             @RequestBody Movies movieDetails) throws MovieNotFoundException {
        Movies movies = moviesRepository.findById(id)
                .orElseThrow(() -> new MovieNotFoundException("Movie with id:" + id + " was not found"));
        movies.setName(movieDetails.getName());
        movies.setYear(movieDetails.getYear());
        movies.setGenres(movieDetails.getGenres());
        movies.setDirected_by(movieDetails.getDirected_by());
        movies.setTop_cast(movieDetails.getTop_cast());

        Movies updateMovie = moviesRepository.save(movies);
        return updateMovie;

    }

    @DeleteMapping("/movies/{id}")
    public ResponseEntity<?> deleteMovie(@PathVariable(value = "id") Integer id) throws MovieNotFoundException{
        Movies movies = moviesRepository.findById(id)
                .orElseThrow(() -> new MovieNotFoundException("Movie with id:" + id + " was not found"));
         moviesRepository.delete(movies);
         return ResponseEntity.ok().build();

    }




    }

