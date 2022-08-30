package com.katastudy.app.service;

import com.katastudy.app.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    User findUserById(Long id);
    List<User> allUsers();
    User saveUser(User user);
    void deleteUser(Long id);
    User edit(User user, Long id);
    User findByUsername (String username);
}