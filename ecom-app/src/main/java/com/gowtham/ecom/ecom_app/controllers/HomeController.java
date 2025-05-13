package com.gowtham.ecom.ecom_app.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String greet(){
        return "welcome to E-com";
    }
}
