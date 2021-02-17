package com.dev.cinema.service.mapper;

import com.dev.cinema.model.User;
import com.dev.cinema.model.dto.UserDtoResponse;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserDtoResponse mapToDto(User user) {
        UserDtoResponse response = new UserDtoResponse();
        response.setId(user.getId());
        response.setEmail(user.getEmail());
        return response;
    }
}
