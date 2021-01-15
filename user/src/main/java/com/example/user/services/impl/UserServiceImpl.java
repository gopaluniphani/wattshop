package com.example.user.services.impl;

import com.example.user.entity.User;
import com.example.user.repository.UserRepository;
import com.example.user.services.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findById(int id) {
        return userRepository.findById(id).get();
    }

    @Override
    public List<User> findAll() {
        Iterable<User> employeeIterable = userRepository.findAll();
        List<User> employeeList = new ArrayList<>();
        employeeIterable.forEach(employeeList::add);
        return employeeList;
    }
}
