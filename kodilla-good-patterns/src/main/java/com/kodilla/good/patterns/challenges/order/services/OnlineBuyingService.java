package com.kodilla.good.patterns.challenges.order.services;

import com.kodilla.good.patterns.challenges.order.Client;
import com.kodilla.good.patterns.challenges.order.products.Product;
import com.kodilla.good.patterns.challenges.order.products.ProductWarehouse;
import com.kodilla.good.patterns.challenges.order.contact.MailInformationService;
import com.kodilla.good.patterns.challenges.order.contact.Message;

import java.time.LocalDate;
import java.util.List;

public class OnlineBuyingService implements BuyingService {
    private Client client;
    private Order order;
    private Message message;
    private boolean isDone;

    public OnlineBuyingService(Client client, Order order) {
        this.client = client;
        this.order = order;
    }

    @Override
    public boolean orderProcessing() {
            return finishOrder(client);
    }

    @Override
    public boolean makeAnOrder(Client client) {
        List<Product> list = client.getProductsToBuy().stream()
                .filter(p -> ProductWarehouse.getProductsList().contains(p))
                .toList();
        if (!list.isEmpty()) {
            double sum = list.stream()
                    .mapToDouble(p -> p.getPrice())
                    .sum();
            order = new Order(list, createOrderNumber(), sum);
            client.getOrders().add(order);
            return true;
        }
        return false;
    }

    @Override
    public boolean finishOrder(Client client) {
        if (makeAnOrder(client)) {
            if (!order.isPaid()) {
                MailInformationService.sendMessage(client, order, Message.ASK_FOR_PAY);
                order.setSuccess(false);
                return false;
            } else {
                order.setSuccess(true);
                MailInformationService.sendMessage(client, order, Message.ORDER_SUCCESS);
                isDone = true;
                return true;
            }
        }
        return false;
    }

    @Override
    public long createOrderNumber() {
        return (long) LocalDate.now().getDayOfYear() * client.getId();
    }

    @Override
    public Client getClient() {
        return client;
    }

    @Override
    public Order getOrder() {
        return order;
    }
}
