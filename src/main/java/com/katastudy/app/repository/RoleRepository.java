package com.katastudy.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.katastudy.app.model.Role;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
}
