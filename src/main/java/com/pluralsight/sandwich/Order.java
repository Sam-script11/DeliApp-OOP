package com.pluralsight.sandwich;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Order implements CalculatePrice {
    private int orderId;
    private ArrayList<MenuItem> items;
    private double subtotal;
    private double taxRate;
    private double totalAmount;
    private String storeName;
    private String storeAddress;
    private LocalDate date;
    private DateTimeFormatter formatter;

    private int orderCounter = 0;

    public Order() {
        this.orderId = orderCounter++;
        this.items = new ArrayList<>();
        this.taxRate = 6.25;
        this.storeName = "Simply Sam’s Sandwich Society";
        this.storeAddress = "543 Marie Curie Avenue\n" +
                "Retro ville, Tx 75449\n" +
                "United States";
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public ArrayList<MenuItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<MenuItem> items) {
        this.items = items;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public DateTimeFormatter getFormatter() {
        return formatter;
    }

    public void setFormatter(DateTimeFormatter formatter) {
        this.formatter = formatter;
    }

    public void addItem(MenuItem item) {
        this.items.add(item);
    }

    @Override
    public double getPrice() {
        totalAmount = 0;
        for (MenuItem item : items) {
            totalAmount += item.getPrice();
        }
        return totalAmount;
    }

    // method for formatting items
    public String printMenuItems() {
        StringBuilder itemList = new StringBuilder();
        for (MenuItem item : items) {
            itemList.append(item).append("\n"); // Assuming MenuItem has a toString method
        }
        return itemList.toString();
    }

    public String toString() {
        return "Store Name: " + storeName +
                "\nStore Address: " + storeAddress +
                "\nOrder ID: " + orderId +
                "\nSubtotal: $" + totalAmount +
                "\nTax Rate: " + taxRate + "%" +
                "\nTotal Amount: $" + (totalAmount * (1 + taxRate / 100)) +
                "\nItems:\n" + printMenuItems();
    }
}
