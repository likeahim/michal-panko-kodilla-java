package com.kodilla.good.patterns.challenges.order.contact;

import com.kodilla.good.patterns.challenges.order.Client;
import com.kodilla.good.patterns.challenges.order.ClientRepository;
import com.kodilla.good.patterns.challenges.order.services.Order;

public class SmsInformationService implements InformationService {

    private ClientRepository clientRepository;
    private Message message;
    @Override
    public void inform(Client client, Order order) {
        if (clientRepository.exist(client)) {
            sendMessage(client, order, message);
        }

    }

    public static void sendMessage(Client client, Order order, Message message) {
        System.out.println("Message:" + message.getMessage() + "\n " +
                           "sendet to " + client.getNickname() + "(" + client.getContactData().getPhoneNumber() + ") \n" +
                           "order: " + order.getNumber());
    }
}
