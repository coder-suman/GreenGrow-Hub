package com.example.krishiculture.fertilizerStore;

public class DeliveryAddress {
    private String fullAddress;
    private String pinCode;
    private String phoneNumber;

    public DeliveryAddress(String fullAddress, String pinCode, String phoneNumber) {
        this.fullAddress = fullAddress;
        this.pinCode = pinCode;
        this.phoneNumber = phoneNumber;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public String getPinCode() {
        return pinCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
} 