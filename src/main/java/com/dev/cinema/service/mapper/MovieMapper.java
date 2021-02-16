package com.dev.cinema.service.mapper;

import com.dev.cinema.model.Movie;
import com.dev.cinema.model.dto.MovieDtoRequest;
import com.dev.cinema.model.dto.MovieDtoResponse;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper {
    public MovieDtoResponse mapToDto(Movie movie) {
        MovieDtoResponse response = new MovieDtoResponse();
        response.setId(movie.getId());
        response.setTitle(movie.getTitle());
        response.setDescription(movie.getDescription());
        return response;
    }

    public Movie mapFromDto(MovieDtoRequest request) {
        Movie movie = new Movie();
        movie.setTitle(request.getTitle());
        movie.setDescription(request.getDescription());
        return movie;
    }
}
