package com.pluralsight;

import java.util.*;

public class Main {

    static final Scanner keyboard = new Scanner(System.in);
    static final Map<String, Double> SandwichSizePrices = Map.of("4\"", 5.50, "8\"", 7.0, "12\"", 8.50);
    static final Map<String,Double> drinkSizePrices = Map.of("Small",2.00,"Medium",2.50,"Large",3.00);
     static final double chipsPrice = 1.50;
    public static void main(String[] args) {
        System.out.println("Welcome to Simply Sam’s Sandwich Society");
        System.out.println();


        List<String> chips = new ArrayList<>();
        chips.add("Lay's");
        chips.add("Doritos");
        chips.add("Pringles");
        chips.add("Ruffles");
        chips.add("Cheetos");

        System.out.println(chips);

        List <String> breadType = new ArrayList<>();
        breadType.add("white");
        breadType.add("wheat");
        breadType.add("rye");
        breadType.add("wrap");

        System.out.println(breadType);

        List<String> meatType = new ArrayList<>();
        meatType.add("steak");
        meatType.add("ham");
        meatType.add("salami");
        meatType.add("roast beef");
        meatType.add("chicken");
        meatType.add("bacon");

        System.out.println(meatType);

        List<String> cheeseType = new ArrayList<>();
        cheeseType.add("american");
        cheeseType.add("Provolone");
        cheeseType.add("Cheddar");
        cheeseType.add("Swiss");

        System.out.println(cheeseType);

        List<String> veggies = new ArrayList<>();
        veggies.add("lettuce");
        veggies.add("peppers");
        veggies.add("onions");
        veggies.add("tomatoes");
        veggies.add("jalapenos");
        veggies.add("cucumbers");
        veggies.add("pickles");
        veggies.add("guacamole");
        veggies.add("mushrooms");

        System.out.println(veggies);

        List<String> sauce = new ArrayList<>();
        sauce.add("Mayo");
        sauce.add("Mustard");
        sauce.add("ketchup");
        sauce.add("ranch");
        sauce.add("thousand islands");
        sauce.add("vinaigrette");

        System.out.println(sauce);
    }
    double price;
    public static void homeScreen() {
        System.out.println("""
                Home Screen:
                1) New Order
                0) Exit
                """);
        int choice = Integer.parseInt(keyboard.nextLine());
        switch (choice) {
            case 1:
                orderScreenCommands();
            case 0:
                System.exit(0);
            default:
                System.out.println("Invalid choice, please try again.");
        }
    }
    public static void orderScreenCommands() {
        System.out.println("""
                Order Screen:
                1) Add Sandwich
                2) Add Drink
                3) Add Chips
                4) Checkout
                0) Cancel Order
                """);
        int choice = Integer.parseInt(keyboard.nextLine());
        switch (choice) {
            case 1:
                addSandwichCommand();
            case 2:
                addDrink();
            case 3:
                addChips();
            case 4:
                checkout();
            case 0:
                homeScreen();
            default:
                System.out.println("Invalid choice, please try again.");
        }
    }
    public static void addSandwichCommand(){
            System.out.println(SandwichSizePrices);
        System.out.println("Select a sandwich size: " + SandwichSizePrices.keySet());
        String sanSize = keyboard.nextLine();
        if (SandwichSizePrices.containsKey(sanSize)) {
            System.out.println("Selected size: " + sanSize);
        }
        System.out.println("Invalid size selected.");

    }
    public static void addDrink(){
        System.out.println(drinkSizePrices);
        System.out.println("What size drink would you like: ");
        String drinkSize = keyboard.nextLine().trim();
        if(SandwichSizePrices.containsKey(drinkSize)){
            System.out.println("You selected size: "+ drinkSize);
        }
        System.out.println("Invalid size selection");

    }
    public static void addChips(){
        List<String> chips = new ArrayList<>();
        chips.add("Lay's");
        chips.add("Doritos");
        chips.add("Pringles");
        chips.add("Ruffles");
        chips.add("Cheetos");

        System.out.print("What kind of chips would you like: ");



    }
    //• Checkout - display the order details and the price --> create a list
    public static void checkout(){
        // display all of info
        //o Confirm - create the receipt file and go back to the home screen --> write to csv file
        //o Cancel - delete order and go back to the home screen

    }

}