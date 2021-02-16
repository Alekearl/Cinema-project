package com.dev.cinema.service.mapper;

import com.dev.cinema.model.CinemaHall;
import com.dev.cinema.model.dto.CinemaHallDtoRequest;
import com.dev.cinema.model.dto.CinemaHallDtoResponse;
import org.springframework.stereotype.Component;

@Component
public class CinemaHallMapper {
    public CinemaHallDtoResponse mapToDto(CinemaHall cinemaHall) {
        CinemaHallDtoResponse response = new CinemaHallDtoResponse();
        response.setId(cinemaHall.getId());
        response.setCapacity(cinemaHall.getCapacity());
        response.setDescription(cinemaHall.getDescription());
        return response;
    }

    public CinemaHall mapFromDto(CinemaHallDtoRequest request) {
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setCapacity(request.getCapacity());
        cinemaHall.setDescription(request.getDescription());
        return cinemaHall;
    }
}
