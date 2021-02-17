package com.dev.cinema.service.mapper;

import com.dev.cinema.model.ShoppingCart;
import com.dev.cinema.model.Ticket;
import com.dev.cinema.model.dto.ShoppingCartDtoResponse;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartMapper {
    public ShoppingCartDtoResponse mapToDto(ShoppingCart shoppingCart) {
        ShoppingCartDtoResponse response = new ShoppingCartDtoResponse();
        response.setTicketIds(shoppingCart.getTickets().stream()
                .map(Ticket::getId)
                .collect(Collectors.toList()));
        response.setUserCartId(shoppingCart.getId());
        return response;
    }
}
