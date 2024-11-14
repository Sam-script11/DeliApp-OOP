package com.pluralsight.sandwich;

import java.util.ArrayList;
import java.util.List;

public class AllToppings {


    List<String> breadType = new ArrayList<>();
    List<String> meatType = new ArrayList<>();
    List<String> cheeseType = new ArrayList<>();
    List<String> veggies = new ArrayList<>();
    List<String> sauces = new ArrayList<>();
    public AllToppings() {
        breadType.add("white");
        breadType.add("wheat");
        breadType.add("rye");
        breadType.add("wrap");


        meatType.add("steak");
        meatType.add("ham");
        meatType.add("salami");
        meatType.add("roast beef");
        meatType.add("chicken");
        meatType.add("bacon");


        cheeseType.add("american");
        cheeseType.add("Provolone");
        cheeseType.add("Cheddar");
        cheeseType.add("Swiss");



        veggies.add("lettuce");
        veggies.add("peppers");
        veggies.add("onions");
        veggies.add("tomatoes");
        veggies.add("jalapenos");
        veggies.add("cucumbers");
        veggies.add("pickles");
        veggies.add("guacamole");
        veggies.add("mushrooms");


        sauces.add("Mayo");
        sauces.add("Mustard");
        sauces.add("ketchup");
        sauces.add("ranch");
        sauces.add("thousand islands");
        sauces.add("vinaigrette");
    }

    public List<String> getBreadType() {
        return breadType;
    }

    public List<String> getMeatType() {
        return meatType;
    }

    public List<String> getCheeseType() {
        return cheeseType;
    }

    public List<String> getVeggies() {
        return veggies;
    }

    public List<String> getSauces() {
        return sauces;
    }

    public void displayBread() {
        for (int i = 0; i < this.breadType.size(); i++) {
            System.out.println(i+1 + ")" + this.breadType.get(i));
        }
    }

    public void displayVeggies() {
        for (int i = 0; i < this.veggies.size(); i++) {
            System.out.println(i+1 + ")" + this.veggies.get(i));
        }
    }
    public void displaySauce(){
        for (int i = 0; i < this.sauces.size(); i++) {
            System.out.println(i+1 + ")" + this.sauces.get(i));
        }
    }

    public void displayProtein(){
        for (int i = 0; i<this.meatType.size(); i++){
            System.out.println(i+1 + ")" + this.meatType.get(i));

        }
    }
    public void dislayCheese(){
        for (int i = 0; i<this.cheeseType.size(); i++){
            System.out.println(i+1 + ")" + this.cheeseType.get(i));
        }
    }

}
