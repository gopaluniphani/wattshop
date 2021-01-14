package com.example.Inventory.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "Inventory")
@Entity
public class Inventory {
    @EmbeddedId
    private IdPK idPK;
    private double price;
    private int quantity;

    public Inventory(int productId, String merchantID, double price, int quantity) {
        this.idPK.setMerchantId(merchantID);
        this.idPK.setProductId(productId);
        this.price = price;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public IdPK getIdPK() {
        return idPK;
    }

    public void setIdPK(IdPK idPK) {
        this.idPK = idPK;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
