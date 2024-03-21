package com.kodilla.good.patterns.challenges.food2door.producers;

import com.kodilla.good.patterns.challenges.food2door.products.FoodProduct;

public interface FoodProducer {

    boolean process(FoodProduct product, int amount);
    String getName();
}
