package com.example.user.entity;

public class Cart {
    private String inventoryId;
    private int quantity;

    public String getProductId() {
        return inventoryId;
    }

    public void setProductId(String inventoryId) {
        this.inventoryId = inventoryId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
