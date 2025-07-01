package com.devnologix.exploria_backend.service;

import com.devnologix.exploria_backend.model.Role;

public interface RoleService {
    Role findByName(String name);
}
