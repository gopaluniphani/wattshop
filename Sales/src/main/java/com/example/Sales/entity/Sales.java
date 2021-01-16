package com.example.Sales.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.util.Date;

@Entity
@IdClass(CompositeKey.class)
@Table(name="sales")
public class Sales {
    @Id
    private int prodId;
    @Id
    private int userId;
    @Id
    private int merchantId;

    int quantity;
    int price;
    Date date;
}
