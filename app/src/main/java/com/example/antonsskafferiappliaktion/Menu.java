package com.example.antonsskafferiappliaktion;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    //private final Object Dish;
    private List<Dish> dishes = new ArrayList<Dish>();


    public void addFood(Dish food) {
        dishes.add(food);
    }


    public Dish getTheFoodsAtPos(int i) {
        return dishes.get(i);
    }

    public Menu() {
        Dish dish1 = new Dish();
        Dish dish2 = new Dish();
        Dish dish3 = new Dish();
        Dish dish4 = new Dish();
        Dish dish5 = new Dish();
        dish1.setName("test");
        dish2.setName("testing");
        dish3.setName("lesting");
        dish4.setName("festing");
        dish5.setName("kesting");

        addFood(dish1);
        addFood(dish2);
        addFood(dish3);
        addFood(dish4);
        addFood(dish5);
    }


}
