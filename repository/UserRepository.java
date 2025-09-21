package com.devnologix.exploria_backend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.devnologix.exploria_backend.model.User;



@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
