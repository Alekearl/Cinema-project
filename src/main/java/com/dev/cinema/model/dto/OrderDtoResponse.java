package com.dev.cinema.model.dto;

import java.util.List;

public class OrderDtoResponse {
    private Long id;
    private List<Long> ticketsIds;
    private LocalDateTime orderDate;
    private Long userId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Long> getTicketsIds() {
        return ticketsIds;
    }

    public void setTicketsIds(List<Long> ticketsIds) {
        this.ticketsIds = ticketsIds;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
