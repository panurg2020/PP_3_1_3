package com.katastudy.app.service;

import com.katastudy.app.model.Role;

import java.util.Set;

public interface RoleService {
    void addRole(Role role);
    Set<Role> getAllRoles();
}
