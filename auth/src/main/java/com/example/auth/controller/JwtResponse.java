package com.example.auth.controller;

import com.example.auth.entity.MyUser;

import java.io.Serializable;

public class JwtResponse implements Serializable {

    private static final long serialVersionUID = -8091879091924046844L;
    private final String jwttoken;
    private MyUser user;

    public JwtResponse(String jwttoken, MyUser user) {
        this.jwttoken = jwttoken;
        this.user = user;
    }

    public String getToken() {
        return this.jwttoken;
    }
    public MyUser getUser() {
        return this.user;
    }
}