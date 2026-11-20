package com.example.krishiculture.seedsection;

import java.util.ArrayList;

public class SeedOrder {
    private String orderId;
    private String userId;
    private String userEmail;
    private String address;
    private String pinCode;
    private String phoneNumber;
    private ArrayList<CartItem> items;
    private double totalAmount;
    private long timestamp;
    private String status;

    public SeedOrder() {
        // Required empty constructor for Firebase
    }

    public SeedOrder(String orderId, String userId, String userEmail, String address, 
                    String pinCode, String phoneNumber, ArrayList<CartItem> items, double totalAmount) {
        this.orderId = orderId;
        this.userId = userId;
        this.userEmail = userEmail;
        this.address = address;
        this.pinCode = pinCode;
        this.phoneNumber = phoneNumber;
        this.items = items;
        this.totalAmount = totalAmount;
        this.timestamp = System.currentTimeMillis();
        this.status = "Pending";
    }

    // Getters
    public String getOrderId() { return orderId; }
    public String getUserId() { return userId; }
    public String getUserEmail() { return userEmail; }
    public String getAddress() { return address; }
    public String getPinCode() { return pinCode; }
    public String getPhoneNumber() { return phoneNumber; }
    public ArrayList<CartItem> getItems() { return items; }
    public double getTotalAmount() { return totalAmount; }
    public long getTimestamp() { return timestamp; }
    public String getStatus() { return status; }

    // Setters
    public void setOrderId(String orderId) { this.orderId = orderId; }
    public void setUserId(String userId) { this.userId = userId; }
    public void setUserEmail(String userEmail) { this.userEmail = userEmail; }
    public void setAddress(String address) { this.address = address; }
    public void setPinCode(String pinCode) { this.pinCode = pinCode; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public void setItems(ArrayList<CartItem> items) { this.items = items; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }
    public void setTimestamp(long timestamp) { this.timestamp = timestamp; }
    public void setStatus(String status) { this.status = status; }
} 