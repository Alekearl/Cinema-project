package com.dev.cinema.model.dto;

public class CinemaHallDtoRequest {
    private Integer capacity;
    private String description;

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
