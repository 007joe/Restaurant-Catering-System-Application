package com.techelevator;

import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import java.util.HashMap;
import java.util.TreeMap;

import static org.hamcrest.CoreMatchers.equalTo;
//import static org.hamcrest.Matchers.hasEntry;
import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class CateringInventoryTests {
    CateringInventory cateringInventory = new CateringInventory();

    @Test
    public void decrement_inventory_test() {
        TreeMap<String, MenuItem> inventory = cateringInventory.getInventory();
        inventory.get("E4").setQuantity(25);
        cateringInventory.decrementInventory(inventory, "E4");
       assertEquals(24, inventory.get("E4").getQuantity());

    }
}
