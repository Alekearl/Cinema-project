package com.dev.cinema.service.mapper;

import com.dev.cinema.model.MovieSession;
import com.dev.cinema.model.dto.MovieSessionDtoRequest;
import com.dev.cinema.model.dto.MovieSessionDtoResponse;
import com.dev.cinema.service.CinemaHallService;
import com.dev.cinema.service.MovieService;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MovieSessionMapper {
    private CinemaHallService cinemaHallService;
    private MovieService movieService;

    @Autowired
    public MovieSessionMapper(CinemaHallService cinemaHallService, MovieService movieService) {
        this.cinemaHallService = cinemaHallService;
        this.movieService = movieService;
    }

    public MovieSessionDtoResponse mapToDto(MovieSession movieSession) {
        MovieSessionDtoResponse response = new MovieSessionDtoResponse();
        response.setId(movieSession.getId());
        response.setMovieTitle(movieSession.getMovie().getTitle());
        response.setShowTime(movieSession.getShowTime().toString());
        response.setCinemaHallId(movieSession.getCinemaHall().getId());
        return response;
    }

    public MovieSession mapFromDto(MovieSessionDtoRequest request) {
        MovieSession movieSession = new MovieSession();
        movieSession.setMovie(movieService.get(request.getMovieId()));
        movieSession.setCinemaHall(cinemaHallService.get(request.getCinemaHallId()));
        movieSession.setShowTime(LocalDateTime.parse(request.getShowTime(),
                DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        return movieSession;
    }
}
