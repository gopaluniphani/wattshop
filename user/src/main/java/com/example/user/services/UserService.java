package com.example.user.services;

import com.example.user.entity.User;

import java.util.List;

public interface UserService {
    User save(User user);
    User findById(String id);
    List<User> findAll();
    User findByEmail(String email);
}
