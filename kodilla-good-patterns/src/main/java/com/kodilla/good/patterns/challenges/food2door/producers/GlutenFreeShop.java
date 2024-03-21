package com.kodilla.good.patterns.challenges.food2door.producers;

import com.kodilla.good.patterns.challenges.food2door.products.FoodProduct;

import java.util.HashMap;
import java.util.Map;

public class GlutenFreeShop implements FoodProducer {


    private String name;
    private Map<FoodProduct, Integer> menu;

    public GlutenFreeShop(String name, Map<FoodProduct, Integer> menu) {
        this.name = name;
        this.menu = new HashMap<>(menu);
    }

    @Override
    public boolean process(FoodProduct product, int amount) {
        return menu.containsKey(product) && menu.get(product) >= amount;
    }

    @Override
    public String getName() {
        return null;
    }

    public void addProduct(FoodProduct product, int addedAmount) {
        menu.put(product, addedAmount);
    }

    public boolean removeProduct(FoodProduct product, int amount) {
        return menu.remove(product, amount);
    }
}
