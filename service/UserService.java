package com.devnologix.exploria_backend.service;

import java.util.List;

import com.devnologix.exploria_backend.exception.UserAlreadyExistException;
import com.devnologix.exploria_backend.model.User;
import com.devnologix.exploria_backend.model.UserDto;



public interface UserService {
    User save(UserDto user) throws UserAlreadyExistException;
    List<User> findAll();
    User findOne(String username);
}
