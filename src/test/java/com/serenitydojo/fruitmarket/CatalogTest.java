package com.serenitydojo.fruitmarket;

import com.serenitydojo.Catalog;
import com.serenitydojo.FruitUnavailableException;
import org.junit.Test;

import static com.serenitydojo.Fruit.*;
import static org.assertj.core.api.Assertions.assertThat;

public class CatalogTest {

    //You can update the catalog with the current market price of a fruit
    @Test
    public void shouldBeAbleToUpdateTheCurrentPriceOfAFruit() {
        Catalog catalog = new Catalog();

        catalog.setPriceOf(APPLE, 4.00);
        catalog.setPriceOf(ORANGE, 5.50);
        catalog.setPriceOf(BANANA, 6.00);
        catalog.setPriceOf(PEAR, 4.50);

        double priceOfApples = catalog.getPriceOf(APPLE);
        double priceOfOrange = catalog.getPriceOf(ORANGE);
        double priceOfBanana = catalog.getPriceOf(BANANA);
        double priceOfPear = catalog.getPriceOf(PEAR);

        assertThat(priceOfApples).isEqualTo(4.00);
        assertThat(priceOfOrange).isEqualTo(5.50);
        assertThat(priceOfBanana).isEqualTo(6.00);
        assertThat(priceOfPear).isEqualTo(4.50);
    }

    //The Catalog should list the names of the currently available fruit in alphabetical order
    @Test
    public void shouldListAvailableFruitsAlphabetically() {
        Catalog catalog = new Catalog();

        catalog.setPriceOf(APPLE, 4.00);
        catalog.setPriceOf(PEAR, 4.50);
        catalog.setPriceOf(ORANGE, 5.50);
        catalog.setPriceOf(BANANA, 6.00);

        catalog.sortFruitsByName();

        assertThat(catalog.getSortedListOfProducts()).containsExactly(APPLE.toString(),
                BANANA.toString(), ORANGE.toString(), PEAR.toString());
    }

    //The Catalog should throw a FruitUnavailableException if the fruit is not currently available
    @Test(expected = FruitUnavailableException.class)
    public void shouldThrowExceptionIfFruitIsUnavailable() {
        Catalog catalog = new Catalog();

        catalog.setPriceOf(APPLE, 4.00);
        catalog.setPriceOf(PEAR, 4.50);
        catalog.setPriceOf(ORANGE, 5.50);
        catalog.setPriceOf(BANANA, 6.00);

        double priceOfCherry = catalog.getPriceOf(CHERRY);

        assertThat(priceOfCherry).isEqualTo(null);
    }
}
