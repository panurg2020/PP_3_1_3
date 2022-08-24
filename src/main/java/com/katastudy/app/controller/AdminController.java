package com.katastudy.app.controller;

import com.katastudy.app.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.katastudy.app.service.RoleServiceImpl;
import com.katastudy.app.service.UserServiceImpl;

@Controller
public class AdminController {
    private final UserServiceImpl userService;

    private final RoleServiceImpl roleService;

    private boolean resultEditUser;

    public AdminController(UserServiceImpl userService, RoleServiceImpl roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/admin")
    public String userList(Model model) {
        model.addAttribute("users", userService.allUsers());
        model.addAttribute("user", new User());
        model.addAttribute("allRoles", roleService.getAllRoles());
        model.addAttribute("alarm", resultEditUser);
        return "admin";
    }

    @GetMapping("/")
    public String loginPage() {
        return "login";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }

    @GetMapping("/edit/{id}")
    public String editPage(@PathVariable("id") Long id, Model model) {
        User user = userService.findUserById(id);
        model.addAttribute(user);
        model.addAttribute("allRoles", roleService.getAllRoles());
        return "editPage";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("user") User user) {
        System.out.println(user.getRoles());
        userService.saveUser(user);
        return "redirect:/admin";
    }

    @PutMapping("/edit/{id}")
    public String updateUser(@ModelAttribute("user") User user) {
        resultEditUser = !userService.edit(user);
        return "redirect:/admin";
    }

    @GetMapping("/newUser")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("allRoles", roleService.getAllRoles());
        return "newUser";
    }

    @GetMapping("/user")
    public String infoUser() {
        return "/user";
    }

    @GetMapping("/userWoRole")
    public String infoUserWoRole() {
        return "userWoRole";
    }

}
