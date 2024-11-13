package com.pluralsight.sandwich;

import java.util.ArrayList;

public class Sandwich extends MenuItem implements CalculatePrice{
   private int size;
   private String breadType;

   //meats
    private ArrayList<String> meats = new ArrayList<>();

    //cheeses
    private ArrayList<String> cheese = new ArrayList<>();


    //veggies
    private ArrayList<String> veggies = new ArrayList<>();

   private boolean isToasted;

   public Sandwich(){
   }

    public Sandwich(int size, String breadType, boolean isToasted) {
        this.size = size;
        this.breadType = breadType;
        this.isToasted = isToasted;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setBreadType(String breadType) {
        this.breadType = breadType;
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

    public ArrayList<String> getMeats() {
        return meats;
    }

    public void setMeats(ArrayList<String> meats) {
        this.meats = meats;
    }

    public ArrayList<String> getCheese() {
        return cheese;
    }

    public void setCheese(ArrayList<String> cheese) {
        this.cheese = cheese;
    }

    public ArrayList<String> getVeggies() {
        return veggies;
    }

    public void setVeggies(ArrayList<String> veggies) {
        this.veggies = veggies;
    }

    public void addToppings(CalculatePrice topping) {
        // list for regular, premium, sides
        //order--> list of drinks, and other things

    }

    public void removeTopping(CalculatePrice topping) {

    }

    public void calculateCost(){

    }

    @Override
    public double getPrice() {
double total = 0;
       //here we need to use the size of the sandwich
        switch (size){
            case 4 -> total += 5.50;
            case 8 -> total += 7.00;
            case 12 -> total += 8.50;
        }

        /// the count of the meat array
        // the count of the cheese array
        total += getCheesePrice();
        // calculate all of this to get the cost of the sandwich
        //double costSandwich = will calculate the cost Sandwich with topics included
        //might need helper methods

            total += getMeatsPrice();


        return total;
    }

    private double getMeatsPrice(){
         double total = 0;

        if(meats.isEmpty()){
            return total;
        }

       switch (size){
           case 4:

              if(meats.size() == 1){
                  total += 1;

              } else if(meats.size() > 1){
                  total += 1;

                  for(int i = meats.size() - 1 ; i > 0 ; --i){
                      total += .50;
                  }
              }

              return total;

           case 8:
               if(meats.size() == 1){
                   total += 1;

               } else if(meats.size() > 1) {
                   total += 1;

                   for (int i = meats.size() - 1; i > 0; --i) {
                       total += 1.00;
                   }
               }
               return total;
           case 12:
               if(meats.size() == 1){
                   total += 1;

               } else if(meats.size() > 1) {
                   total += 1;

                   for (int i = meats.size() - 1; i > 0; --i) {
                       total += 1.50;
                   }
               }
               return total;
       }
        return total;
    }
    private double getCheesePrice(){
        double total =0;

       if(cheese.isEmpty()){
           return total;
       }
        switch (size){
            case 4:

                if(cheese.size() == 1){
                    total += 1;

                } else if(cheese.size() > 1){
                    total += 1;

                    for(int i = cheese.size() - 1 ; i > 0 ; --i){
                        total += .30;
                    }
                }

                return total;

            case 8:
                if(cheese.size() == 1){
                    total += 1;

                } else if(cheese.size() > 1) {
                    total += 1;

                    for (int i = cheese.size() - 1; i > 0; --i) {
                        total += .60;
                    }
                }
                return total;
            case 12:
                if(cheese.size() == 1){
                    total += 1;

                } else if(cheese.size() > 1) {
                    total += 1;

                    for (int i = cheese.size() - 1; i > 0; --i) {
                        total += .90;
                    }
                }
                return total;
        }
        return total;
    }

    @Override
    public void displayItem() {
        //instead of a regular toString method, you can use this method to customize how your item displays to the user
        // you can also use this method to add the item or write then item to a receipt file
        System.out.println(this);
    }


    @Override
    public String toString() {
        return "Sandwich{" +
                "size=" + size +
                ", breadType='" + breadType + '\'' +
                ", meats=" + meats +
                ", cheese=" + cheese +
                ", veggies=" + veggies +
                ", isToasted=" + isToasted +
                '}';
    }
}
