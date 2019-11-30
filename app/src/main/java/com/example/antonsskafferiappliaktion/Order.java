package com.example.antonsskafferiappliaktion;

import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class Order {
    private List<Dish> dishes = new ArrayList<>();
    int bordsNummer;

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dish) {
        this.dishes = dish;
    }

    public int getBordsNummer() {
        return bordsNummer;
    }

    public void setBordsNummer(int bordsNummer) {
        this.bordsNummer = bordsNummer;
    }

    public void addDish(Dish dish) {
        dishes.add(dish);
    }
}
