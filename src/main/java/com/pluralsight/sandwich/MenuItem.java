package com.pluralsight.sandwich;

public abstract class MenuItem implements CalculatePrice{

public abstract void displayItem();

    public static void displaySides() {
        System.out.println("** Sides **");
        System.out.println("Chips: $1.50 each");
        System.out.println("Available Types: Lay's, Doritos, Pringles, Ruffles, Cheetos\n");
    }

    public static void displayDrinks() {
        System.out.println("** Drinks **");
        System.out.println("Small: $2.00, Medium: $2.50, Large: $3.00");
        System.out.println("Available Flavors: Lemonade, Soda, Coffee, Sparkling Water, Smoothie, Milkshake, Fresh Juice\n");
    }

    public static void displaySandwichSizesAndPrices() {
        System.out.println("** Sandwich Sizes and Prices **");
        System.out.println("4\" Sandwich: Base Price for Meat - $1.00");
        System.out.println("8\" Sandwich: Base Price for Meat - $2.00");
        System.out.println("12\" Sandwich: Base Price for Meat - $3.00");
        System.out.println("Extra Meat: +$0.50 (4\"), +$1.00 (8\"), +$1.50 (12\")\n");
    }

    public static void displayProteins() {
        System.out.println("** Meats (Base Price Included in Sandwich Size) **");
        System.out.println("Available Types: Steak, Ham, Salami, Roast Beef, Chicken, Bacon\n");
    }
    public static void displayCheeses() {
        System.out.println("** Cheeses **");
        System.out.println("4\" Sandwich: $0.75");
        System.out.println("8\" Sandwich: $1.50");
        System.out.println("12\" Sandwich: $2.25");
        System.out.println("Extra Cheese: +$0.30 (4\"), +$0.60 (8\"), +$0.90 (12\")");
        System.out.println("Available Types: American, Provolone, Cheddar, Swiss\n");
    }
    public static void displayVeggies() {
        System.out.println("** Veggies ** (Included in Base Price)");
        System.out.println("Available Types: Lettuce, Peppers, Onions, Tomatoes, Jalapenos, Cucumbers, Pickles, Guacamole, Mushrooms\n");
    }
    public static void displaySauces() {
        System.out.println("** Sauces ** (Included in Base Price)");
        System.out.println("Available Types: Mayo, Mustard, Ketchup, Ranch, Thousand Islands, Vinaigrette\n");
    }
}

