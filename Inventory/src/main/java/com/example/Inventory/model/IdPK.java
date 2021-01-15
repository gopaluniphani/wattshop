package com.example.Inventory.model;

import java.io.Serializable;

public class IdPK implements Serializable {

    private int productId;
    private int merchantId;

    public IdPK(int productId, int merchantId) {
        this.productId = productId;
        this.merchantId = merchantId;
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

    public int getMerchantId() {
        return merchantId;
    }
}
