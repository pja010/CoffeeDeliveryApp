package com.example.deliveryappv1;

public class Coffee {
    private String type;
    private double price;

    public static final Coffee[] coffeeList = {
            new Coffee("Plain black", 2.0),
            new Coffee("Caffè Americano", 3.0)
    };

    private Coffee(String type, double price) {
        this.type = type;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return type + " $" + price;
    }
}
