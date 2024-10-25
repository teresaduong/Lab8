package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;
    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size
     plus one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    @Test
    public void hasCityTest(){
        list = MockCityList();
        City city = new City("Estevan", "SK");
        list.addCity(city);
        assertTrue(list.hasCity(city));
    }

    @Test
    public void deleteCityTest(){
        list = MockCityList();
        City city = new City("Estevan", "SK");
        list.addCity(city);
        // Check if a city is present in the list
        assertTrue(list.hasCity(city));

        // If it does then delete it from the list
        list.deleteCity(city);

        // Test to see if it was actually deleted
        assertFalse(list.hasCity(city));
        assertEquals(0, list.getCount());
    }

    @Test
    public void countCityTest(){
        list = MockCityList();
        assertEquals(0, list.getCount());

        // Add a new city and check the updated count
        City city = new City("Estevan", "SK");
        list.addCity(city);
        assertEquals(1, list.getCount());

        // Delete a city and check the updated count
        list.deleteCity(city);
        assertEquals(0, list.getCount());

    }
}
