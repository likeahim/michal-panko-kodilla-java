package com.kodilla.good.patterns.challenges.food2door.products;

import com.kodilla.good.patterns.challenges.food2door.producers.FoodProducer;

public class Sausage implements FoodProduct {

    private String name = "Sausage";
    private int amountInShop;
    private FoodProducer producer;

    @Override
    public FoodProducer getProducer() {
        return producer;
    }

    @Override
    public int getQuantity() {
        return amountInShop;
    }
}
