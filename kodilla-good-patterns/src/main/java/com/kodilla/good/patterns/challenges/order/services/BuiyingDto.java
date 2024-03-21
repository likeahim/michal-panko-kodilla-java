package com.kodilla.good.patterns.challenges.order.services;

import com.kodilla.good.patterns.challenges.order.Client;

public class BuiyingDto {

    private Client client;
    private Order order;
    boolean successful;

    public BuiyingDto(boolean successful) {
        this.successful = successful;
    }

    public void setData(Client client, Order order) {
        this.client = client;
        this.order = order;
    }
}
