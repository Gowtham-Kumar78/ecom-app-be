package com.gowtham.ecom.ecom_app.controllers;

import com.gowtham.ecom.ecom_app.models.Users;
import com.gowtham.ecom.ecom_app.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    UserService userService;

    public UserController(UserService userService){this.userService=userService;}

    @GetMapping("/users")
    public List<Users> getUsers(){
        return userService.getUsers();
    }
}
