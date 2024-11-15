package com.pluralsight;
import com.pluralsight.sandwich.*;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static com.pluralsight.sandwich.MenuItem.*;

public class Main {

    // Scanner to capture user input
    public static final Scanner keyboard = new Scanner(System.in);

    // Map for sandwich sizes and their corresponding base prices
    static final Map<String, Double> SandwichSizePrices = Map.of(
            "4", 5.50,
            "8", 7.0,
            "12", 8.50
    );

    // Map for drink sizes and their corresponding prices
    static final Map<String, Double> drinkSizePrices = Map.of(
            "Small", 2.00,
            "Medium", 2.50,
            "Large", 3.00
    );
    // Instance of AllToppings to manage various topping options
    static final AllToppings allToppings = new AllToppings();

    // Instance of Sides for managing side options like chips
    static final Sides allsides = new Sides();

    // List of available drink flavors
    public static List<String> drinksFlavors = Arrays.asList(
            "Coca-Cola", "Diet Coke", "Sprite", "Dr Pepper", "Lemonade",
            "Coffee", "Orange Juice");

    // Current order being processed
    public static Order newOrder;

    public static void main(String[] args) {
        ImageIcon image = new ImageIcon("src/main/image/Logo.PNG");
        String [] homeButton = {"continue"};

        String title = "Welcomes to SamScript Solutions";
        JOptionPane.showOptionDialog(null,title,"Title",
                JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE,image,homeButton,1); // fromatting the home screen

        String str = JOptionPane.showInputDialog("What is your name "); // used to create dialog box with the message on top of it
        // System.out.println(str); // str takes the input on the dialog box and prints it to the terminal
        JOptionPane.showOptionDialog(null,"Hello "+str,"Greetings",JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE,null,homeButton,1);
        homeScreen();
    }

    // Displays the home screen options for the user
    public static void homeScreen() {
        System.out.print("""
                Home Screen:
                1) New Order
                0) Exit
                                 
                Please select an option: """);

        int choice = keyboard.nextInt();
        switch (choice) {
            case 1 -> {
                newOrder = new Order(); // Initialize a new order
                orderScreenCommands();
            }
            case 0 -> System.exit(0); // Exit the program
            default -> System.out.print("Invalid choice, please try again.");
        }
    }

    // Displays the order screen with commands for adding items
    public static void orderScreenCommands() {
        boolean isRunning = true;

        while (isRunning) {
            System.out.print("""
                    What would you like to do today
                    Order Screen:
                    1) Add Sandwich
                    2) Add Drink
                    3) Add Chips
                    4) Checkout
                    0) Cancel Order
                    
                    Please select from the following: """);

            int choice = keyboard.nextInt();

            keyboard.nextLine();

            switch (choice) {
                case 1 -> addSandwichCommand(); // Adds a sandwich to the order
                case 2 -> addDrink(); // Adds a drink to the order
                case 3 -> addChips(); // Adds chips to the order
                case 4 -> checkout(); // Proceeds to checkout
                case 0 -> {
                    homeScreen(); // Returns to home screen
                    isRunning = false;
                }
                default -> System.out.println("Invalid choice, please try again.");
            }
        }
    }

    // Adds a sandwich to the current order
    public static void addSandwichCommand() {
        Sandwich sandwich = new Sandwich();

        MenuItem.displaySandwichSizesAndPrices();
        System.out.print("Select a sandwich size: " + SandwichSizePrices.keySet() + " ");
        String sandwichSize = keyboard.nextLine().trim();

        if (SandwichSizePrices.containsKey(sandwichSize)) {
            System.out.println("Selected size: " + sandwichSize + " ");
            sandwich.setSize(Integer.parseInt(sandwichSize));
        } else {
            System.out.println("Invalid size selected.");
        }

        // Prompt for selecting bread type
        System.out.print("Select your type of bread: ");
        allToppings.displayBread();
        int breadSelection = Integer.parseInt(keyboard.nextLine());

        sandwich.setBreadType(allToppings.getBreadType().get(breadSelection - 1));
        System.out.println("You selected: " + allToppings.getBreadType().get(breadSelection - 1) + " ");

        displayProteins();
        // Prompt for selecting protein toppings
        System.out.print("What is your protein selection: ");
        displayProteins();
        allToppings.displayProtein();
        String[] meatSelected = keyboard.nextLine().split(",");
        sandwich.setProtein(addProtein(meatSelected));

        // Prompt for selecting cheese
        System.out.print("What type of cheese would you like to add to your sandwich: ");
        displayCheeses();
        allToppings.dislayCheese();
        String[] cheeseSel = keyboard.nextLine().split(",");
        sandwich.setCheese(addCheese(cheeseSel));

        // Prompt for selecting veggies
        System.out.print("What veggies would you like to add to your sandwich: ");
        displayVeggies();
        allToppings.displayVeggies();
        String[] vegSel = keyboard.nextLine().split(",");
        sandwich.setVeggies(addVeggies(vegSel));

        // Prompt for selecting sauces
        System.out.print("What kind of sauces would you like to add to your sandwich: ");
        displaySauces();
        allToppings.displaySauce();
        String[] saucesSel = keyboard.nextLine().split(",");
        sandwich.setSauces(addSauces(saucesSel));

        newOrder.addItem(sandwich); // Add the sandwich to the order
    }

    // Adds a drink to the current order
    public static void addDrink() {
        displayDrinks();
        System.out.print("Select the drink flavor you want: ");
        for (String drink : drinksFlavors) {
            System.out.println(drink);
        }
        String drinkFlavor = keyboard.nextLine().trim();
        System.out.print("What size drink would you like: ");
        String drinkSize = keyboard.nextLine().trim();

        if (drinkSizePrices.containsKey(drinkSize)) {
            System.out.print("You selected size: " + drinkSize + " ");
            Drink drink = new Drink(drinkFlavor, drinkSize, drinkSizePrices.get(drinkSize));
            newOrder.addItem(drink); // Add the drink to the order
        } else {
            System.out.println("Invalid size selection");
        }
    }

    // Adds chips to the current order
    public static void addChips() {
        MenuItem.displaySides();
        allsides.displayChips();
        System.out.print("What kind of chips would you like: ");
        String chipSelected = keyboard.nextLine().trim();
        Sides chips = new Sides(chipSelected);
        newOrder.addItem(chips); // Add chips to the order
    }

    // Adds selected veggies to the sandwich
    public static ArrayList<String> addVeggies(String[] selectionsArr) {
        ArrayList<String> veggies = new ArrayList<>();
        for (String selectVegNum : selectionsArr) {
            String topping = allToppings.getVeggies().get(Integer.parseInt(selectVegNum) - 1);
            veggies.add(topping);
        }
        return veggies;
    }

    // Adds selected protein toppings to the sandwich
    public static ArrayList<String> addProtein(String[] meatSelArr) {
        ArrayList<String> meats = new ArrayList<>();
        for (String selectedMeatNum : meatSelArr) {
            String meatTopping = allToppings.getMeatType().get(Integer.parseInt(selectedMeatNum) - 1);
            meats.add(meatTopping);
        }
        return meats;
    }

    // Adds selected cheese to the sandwich
    public static ArrayList<String> addCheese(String[] cheeseSelArr) {
        ArrayList<String> cheese = new ArrayList<>();
        for (String selCheeseNum : cheeseSelArr) {
            String cheeseTopping = allToppings.getCheeseType().get(Integer.parseInt(selCheeseNum) - 1);
            cheese.add(cheeseTopping);
        }
        return cheese;
    }

    // Adds selected sauces to the sandwich
    public static ArrayList<String> addSauces(String[] saucesSelArr) {
        ArrayList<String> sauces = new ArrayList<>();
        for (String numOfSauce : saucesSelArr) {
            String sauceSelected = allToppings.getSauces().get(Integer.parseInt(numOfSauce) - 1);
            sauces.add(sauceSelected);
        }
        return sauces;
    }

    // Finalizes the order and generates a receipt
    public static void checkout() {

        System.out.print("is your order correct?");
        for (MenuItem item : newOrder.getItems()) {
            item.displayItem();
            System.out.println("your total is $" + newOrder.getPrice());
        }
        System.out.print("is your order correct? (yes or no)");
        String input = keyboard.nextLine().trim();
        if (input.equalsIgnoreCase("yes")) {
            writereceipt(newOrder); // Write the receipt to a file
            System.out.println("Returning to Home Screen");
            homeScreen();
        }
        else {
            homeScreen();
        }
    }

    // Writes the order receipt to a text file
    public static void writereceipt(Order newOrder) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HH-mmss");
        String date = formatter.format(LocalDateTime.now());
        String filename = "src/main/resources/" + date + ".txt";

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filename, true))) {
            bufferedWriter.write(newOrder.toString());
            bufferedWriter.write("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
