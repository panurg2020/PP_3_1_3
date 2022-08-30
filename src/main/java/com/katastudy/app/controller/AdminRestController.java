package com.katastudy.app.controller;

import com.katastudy.app.model.User;
import com.katastudy.app.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping ("/api/users")
public class AdminRestController {

    private final UserService userService;

    public AdminRestController(UserService userService) {this.userService = userService;}

    @GetMapping()
    public List<User> getAll() {
        return userService.allUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById (@PathVariable ("id") Long id) {
        return ResponseEntity.ok(userService.findUserById(id));
    }

    @PostMapping
    public ResponseEntity<User> addUser (@RequestBody User user) {
        return ResponseEntity.ok(userService.saveUser(user));
    }

    @PutMapping ("/{id}")
    public ResponseEntity<User> editUser (@RequestBody User user, @PathVariable ("id") Long id) {
        return ResponseEntity.ok(userService.edit(user, id));
    }

    @DeleteMapping("/{id}")
    public void deleteUser (@PathVariable ("id") Long id) {
        userService.deleteUser(id);
    }
}