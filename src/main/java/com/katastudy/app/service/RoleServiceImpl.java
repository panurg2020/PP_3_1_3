package com.katastudy.app.service;

import com.katastudy.app.model.User;
import com.katastudy.app.repository.RoleRepository;
import org.springframework.stereotype.Service;
import com.katastudy.app.model.Role;

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
}
