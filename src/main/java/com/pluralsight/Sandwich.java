package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public abstract class Sandwich implements Topping{
   private int size;
   private String breadType;
   private boolean isToasted;
   private List<Topping> toppings = new ArrayList<>();

    public Sandwich(String breadType, int size ,  boolean isToasted) {
        this.size = size;
        this.breadType = breadType;
        this.isToasted = isToasted;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getBreadType() {
        return breadType;
    }

    public void setBreadType(String breadType) {
        this.breadType = breadType;
    }

    public boolean isToasted() {
        return isToasted;
    }

    public void setToasted(boolean toasted) {
        isToasted = toasted;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public void setToppings(List<Topping> toppings) {
        this.toppings = toppings;
    }

    public  abstract void addTopings(Topping topping);

    public abstract void removeTopping(Topping topping);

    public abstract void calculateCost();
}
