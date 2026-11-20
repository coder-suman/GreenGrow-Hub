package com.example.krishiculture.seedsection;

public class CartItem {
    private String name;
    private int imageResource;
    private double price;
    private int quantity;

    // Required empty constructor for Firebase
    public CartItem() {
        // Empty constructor required for Firebase
    }

    public CartItem(String name, int imageResource, double price, int quantity) {
        this.name = name;
        this.imageResource = imageResource;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() { return name; }
    public int getImageResource() { return imageResource; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public double getTotalPrice() { return price * quantity; }

    // Add setters for Firebase
    public void setName(String name) { this.name = name; }
    public void setImageResource(int imageResource) { this.imageResource = imageResource; }
    public void setPrice(double price) { this.price = price; }
} 