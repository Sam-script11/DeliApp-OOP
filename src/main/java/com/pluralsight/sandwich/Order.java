package com.pluralsight.sandwich;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order implements CalculatePrice {
    private int orderId;
    private String customerName;
    private ArrayList<MenuItem> items;
    private double subtotal;
    private double taxRate;
    private double totalAmount;
    private String storeName;
    private String storeAddress;
    private LocalDate date;
    private DateTimeFormatter formatter;


    public void DateEncapsulation() {
        this.date = LocalDate.now();
        this.formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    }

    private int orderCounter =0;
    public Order() {
        this.orderId = orderCounter++;
        this.items = new ArrayList<>();
        this.taxRate = .2;
        this.storeName = "Sams sandwich shop";
        this.storeAddress = "12305 houston ave. ....";
        DateEncapsulation();
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
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

    public void addItem(MenuItem item){
        this.items.add(item);
    }

    @Override
    public double getPrice() {

        for(MenuItem item: items){
            totalAmount += item.getPrice();
        }
        return totalAmount;
    }
}
