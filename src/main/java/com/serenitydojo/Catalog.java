package com.serenitydojo;

import java.util.*;

public class Catalog {

    private Map<String, Double> fruitWithPrice = new HashMap<>();

    public void setPriceOf(Fruit fruit, double price) {

        fruitWithPrice.put(fruit.name(), price);
    }

    public double getPriceOf(Fruit fruit) {

        if (!fruitWithPrice.containsKey(fruit.name())) {

            throw new FruitUnavailableException("We're sorry, the " + fruit + " is unavailable");
        }
        return fruitWithPrice.get(fruit.name());
    }

    public void sortFruitsByName() {

        TreeMap<String, Double> fruitWithPriceSorted = new TreeMap<>();

        fruitWithPriceSorted.putAll(fruitWithPrice);

        for (Map.Entry<String, Double> newMap : fruitWithPriceSorted.entrySet())

            System.out.println("Key = " + newMap.getKey() + ", Value = " + newMap.getValue());
    }

    public List<String> getSortedListOfProducts() {

        return fruitWithPrice.keySet().stream().sorted().toList();
    }
}

