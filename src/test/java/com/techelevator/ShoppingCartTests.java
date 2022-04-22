package com.techelevator;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.TreeMap;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class ShoppingCartTests {
    //instantiate test prerequisites
    ShoppingCart shoppingCart = new ShoppingCart();

    //test to see if customer adds item, one shows up in cart
    @Test
    public void add_item_once_test() {
        shoppingCart.addItem("A2");
        int quantity = 1;
        assertEquals(quantity, shoppingCart.getCart().get("A2").getQuantity());
    }

    //test to see if customer adds two items, two show up in the cart
    @Test
    public void add_item_twice_test() {
        shoppingCart.addItem("A2");
        shoppingCart.addItem("A2");
        int quantity = 2;
        assertEquals(quantity, shoppingCart.getCart().get("A2").getQuantity());
    }

    //test to see if cart doesn't increment when customer adds three
    @Test
    public void add_item_thrice_test() {
        shoppingCart.addItem("A2");
        shoppingCart.addItem("A2");
        shoppingCart.addItem("A2");
        int quantity = 3;
        assertEquals(quantity, shoppingCart.getCart().get("A2").getQuantity());
    }

    @Test
    public void calculate_total_test() {
        TreeMap<String, MenuItem> cart = new TreeMap<>();
        shoppingCart.addItem("D5");
        shoppingCart.addItem("A1");
        shoppingCart.addItem("B1");
        shoppingCart.addItem("D5");
        double total = 10.00;
        assertEquals(total, shoppingCart.calculateTotal(shoppingCart.getCart()), 0);
    }
}
