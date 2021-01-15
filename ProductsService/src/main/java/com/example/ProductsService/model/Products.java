package com.example.ProductsService.model;

import javax.persistence.*;

@Table(name = "products")
@Entity
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;

    private String brandName;
    private int categoryId;
    private String productName;
    private String productDescription;
    private int bestPrice;
    private int totalStock;

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
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

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public double getBestPrice() {
        return bestPrice;
    }

    public void setBestPrice(int bestPrice) {
        this.bestPrice = bestPrice;
    }

    public int getTotalStock() {
        return totalStock;
    }

    public void setTotalStock(int totalStock) {
        this.totalStock = totalStock;
    }

    @Override
    public String toString() {
        return this.brandName + " " + this.categoryId + " " + this.productName;
    }
}
