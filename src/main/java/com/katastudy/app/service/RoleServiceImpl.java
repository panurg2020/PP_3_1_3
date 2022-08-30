package com.katastudy.app.service;

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
    public Set<Role> getAllRoles(long [] ides) {
        Set <Role> roles = new HashSet<>();
        for (int i = 0; i < ides.length; i++) {
            roles.add(roleRepository.getById(ides[i]));
        }
        return roles;
    }
}
