package com.example.auth.repositories;

import com.example.auth.entity.MyUser;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<MyUser, Integer> {
    MyUser findByUsername(String username);
}
