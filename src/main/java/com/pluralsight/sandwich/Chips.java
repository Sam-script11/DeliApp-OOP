package com.pluralsight.sandwich;

public class Chips extends MenuItem {
    // list of sides
    private String name;
    private double price;

    public Chips(String name) {
        this.name = name;
        this.price = 1.50;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public void displayItem() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Chips{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
