package com.pluralsight.sandwich;

import com.pluralsight.sandwich.Topping;

public class Premium implements Topping {
    private String name;
    private   double price;

    public Premium(String name, double price) {
        this.name = name;
        this.price = price;
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isPremium() {
        return true;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public double getCost() {
        return price;
    }
}

