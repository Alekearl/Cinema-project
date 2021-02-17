package com.dev.cinema.model.dto;

import java.util.List;

public class ShoppingCartDtoResponse {
    private List<Long> ticketIds;
    private Long userCartId;

    public List<Long> getTicketIds() {
        return ticketIds;
    }

    public void setTicketIds(List<Long> ticketIds) {
        this.ticketIds = ticketIds;
    }

    public Long getUserCartId() {
        return userCartId;
    }

    public void setUserCartId(Long userCartId) {
        this.userCartId = userCartId;
    }
}
