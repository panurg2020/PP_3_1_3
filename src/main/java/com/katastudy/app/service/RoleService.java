package com.katastudy.app.service;

import com.katastudy.app.model.Role;
import com.katastudy.app.model.User;

import java.util.Set;

public interface RoleService {
    void addRole(Role role);
    Role getById (long id);
    Set<Role> getAllRoles(User user);
}
