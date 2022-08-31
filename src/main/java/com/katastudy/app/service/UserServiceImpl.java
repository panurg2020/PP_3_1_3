package com.katastudy.app.service;

import com.katastudy.app.repository.UserRepository;
import com.katastudy.app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(8);

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("User not found"));
        }
        return user;
    }

    @Override
    public User findByUsername(String email) {
        return userRepository.findByEmail(email);
    }

    public User findUserById(Long userId) {
        Optional<User> userFromDb = userRepository.findById(userId);
        return userFromDb.orElse(new User());
    }

    public List<User> allUsers() {
        return userRepository.findAll();
    }

    @Override
    public User saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        User anotherUser = userRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("Пользователь не найден"));
        userRepository.delete(anotherUser);
    }

    @Override
    public User edit(User user, Long id) {
        User anotherUser = userRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("Пользователь не найден"));
        return userRepository.save(anotherUser);
    }
}