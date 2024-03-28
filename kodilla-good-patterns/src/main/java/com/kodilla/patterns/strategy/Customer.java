package com.kodilla.patterns.strategy;

public sealed class Customer permits CorporateCustomer, IndividualYoungCustomer, IndividualCustomer {

    private final String name;
    protected BuyPredictor buyPredictor;

    public Customer(String name) {
        this.name = name;
    }

    public String predict() {
        return buyPredictor.predictWhatToBuy();
    }

    public String getName() {
        return name;
    }

    public void setBuyPredictor(BuyPredictor buyPredictor) {
        this.buyPredictor = buyPredictor;
    }
}
