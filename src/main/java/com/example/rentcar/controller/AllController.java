package com.example.rentcar.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AllController {

    @GetMapping("/all")
    public String accesccForAllAuthenticated(){


        return "page";
    }
}
