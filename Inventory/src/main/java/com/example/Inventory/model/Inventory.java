package com.example.Inventory.model;

import javax.persistence.*;

@Table(name = "Inventory")
@Entity
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int inventoryId;
    private int merchantId;
    private int productId;
    private String brandName;
    private String productName;
    private int price;
    private int quantity;

    public Inventory() {
    }

    public Inventory(int inventoryId, int merchantId, int productId, String brandName, String productName, int price, int quantity) {
        this.inventoryId = inventoryId;
        this.merchantId = merchantId;
        this.productId = productId;
        this.brandName = brandName;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public int getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }

    public int getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(int merchantId) {
        this.merchantId = merchantId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}