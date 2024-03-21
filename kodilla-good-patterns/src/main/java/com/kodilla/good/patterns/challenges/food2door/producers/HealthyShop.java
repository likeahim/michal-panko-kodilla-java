package com.kodilla.good.patterns.challenges.food2door.producers;

import com.kodilla.good.patterns.challenges.food2door.products.FoodProduct;

import java.util.ArrayList;
import java.util.List;

public class HealthyShop implements FoodProducer {

    private String name;
    private List<FoodProduct> menu;

    public HealthyShop(String name, List<FoodProduct> menu) {
        this.name = name;
        this.menu = new ArrayList<>(menu);
    }

    @Override
    public boolean process(FoodProduct product, int amount) {
        return menu.contains(product);
    }

    @Override
    public String getName() {
        return name;
    }

    public boolean addProductToMenu(FoodProduct product) {
        return menu.add(product);
    }

    public boolean removeProductFromMenu(FoodProduct product) {
        return menu.remove(product);
    }
}
