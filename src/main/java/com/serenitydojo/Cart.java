package com.serenitydojo;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private Catalog catalog;

    List<CartItem> items = new ArrayList<>();

    public Cart(Catalog catalog) {
        this.catalog = catalog;
    }

    public int getNumberOfItems() {
        return items.size();
    }

    public void addItemToCart(Fruit fruit, double quantity) {
        //Add the fruit to the shopping cart
        items.add(new CartItem(fruit, quantity));
    }

    public double getRunningTotalSum() {
        //Gets the total fruits sum
        return items.stream().mapToDouble(item -> priceOf(item)).sum();
    }

    public double priceOf(CartItem item) {
        if (item.quantity() >= 5.0) {
            return catalog.getPriceOf(item.fruit()) * item.quantity() * 0.9;
        } else {
            return catalog.getPriceOf(item.fruit()) * item.quantity();
        }
    }

    public double getRunningTotalQuantityInKg() {
        return items.stream().mapToDouble(item -> item.quantity()).sum();
    }
}