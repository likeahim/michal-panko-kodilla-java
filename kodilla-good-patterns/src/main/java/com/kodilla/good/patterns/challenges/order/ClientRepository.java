package com.kodilla.good.patterns.challenges.order;

import java.util.ArrayList;
import java.util.List;

public class ClientRepository {

    private List<Client> clientsBase = new ArrayList<>();

    boolean addClient(Client client) {
        return clientsBase.add(client);
    }

    boolean removeClient(Client client) {
        return clientsBase.remove(client);
    }

    boolean exist(Client client) {
        return clientsBase.contains(client);
    }

    public List<Client> getClientsBase() {
        return clientsBase;
    }
}
