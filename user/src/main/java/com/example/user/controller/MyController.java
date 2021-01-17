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

    @GetMapping(value = "/{id}")
    public User findById(@PathVariable("id") String id) {
        return userService.findById(id);
    }

    @PostMapping("/")
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping(value = "/")
    List<User> findall() {
        return userService.findAll();
    }

    @PutMapping(value = "/")
    User update(@RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping(value = "/email/{email}")
    User findByEmail(@PathVariable("email") String email) {
        return userService.findByEmail(email);
    }
}

