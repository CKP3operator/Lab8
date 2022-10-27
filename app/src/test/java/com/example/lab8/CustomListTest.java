package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount(); //size of list before we add something
        City city1 = new City("Estevan","SK");
        list.addCity(city1);
        assertEquals(list.getCount(),listSize+1); //checks if list size increased
        assertTrue(list.hasCity(city1)); //checks if the added object is actually city1
        listSize = list.getCount(); //size of list before we add something
        City city2 = new City("Edmonton","AB");
        list.addCity(city2);
        assertEquals(list.getCount(),listSize + 1); //checks if list size increased
        assertTrue(list.hasCity(city2)); // checks if the added object is actually city2

    }
    @Test
    public void hasCityTest() {
        list = MockCityList();
        City city1 = new City("Edmonton","AB"); //city not to be added
        City city2 = new City("Estevan","SK"); //city to be added
        list.addCity(city2);
        assertTrue(list.hasCity(city2)); //checks if hasCity knows that list contains city2
        assertFalse(list.hasCity(city1)); //checks if hasCity know that list does not contain city1
    }
    @Test
    public void deleteCityTest(){
        list = MockCityList();
        City city1 =new City("Estevan","SK");
        City city2 = new City("Edmonton","AB");
        City city3 = new City("Toronto","ON");
        list.addCity(city1);
        list.addCity(city2);
        list.addCity(city3);
        int listSize = list.getCount();
        list.deleteCity(city3);
        assertEquals(list.getCount(),listSize - 1);
        assertFalse(list.hasCity(city3));
        listSize = list.getCount();
        list.deleteCity(city2);
        assertEquals(list.getCount(),listSize - 1);
        assertFalse(list.hasCity(city2));
    }

}
