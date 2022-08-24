package com.katastudy.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/user")
    public String infoUser() {
        return "/user";
    }

    @GetMapping("/userWoRole")
    public String infoUserWoRole() {
        return "userWoRole";
    }
}
