package com.example.user.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
    private String houseNumber;
    private String street;
    private String city;
    private String state;
    private String country;
    private String pincode;
}
