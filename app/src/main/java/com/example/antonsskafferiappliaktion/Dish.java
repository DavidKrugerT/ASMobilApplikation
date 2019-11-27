package com.example.antonsskafferiappliaktion;

import androidx.annotation.NonNull;

public class Dish {
    String name;
    String price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }


    @NonNull
    @Override
    public String toString() {
        return this.name + ", " +this.price;
    }
}
