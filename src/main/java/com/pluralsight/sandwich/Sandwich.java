package com.pluralsight.sandwich;

public abstract class Sandwich {
   private int size;
   private String breadType;
   private boolean isToasted;


    public Sandwich(int size, String breadType, boolean isToasted) {
        this.size = size;
        this.breadType = breadType;
        this.isToasted = isToasted;
    }

    public int getSize() {
        return size;
    }

    public String getBreadType() {
        return breadType;
    }

    public boolean isToasted() {
        return isToasted;
    }

    public void setToasted(boolean toasted) {
        isToasted = toasted;
    }

    public void addTopings(Topping topping) {

    }

    public void removeTopping(Topping topping) {

    }

    public void calculateCost() {

    }
}
