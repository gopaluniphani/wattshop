package com.example.Inventory.model;

import javax.persistence.Embeddable;

@Embeddable
public class IdPK {

    private int productId;
    private String merchantId;

    public IdPK(int productId, String merchantId) {
        this.productId = productId;
        this.merchantId = merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getMerchantId() {
        return merchantId;
    }
}
