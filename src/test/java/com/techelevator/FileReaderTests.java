package com.techelevator;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import java.util.Map;
import static org.junit.Assert.*;
import java.util.TreeMap;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FileReaderTests {

    @Test
    public void validate_map_test() {
        //instantiate Object with method to be tested
        FileReader fileReader = new FileReader();
        //create testMap to populate expecteds
        Map<String, MenuItem> testMap = new TreeMap<>();
        MenuItem menuItem1 = new Beverage("B", "B1", "Soda",
                "Don't forget ice!", 25,1.50);
        MenuItem menuItem2 = new Dessert("D", "D5", "Apple Pie",
                "Coffee goes with dessert (just saying.)", 0,2.50);
        MenuItem menuItem3 = new Entree("E", "E3", "BBQ Ribs",
                "Did you remember dessert?", 0,11.65);
        MenuItem menuItem4 = new Appetizer("A", "A2", "Meatballs",
                "You might need extra plates!", 0,2.95);

        //put objects into map
        testMap.put("B1",menuItem1);
        testMap.put("D5", menuItem2);
        testMap.put("E3", menuItem3);
        testMap.put("A2", menuItem4);


        //test if map is null or not
        assertNotNull("testMap", testMap);
        //test product desc
        assertEquals("Soda", fileReader.getMenuItems().get("B1").getProductDescription());
        //test product name
        assertEquals("B", fileReader.getMenuItems().get("B1").getProductName());
        //test product code
        assertEquals("B1", fileReader.getMenuItems().get("B1").getProductCode());
        //test product price
        assertEquals(1.50, fileReader.getMenuItems().get("B1").getProductPrice(), 0);
        //test quantity
        assertEquals(25, fileReader.getMenuItems().get("B1").getQuantity());
        //test upsaleMessage
        assertEquals("Don't forget ice!", fileReader.getMenuItems().get("B1").getUpsaleMessage());

        //test sold out
        assertEquals(0,testMap.get("D5").getQuantity());
    }
}
