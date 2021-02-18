package com.dev.cinema.model.dto;

import javax.validation.constraints.NotNull;

public class MovieDtoRequest {
    @NotNull
    private String title;
    @NotNull
    private String description;

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
