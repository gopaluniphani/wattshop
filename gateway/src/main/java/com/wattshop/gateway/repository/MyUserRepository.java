package com.wattshop.gateway.repository;

import com.wattshop.gateway.entity.MyUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyUserRepository extends CrudRepository<MyUser, Integer> {
    MyUser findByUsername(String username);
}
