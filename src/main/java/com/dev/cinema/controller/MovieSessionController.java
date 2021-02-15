package com.dev.cinema.controller;

import com.dev.cinema.model.MovieSession;
import com.dev.cinema.model.dto.MovieSessionDtoRequest;
import com.dev.cinema.model.dto.MovieSessionDtoResponse;
import com.dev.cinema.service.MovieSessionService;
import com.dev.cinema.service.mapper.MovieSessionMapper;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie-sessions")
public class MovieSessionController {
    private MovieSessionMapper movieSessionMapper;
    private MovieSessionService movieSessionService;

    @Autowired
    public MovieSessionController(MovieSessionMapper movieSessionMapper,
                                  MovieSessionService movieSessionService) {
        this.movieSessionMapper = movieSessionMapper;
        this.movieSessionService = movieSessionService;
    }

    @PostMapping
    public void create(@RequestBody MovieSessionDtoRequest request) {
        MovieSession movieSession = movieSessionMapper.mapFromDto(request);
        movieSessionService.add(movieSession);
    }

    @GetMapping("/available")
    public List<MovieSessionDtoResponse> getAvailable(@RequestParam Long id,
                                                      @RequestParam
                                                      @DateTimeFormat(pattern = "dd.MM.yyyy")
                                                              LocalDate date) {
        return movieSessionService.findAvailableSessions(id, date).stream()
                .map(movieSessionMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        movieSessionService.delete(id);
    }

    @PutMapping("/{id}")
    public void put(@PathVariable Long id, @RequestBody MovieSessionDtoRequest request) {
        MovieSession movieSession = movieSessionMapper.mapFromDto(request);
        movieSession.setId(id);
        movieSessionService.update(movieSession);
    }
}
