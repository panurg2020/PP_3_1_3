package com.katastudy.app.service;

import com.katastudy.app.model.User;

import java.util.List;

public interface UserService {
    User findUserById(Long userId);

    List<User> allUsers();

    boolean saveUser(User user);

    boolean deleteUser(Long userId);

    boolean edit(User user);
}
