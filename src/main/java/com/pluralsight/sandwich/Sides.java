package com.pluralsight.sandwich;

import java.util.ArrayList;
import java.util.List;

public class Sides extends MenuItem {
    List<String> chipsType = new ArrayList<>();
    ArrayList<String> drinkFlavors = new ArrayList<>();

    private String name;
    private double price;

    public Sides() {
        this.chipsType = chipsType;
        this.drinkFlavors = drinkFlavors;
        this.name = name;
        this.price = price;
    }

    public Sides(String name) {
        this.name = name;
        this.price = 1.50;
    }

    public void allSides(){
        chipsType.add("Lay's");
        chipsType.add("Doritos");
        chipsType.add("Pringles");
        chipsType.add("Ruffles");
        chipsType.add("Cheetos");


        drinkFlavors.add("Lemonade");
        drinkFlavors.add("Soda");
        drinkFlavors.add("Coffee");
        drinkFlavors.add("Sparkling Water");
        drinkFlavors.add("Smoothie");
        drinkFlavors.add("Milkshake");
        drinkFlavors.add("Fresh Juice");
    }


    public List<String> setChips(){
        return chipsType;
    }

    public List<String> setDrinkFlavors(){
        return drinkFlavors;
    }


    public void displayChips() {
        for (int i = 0; i < this.chipsType.size(); i++) {
            System.out.println(i + 1 + ")" + this.chipsType.get(i));
        }
    }

    public void displayDrink() {
        for (int i = 0; i < this.drinkFlavors.size(); i++) {
            System.out.println(i + 1 + ")" + this.drinkFlavors.get(i));
        }
    }
    @Override
    public void displayItem() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return
                "name='" + name + '\'' +
                ", price: $" + price;
    }

    @Override
    public double getPrice() {
        return price;
    }
}
