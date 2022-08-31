package com.katastudy.app.service;

import com.katastudy.app.model.User;
import com.katastudy.app.repository.RoleRepository;
import org.springframework.stereotype.Service;
import com.katastudy.app.model.Role;
import java.util.HashSet;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService{

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void addRole(Role role) {
        roleRepository.save(role);
    }

    @Override
    public Role getById(long id) {
        return roleRepository.getById(id);
    }

    @Override
    public Set<Role> getAllRoles(User user) {
        Set <Role> roles = new HashSet<>();
        user.getRoles().forEach(r -> roles.add(getById(r.getId())));
        return roles;
    }
}
