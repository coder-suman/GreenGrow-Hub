package com.example.krishiculture.fertilizerStore;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private String orderId;
    private String userId;
    private String userEmail;
    private String customerAddress;
    private String customerPinCode;
    private String customerPhone;
    private List<CartItem> items;
    private double totalAmount;
    private long orderTime;
    private String orderStatus;
    private String deliveryAddress;

    public Order() {
        // Required empty constructor for Firebase
    }

    public Order(String orderId, String userId, String userEmail, String customerAddress, 
                String customerPinCode, String customerPhone, ArrayList<CartItem> items, 
                double totalAmount, String deliveryAddress) {
        this.orderId = orderId;
        this.userId = userId;
        this.userEmail = userEmail;
        this.customerAddress = customerAddress;
        this.customerPinCode = customerPinCode;
        this.customerPhone = customerPhone;
        this.items = new ArrayList<>(items);
        this.totalAmount = totalAmount;
        this.orderTime = System.currentTimeMillis();
        this.orderStatus = "Pending..."; // Initial status
        this.deliveryAddress = deliveryAddress;
    }

    // Getters and setters
    public String getOrderId() { return orderId; }
    public void setOrderId(String orderId) { this.orderId = orderId; }
    
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
    
    public String getUserEmail() { return userEmail; }
    public void setUserEmail(String userEmail) { this.userEmail = userEmail; }
    
    public String getCustomerAddress() { return customerAddress; }
    public void setCustomerAddress(String customerAddress) { this.customerAddress = customerAddress; }
    
    public String getCustomerPinCode() { return customerPinCode; }
    public void setCustomerPinCode(String customerPinCode) { this.customerPinCode = customerPinCode; }
    
    public String getCustomerPhone() { return customerPhone; }
    public void setCustomerPhone(String customerPhone) { this.customerPhone = customerPhone; }
    
    public List<CartItem> getItems() { return items; }
    public void setItems(List<CartItem> items) { this.items = items; }
    
    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }
    
    public long getOrderTime() { return orderTime; }
    public void setOrderTime(long orderTime) { this.orderTime = orderTime; }
    
    public String getOrderStatus() { return orderStatus; }
    public void setOrderStatus(String orderStatus) { this.orderStatus = orderStatus; }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }
} 