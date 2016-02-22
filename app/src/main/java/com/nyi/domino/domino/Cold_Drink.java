package com.nyi.domino.domino;

/**
 * Created by IN-3442 on 25-Dec-15.
 */
public class Cold_Drink {
    String name;
    int quantity;
    int rate;
    int price;

    public Cold_Drink() {
    }

    public Cold_Drink(String name, int rate, int quantity, int price) {
        this.name = name;
        this.rate=rate;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getRate() {
        return rate;
    }
}
