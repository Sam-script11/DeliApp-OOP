package com.pluralsight.sandwich;

public abstract class Drink {
    protected String name;
    protected String size;
    protected double price;

    public Drink(String name, String size, double price) {
        this.name = name;
        this.size = size;
        this.price = price;
    }
}
