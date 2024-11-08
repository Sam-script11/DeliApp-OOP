package com.pluralsight;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Simply Sam’s Sandwich Society");
    }
    public static void homeScreen(){
        System.out.println("""
                1) New Order
                § 0) Exit - exit the application""");
    }

    public static void orderScreenCommands(){
        System.out.println("""
                 Screen - All entries should show the newest entries first
                o 1) Add Sandwich
                o 2) Add Drink
                o 3) Add Chips
                o 4) Checkout
                o 0) Cancel Order
                
                Please select a choice above:""");
    }

    public static void addSandwichCommand(){
        System.out.println("""
                Add Sandwich - the add sandwich screen will walk the user through
                several options to create the sandwich
                o Select your bread: // create a list of bread types,
                o Sandwich size: //create a list of sandwich size""");
    }

    //Would you like the sandwich toasted? --. inside the sandwich method
    //• Add Drink - select drink size and flavor --=/
    //• Add Chips - select chip type
    //• Checkout - display the order details and the price
    //o Confirm - create the receipt file and go back to the home screen
    //o Cancel - delete order and go back to the home screen
}