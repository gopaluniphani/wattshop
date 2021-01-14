package com.example.ProductsService.model;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Table(name = "Products")
@Entity
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productId;
    private int categoryId;
    private String productName;
    private List<Map<String,String>> productDescription;
    private double bestPrice;
    private int totalStock;

    public Products(int categoryId, String productName, List<Map<String, String>> productDescription, double bestPrice, int totalStock) {
        this.categoryId = categoryId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.bestPrice = bestPrice;
        this.totalStock = totalStock;
    }

    public int getProductId() {
        return productId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public List<Map<String, String>> getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(List<Map<String, String>> productDescription) {
        this.productDescription = productDescription;
    }

    public double getBestPrice() {
        return bestPrice;
    }

    public void setBestPrice(double bestPrice) {
        this.bestPrice = bestPrice;
    }

    public int getTotalStock() {
        return totalStock;
    }

    public void setTotalStock(int totalStock) {
        this.totalStock = totalStock;
    }
}
