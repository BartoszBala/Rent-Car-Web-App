package com.example.rentcar.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public class LoginController {


    @PostMapping("/login")
    public String login(){

        return "login";
    }

    @GetMapping("/login")
    public String loginGet(){

        return "login";
    }
}
