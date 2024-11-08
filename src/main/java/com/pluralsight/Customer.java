package com.pluralsight;

public class Customer {
    private String name;
    private String CustomerInfo;

    public Customer(String name, String customerInfo) {
        this.name = name;
        CustomerInfo = customerInfo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCustomerInfo() {
        return CustomerInfo;
    }

    public void setCustomerInfo(String customerInfo) {
        CustomerInfo = customerInfo;
    }
}
