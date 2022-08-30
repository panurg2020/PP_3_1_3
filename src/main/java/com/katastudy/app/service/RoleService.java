package com.katastudy.app.service;

import com.katastudy.app.model.Role;
import java.util.Set;

public interface RoleService {
    void addRole(Role role);
    Role getById (long id);
    Set<Role> getAllRoles(long [] ides);
}
