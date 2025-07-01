package com.devnologix.exploria_backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devnologix.exploria_backend.model.Role;
import com.devnologix.exploria_backend.repository.RoleRepository;
import com.devnologix.exploria_backend.service.RoleService;



@Service(value = "roleService")
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleDao;

    @Override
    public Role findByName(String name) {
        Role role = roleDao.findRoleByName(name);
        return role;
    }
}
