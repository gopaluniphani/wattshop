package com.example.user.controller;

import com.example.user.entity.User;
import com.example.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {
    @Autowired
    UserService userService;

    @GetMapping(value="/user/{id}")
    public User findById(@PathVariable("id") int id){
        return userService.findById(id);
    }

    @PostMapping("/register")
    public User save(@RequestBody User user){
        return userService.save(user);
    }

    @GetMapping(value="/findall")
    List<User> findall(){
        return userService.findAll();
    }
}

