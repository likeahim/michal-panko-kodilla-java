package com.kodilla.good.patterns.challenges.order.contact;

import com.kodilla.good.patterns.challenges.order.Client;
import com.kodilla.good.patterns.challenges.order.services.Order;

public interface InformationService {
    void inform(Client client, Order order);

}
