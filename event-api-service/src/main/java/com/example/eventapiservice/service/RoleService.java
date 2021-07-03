package com.example.eventapiservice.service;

import com.example.eventapiservice.entity.Role;

import java.util.Collection;
import java.util.List;

public interface RoleService {

    Role addRole(String roleName);
    List<Role> findAll();
    Role findById(Long id);

}
