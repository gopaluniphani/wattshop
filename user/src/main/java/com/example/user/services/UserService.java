package com.example.user.services;

import com.example.user.entity.User;

import java.util.List;

public interface UserService {
    User save(User user);
    User findById(int id);
    List<User> findAll();
}
