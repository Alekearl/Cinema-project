package com.dev.cinema.service.mapper;

import com.dev.cinema.model.Order;
import com.dev.cinema.model.Ticket;
import com.dev.cinema.model.dto.OrderDtoResponse;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {
    public OrderDtoResponse mapToDto(Order order) {
        OrderDtoResponse response = new OrderDtoResponse();
        response.setId(order.getId());
        response.setTicketsIds(order.getTickets().stream()
                .map(Ticket::getId)
                .collect(Collectors.toList()));
        response.setUserId(order.getUser().getId());
        response.setOrderDate(order.getOrderDate());
        return response;
    }
}
