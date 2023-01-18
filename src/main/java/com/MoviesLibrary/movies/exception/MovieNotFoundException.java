package com.MoviesLibrary.movies.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class MovieNotFoundException extends RuntimeException{

    public MovieNotFoundException(String message){
        super(String.valueOf(message));
    }


}
