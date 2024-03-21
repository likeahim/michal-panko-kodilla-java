package com.kodilla.good.patterns.challenges.order.services;

import com.kodilla.good.patterns.challenges.order.products.Product;

import java.util.List;

public class Order {
    private List<Product> products;
    private long number;
    private double price;
    private boolean isPaid, isSuccess, isClosed;

    public Order(List<Product> products, long number, double price) {
        this.products = products;
        this.number = number;
        this.price = price;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed(boolean closed) {
        isClosed = closed;
    }
}
