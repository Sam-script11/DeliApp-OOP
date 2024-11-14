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
    static final Sides allsides = new Sides();
    static List<String> drinksFlavors = Arrays.asList( "Coca-Cola", "Diet Coke", "Sprite", "Dr Pepper", "Lemonade", "Coffee", "Orange Juice");
    static Order newOrder;

    public static void main(String[] args) {



        System.out.println("Welcome to Simply Sam’s Sandwich Society");
        homeScreen();
   }
    public static void homeScreen() {
        System.out.print("""
                Home Screen:
                1) New Order
                0) Exit
                
                Please select an option:
                """);
        int choice = keyboard.nextInt();
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

            System.out.print("""
                    Order Screen:
                    1) Add Sandwich
                    2) Add Drink
                    3) Add Chips
                    4) Checkout
                    0) Cancel Order
                    
                    Please select from the following:
                    """);
            int choice = keyboard.nextInt();
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

        System.out.println("What is your protein selection: ");
        System.out.println("if you would like multiple, separate choices by commas");
        allToppings.displayProtein();
        String [] meatSelected = keyboard.nextLine().split(",");
        sandwich.setProtein(addProtein(meatSelected));

        System.out.println("What type of cheese would you like to add to your sandwich?");
        System.out.println("If you'd like multiple, please separate your choices by commas");
        allToppings.dislayCheese();
        String[] cheeseSel = keyboard.nextLine().split(",");
        sandwich.setCheese(addCheese(cheeseSel));



        System.out.println("What veggies would you like to add to your sandwich?");
        System.out.println("If you'd like multiple, please separate your choices by commas");
        allToppings.displayVeggies();
        String[] vegSel = keyboard.nextLine().split(",");
        sandwich.setVeggies(addVeggies(vegSel));


        System.out.println("What kind of sauces would you like would you like to add to your sandwich?");
        System.out.println("If you'd like multiple, please separate your choices by commas");
        allToppings.displaySauce();
        String[] saucesSel = keyboard.nextLine().split(",");
        sandwich.setVeggies(addSauces(saucesSel));


        newOrder.addItem(sandwich);
    }
    public static void addDrink(){
        System.out.println("Select the drink flavor you want.");

        for(String drink: drinksFlavors){
            System.out.println(drink);
        }

        String drinkFlavor = keyboard.nextLine();
        System.out.println(drinkSizePrices);
        System.out.println("What size drink would you like: ");
        String drinkSize = keyboard.nextLine().trim();

        if(drinkSizePrices.containsKey(drinkSize)){
            System.out.println("You selected size: "+ drinkSize);
            Drink drink = new Drink(drinkFlavor,drinkSize, drinkSizePrices.get(drinkSize));
          newOrder.addItem(drink);
        } else {

            System.out.println("Invalid size selection");
        }
    }
    public static void addChips(){
        List<String> chipsArr = new ArrayList<>(); // move this to the chips class, or sides
        allsides.displayChips();
        System.out.println("What kind of chips would you like: ");

        int chipSelected = keyboard.nextInt();
        //int index = Integer.parseInt(chipSelected) - 1;
       // Sides chips =  new Sides(chipsArr.get(index));

       // newOrder.addItem(chips);

    }

    public static ArrayList<String> addVeggies(String[] selectionsArr){
        ArrayList veggies = new ArrayList<>();

        for(String selectVegNum: selectionsArr){
            String topping = allToppings.getVeggies().get(Integer.parseInt(selectVegNum)-1);
            veggies.add(topping);
        }

           return veggies;
    }

    public static ArrayList<String> addProtein(String [] meatSellArr){
        ArrayList meats = new ArrayList<>();

        for (String selectedMeatNum: meatSellArr){
            String meatToppings = allToppings.getMeatType().get(Integer.parseInt(selectedMeatNum)-1);
            meats.add(meatToppings);
        }
        return meats;
    }

    public static ArrayList<String> addCheese(String [] cheeseSelArr){
        ArrayList cheese = new ArrayList<>();

        for (String selCheeseNum: cheeseSelArr){
            String cheeseToppings = allToppings.getCheeseType().get(Integer.parseInt(selCheeseNum)-1);
            cheese.add(cheeseToppings);
        }
        return cheese;
    }
    public static ArrayList<String> addSauces(String [] saucesSelArr) {
        ArrayList sauces = new ArrayList<>();

        for (String numOfSauce : saucesSelArr) {
            String sauceSelected = allToppings.getSauces().get(Integer.parseInt(numOfSauce) - 1);
            sauces.add(sauceSelected);
        }
        return sauces;

    }



    //• Checkout - display the order details and the price --> create a list
    public static void checkout(){

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