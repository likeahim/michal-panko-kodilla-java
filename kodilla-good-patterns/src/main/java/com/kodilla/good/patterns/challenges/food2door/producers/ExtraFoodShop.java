package com.kodilla.good.patterns.challenges.food2door.producers;

import com.kodilla.good.patterns.challenges.food2door.products.FoodProduct;

import java.util.HashMap;
import java.util.Map;

public class ExtraFoodShop implements FoodProducer {

    private String name;
    private Map<FoodProduct, Integer> menu;

    public ExtraFoodShop(String name, Map<FoodProduct, Integer> menu) {
        this.name = name;
        this.menu = new HashMap<>(menu);
    }

    @Override
    public boolean process(FoodProduct product, int amount) {
        Integer inStore = menu.get(product);
        if (menu.containsKey(product) && inStore > 0) {
            if (inStore >= amount) {
                menu.put(product, inStore - amount);
                removeProduct(product, inStore);
                return true;
            } else {
                amount = UserInput.putOtherAmount(inStore);
                return process(product, amount);
            }
        }
        return false;
    }

    @Override
    public String getName() {
        return name;
    }

    public void addProduct(FoodProduct product, int addedAmount) {
        menu.put(product, addedAmount);
    }

    public boolean removeProduct(FoodProduct product, int amount) {
        return menu.remove(product, amount);
    }
}
