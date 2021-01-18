package com.example.user.controller;

import com.example.user.entity.User;
import com.example.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/user")
public class MyController {
    @Autowired
    UserService userService;

    @GetMapping(value = "/{userId}")
    public User findById(@PathVariable("userId") String id) {
        return userService.findById(id);
    }

    @PostMapping("/")
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping(value = "/")
    public List<User> findall() {
        return userService.findAll();
    }

    @PutMapping(value = "/")
    public User update(@RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping(value = "/email/{email}")
    public User findByEmail(@PathVariable("email") String email) {
        return userService.findByEmail(email);
    }

    @PutMapping(value = "/cart/{userId}")
    public User updateCart(@PathVariable("userId") String userId, @RequestBody User userWithNewCart) {
        User user = userService.findById(userId);
        user.setCart(userWithNewCart.getCart());
        return userService.save(user);
    }
}

