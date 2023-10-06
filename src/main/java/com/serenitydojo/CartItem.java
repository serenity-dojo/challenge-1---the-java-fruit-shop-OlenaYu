package com.serenitydojo;

public class CartItem {
    public Fruit fruit;
    public double quantity;

    public CartItem(Fruit fruit, double quantity) {
        this.fruit = fruit;
        this.quantity = quantity;

    }
    public double quantity() {
        return quantity;
    }
    public Fruit fruit() {
        return fruit;
    }
}