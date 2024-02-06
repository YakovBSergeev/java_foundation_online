package ru.itsjava.itsjava_01.OOP;

public class Iron {

    private final int power;
    private double price;
    private int quantity;

    public Iron(double price, int quantity) {
        this.price = price;
        this.quantity = quantity;
        power = 2000;
    }

    public Iron(double price) {
        this.price = price;
        power = 2000;
    }

    public Iron(int quantity) {
        this.quantity = quantity;
        power = 2000;
    }

    public Iron(int power, double price, int quantity) {
        this.power = power;
        this.price = price;
        this.quantity = quantity;
    }

    public Iron(int power, int quantity) {
        this.power = power;
        this.quantity = quantity;
    }

    public Iron(int power, double price) {
        this.power = power;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public int getPower() {
        return power;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}



