package com.kodilla.good.patterns.challenges.order;

import com.kodilla.good.patterns.challenges.order.contact.Address;
import com.kodilla.good.patterns.challenges.order.contact.ContactData;
import com.kodilla.good.patterns.challenges.order.products.Product;
import com.kodilla.good.patterns.challenges.order.services.Order;

import java.util.List;

public class Client {
    private String nickname;
    private String firstName;
    private String lastName;
    private int id;
    private Address address;
    private ContactData contactData;
    private List<Product> productsToBuy;
    private List<Order> orders;

    public Client(String nickname, String firstName, String lastName, ContactData contactData) {
        this.nickname = nickname;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactData = contactData;
    }

    public String getNickname() {
        return nickname;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getId() {
        return id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public ContactData getContactData() {
        return contactData;
    }

    public void setContactData(ContactData contactData) {
        this.contactData = contactData;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Product> getProductsToBuy() {
        return productsToBuy;
    }

    public void setProductsToBuy(List<Product> productsToBuy) {
        this.productsToBuy = productsToBuy;
    }
}
