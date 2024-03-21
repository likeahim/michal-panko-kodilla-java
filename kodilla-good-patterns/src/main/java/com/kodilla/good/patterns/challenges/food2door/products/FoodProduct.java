package com.kodilla.good.patterns.challenges.food2door.products;

import com.kodilla.good.patterns.challenges.food2door.producers.FoodProducer;

public interface FoodProduct {

    FoodProducer getProducer();
    int getQuantity();
}
