package com.kodilla.good.patterns.challenges.order.products;

import java.util.ArrayList;
import java.util.List;

public class ProductWarehouse {

    private static List<Product> productsList = new ArrayList<>();

    public static boolean addProduct(Product product) {
        return productsList.add(product);
    }

    public static boolean removeProduct(Product product) {
        return productsList.remove(product);
    }

    public static List<Product> getProductsList() {
        return productsList;
    }
}
