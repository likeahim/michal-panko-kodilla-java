package com.kodilla.good.patterns.challenges.order.services;

import com.kodilla.good.patterns.challenges.order.Client;

public interface BuyingService {
    boolean orderProcessing();
    boolean makeAnOrder(Client client);
    boolean finishOrder(Client client);

    long createOrderNumber();

    Client getClient();
    Order getOrder();
}
