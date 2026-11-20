package com.example.krishiculture.fertilizerStore;

public class CartItem {
    private String name;
    private int image;
    private int quantity;
    private double price;

    // Add empty constructor for Firebase
    public CartItem() {
        // Required empty constructor for Firebase
    }

    public CartItem(String name, int image, double price) {
        this.name = name;
        this.image = image;
        this.quantity = 1;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public double getTotalPrice() {
        return price * quantity;
    }

    // Add setters for Firebase
    public void setName(String name) { this.name = name; }
    public void setImage(int image) { this.image = image; }
    public void setPrice(double price) { this.price = price; }
} 