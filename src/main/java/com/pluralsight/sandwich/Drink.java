package com.pluralsight.sandwich;

public class Drink extends MenuItem implements CalculatePrice{
    protected String name;
    protected String size;
    protected double amount;

    public Drink(){

    }
    public Drink(String name, String size, double amount) {
        this.name = name;
        this.size = size;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getPrice() {

        switch (size.toLowerCase()) {
            case "small" -> {
                return 2.00;
            }
            case "medium" -> {
                return 2.50;
            }
            case "large" -> {
                return 3.00;
            }
            default -> {return 0;}
        }
    }
    public void setPrice(double price) {
        this.amount= price;
    }

    @Override
    public void displayItem() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Drink{" +
                "name='" + name + '\'' +
                ", size='" + size + '\'' +
                ", amount=" + amount +
                '}';
    }
}
