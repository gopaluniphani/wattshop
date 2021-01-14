package com.example.Sales.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(CompositeKey.class)
public class Sales {
    @Id
    private int prodId;
    @Id
    private int userId;
    @Id
    private int merchantId;

    int quantity;
    int price;
    String Date;
}
