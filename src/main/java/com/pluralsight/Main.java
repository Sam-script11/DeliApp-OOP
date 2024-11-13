package com.pluralsight;


import com.pluralsight.sandwich.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {

    static final Scanner keyboard = new Scanner(System.in);
    static final Map<String, Double> SandwichSizePrices = Map.of("4", 5.50, "8", 7.0, "12", 8.50);
    static final Map<String,Double> drinkSizePrices = Map.of("Small",2.00,"Medium",2.50,"Large",3.00);
    static  final AllToppings allToppings = new AllToppings();
    static List<String> drinksFlavors = Arrays.asList( "Coca-Cola", "Diet Coke", "Sprite", "Fanta", "Dr Pepper","Sweet Tea", "Lemonade", "Coffee", "Milkshake", "Orange Juice");
    static Order newOrder;
    public static void main(String[] args) throws InterruptedException {

        System.out.println("Welcome to Simply Sam’s Sandwich Society");
        homeScreen();

//
//        // add lists inside the sandwich class for better
//        List<String> chips = new ArrayList<>();
//        chips.add("Lay's");
//        chips.add("Doritos");
//        chips.add("Pringles");
//        chips.add("Ruffles");
//        chips.add("Cheetos");
//
//        for (String chip : chips) {
//            Thread.sleep(1000);
//
//            System.out.println(chip);
//
//        }
//
//        List <String> breadType = new ArrayList<>();
//        breadType.add("white");
//        breadType.add("wheat");
//        breadType.add("rye");
//        breadType.add("wrap");
//
////        for (String bread : breadType) {
////            System.out.println(bread);
////
////        }
//
//        List<String> meatType = new ArrayList<>();
//        meatType.add("steak");
//        meatType.add("ham");
//        meatType.add("salami");
//        meatType.add("roast beef");
//        meatType.add("chicken");
//        meatType.add("bacon");
//
////        for (String meat : meatType) {
////            System.out.println(meat);
////        }
//
//        List<String> cheeseType = new ArrayList<>();
//        cheeseType.add("american");
//        cheeseType.add("Provolone");
//        cheeseType.add("Cheddar");
//        cheeseType.add("Swiss");
//
////        for (String cheese : cheeseType) {
////            System.out.println(cheese);
////        }
//        List<String> veggies = new ArrayList<>();
//        veggies.add("lettuce");
//        veggies.add("peppers");
//        veggies.add("onions");
//        veggies.add("tomatoes");
//        veggies.add("jalapenos");
//        veggies.add("cucumbers");
//        veggies.add("pickles");
//        veggies.add("guacamole");
//        veggies.add("mushrooms");

//        for (String veggy : veggies) {
//            System.out.println(veggy);
//        }
//
//        List<String> sauces = new ArrayList<>();
//        sauces.add("Mayo");
//        sauces.add("Mustard");
//        sauces.add("ketchup");
//        sauces.add("ranch");
//        sauces.add("thousand islands");
//        sauces.add("vinaigrette");
//
////        for (String sauce : sauces) {
////            System.out.println(sauce);
////        }


        //System.out.println(drinksFlavors);
   }
    public static void homeScreen() {
        System.out.println("""
                Home Screen:
                1) New Order
                0) Exit
                """);
        int choice = Integer.parseInt(keyboard.nextLine());
        switch (choice) {
            case 1:
                newOrder = new Order();
                orderScreenCommands();
            case 0:
                System.exit(0);
            default:
                System.out.println("Invalid choice, please try again.");
        }
    }
    public static void orderScreenCommands() {

        boolean isRunning = true;

        while(isRunning) {

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
                case 1 -> addSandwichCommand();

                case 2 -> addDrink();
                case 3 -> addChips();
                case 4 -> checkout();
                case 0 -> {homeScreen();
                    isRunning =false;}

                default -> System.out.println("Invalid choice, please try again.");
            }
        }
    }
    public static void addSandwichCommand() {
        Sandwich sandwich = new Sandwich();


        // SIZE
        // System.out.println(SandwichSizePrices);
        System.out.println("Select a sandwich size: " + SandwichSizePrices.keySet());
        String sandwichSize = keyboard.nextLine();
        if (SandwichSizePrices.containsKey(sandwichSize)) {
            System.out.println("Selected size: " + sandwichSize);
            sandwich.setSize(Integer.parseInt(sandwichSize));
        } else {
            System.out.println("Invalid size selected.");
        }


        //BREAD
        System.out.println("Select your type of bread");
        allToppings.displayBread();

        int breadSelection = Integer.parseInt(keyboard.nextLine());

        switch (breadSelection) {

            case 1 -> sandwich.setBreadType(allToppings.getBreadType().get(0));

            case 2 -> sandwich.setBreadType(allToppings.getBreadType().get(1));

            case 3 -> sandwich.setBreadType(allToppings.getBreadType().get(2));

            case 4 -> sandwich.setBreadType(allToppings.getBreadType().get(3));

        }

        System.out.println("You selected: " + allToppings.getBreadType().get(breadSelection-1));


        //adding regular toppings to the sandwich
        System.out.println("What veggies would you like to add to your sandwich?");
        System.out.println("If you'd like multiple, please separate your choices by commas");
        allToppings.displayVeggies();
        String[] vegSel = keyboard.nextLine().split(",");
        sandwich.setVeggies(addVeggies(vegSel));



        // end of making sandwich
        //read to add it as an item to our order

        newOrder.addItem(sandwich);
    }
    public static void addDrink(){
        System.out.println("Select the drink flavor you want.");
        for(String drink: drinksFlavors){
            System.out.println(drink);
        }

        String drinkFlav = keyboard.nextLine();

        System.out.println(drinkSizePrices);
        System.out.println("What size drink would you like: ");
        String drinkSize = keyboard.nextLine().trim();

        if(drinkSizePrices.containsKey(drinkSize)){
            System.out.println("You selected size: "+ drinkSize);
            Drink drink = new Drink(drinkFlav,drinkSize, drinkSizePrices.get(drinkSize));
          newOrder.addItem(drink);
        } else {

            System.out.println("Invalid size selection");
        }


    }
    public static void addChips(){
        List<String> chipsArr = new ArrayList<>();
        chipsArr.add("Lay's");
        chipsArr.add("Doritos");
        chipsArr.add("Pringles");
        chipsArr.add("Ruffles");
        chipsArr.add("Cheetos");

        System.out.println("What kind of chips would you like: ");

        for (int i = 0; i < chipsArr.size(); i++) {
            System.out.println(i+1 + ")" +chipsArr.get(i));
        }

        String chipSelected = keyboard.nextLine();
        int index = Integer.parseInt(chipSelected) - 1;
        Chips chips =  new Chips(chipsArr.get(index));

        newOrder.addItem(chips);

    }

    private static ArrayList<String> addVeggies(String[] selectionsArr){
        ArrayList veggies = new ArrayList<>();

        for(String selectVegNum: selectionsArr){
            String topping = allToppings.getVeggies().get(Integer.parseInt(selectVegNum)-1);
            veggies.add(topping);
        }

           return veggies;
    }



    //• Checkout - display the order details and the price --> create a list
    public static void checkout(){
        // display all of info
        //o Confirm - create the receipt file and go back to the home screen --> write to csv file
        //o Cancel - delete order and go back to the home screen

        System.out.println(newOrder.getPrice());
        for(MenuItem item: newOrder.getItems()){
            item.displayItem();
        }
        System.out.println("Returning to Home Screen");
        homeScreen();
    }

    public static void writeReceipt(String orderDetails) {
        try (FileWriter writer = new FileWriter("src/main/resources/receipt.csv", true)) {
            writer.write(orderDetails);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}