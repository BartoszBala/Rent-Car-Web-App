package com.example.rentcar.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MenagmentContoller {

    @GetMapping("/menagment")
    public String forwardToMenagment(){

        return "menagment";
    }
}
