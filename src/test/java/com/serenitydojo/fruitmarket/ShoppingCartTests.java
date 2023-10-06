package com.serenitydojo.fruitmarket;

import com.serenitydojo.Cart;
import com.serenitydojo.Catalog;
import org.junit.Before;
import org.junit.Test;

import static com.serenitydojo.Fruit.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class ShoppingCartTests {

    Catalog catalog = new Catalog();
    Cart cart = new Cart(catalog);

    @Before
    public void setUpTheCatalog() {

        catalog.setPriceOf(APPLE, 4.00);
        catalog.setPriceOf(ORANGE, 5.50);
        catalog.setPriceOf(BANANA, 6.00);
        catalog.setPriceOf(PEAR, 4.50);
        catalog.setPriceOf(CHERRY, 3.00);
    }

    @Test
    public void theCartShouldBeInitiallyBeEmpty() {

        Cart cart = new Cart(catalog);

        int numberOfCatalogItems = cart.getNumberOfItems();

        assertThat(numberOfCatalogItems).isEqualTo(0);

    }

    //A single item should be added to the shopping cart
    @Test
    public void shouldBeAbleToAddSingleItemToTheCart() {

        cart.addItemToCart(APPLE, 2.0);

        int numberOfItems = cart.getNumberOfItems();

        assertThat(numberOfItems).isEqualTo(1);

    }

    //Several items should be added to the shopping cart
    @Test
    public void shouldBeAbleToAddSeveralItemsToTheCart() {

        cart.addItemToCart(APPLE, 2.0);
        cart.addItemToCart(PEAR, 6.0);

        int numberOfItems = cart.getNumberOfItems();

        assertThat(numberOfItems).isEqualTo(2);

    }

    //You can add items to your shopping cart, which should keep a running total.
    @Test
    public void shouldKeepARunningTotalSum() {

        cart.addItemToCart(APPLE, 2.0);
        cart.addItemToCart(PEAR, 6.0);
        cart.addItemToCart(BANANA, 12);

        double runningTotal = cart.getRunningTotalSum();

        assertThat(runningTotal).isEqualTo(97.1);

    }

    //You need to see the total quantity (kg) of fruits  in the cart
    @Test
    public void shouldKeepARunningTotalQuantityInKg() {
        cart.addItemToCart(APPLE, 2.0);
        cart.addItemToCart(PEAR, 6.0);
        cart.addItemToCart(BANANA, 3);

        double runningTotalQuantity = cart.getRunningTotalQuantityInKg();

        assertThat(runningTotalQuantity).isEqualTo(11);

    }

    //When you buy 5 kilos or more of any fruit, you get a 10% discount.
    @Test
    public void shouldProvideTenPercentOfDiscountForFiveKg() {
        cart.addItemToCart(BANANA, 5);

        double runningTotal = cart.getRunningTotalSum();

        assertThat(runningTotal).isEqualTo(27);

    }

    //When you buy 5 kilos or more of several fruits, you get a 10% discount.
    @Test
    public void shouldProvideTenPercentOfDiscountForFiveKgOfSeveralFruits() {

        cart.addItemToCart(BANANA, 5);
        cart.addItemToCart(APPLE, 1);

        double runningTotal = cart.getRunningTotalSum();

        assertThat(runningTotal).isEqualTo(31);

    }

    //When you buy less than 5 kilos of any fruit, you do NOT get the discount.
    @Test
    public void shouldNotProvideDiscountForLessThan5Kg() {
        cart.addItemToCart(CHERRY, 4.99);

        double runningTotal = cart.getRunningTotalSum();

        assertThat(runningTotal).isEqualTo(14.97);

    }

}
