package com.example.rentcar.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BasicController {

    @PostMapping("/")
    public String homePage(){

        return "redirect:/home";
    }

    @GetMapping("/")
    public String homePageByGet(){

        return "redirect:/home";
    }
}
