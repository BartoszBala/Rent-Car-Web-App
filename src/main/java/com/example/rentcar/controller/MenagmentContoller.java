package com.example.rentcar.controller;


import com.example.rentcar.service.UserContextService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MenagmentContoller {

    UserContextService userContextService;

    public MenagmentContoller(UserContextService userContextService) {
        this.userContextService = userContextService;
    }

    @GetMapping("/menagment")
    public String forwardToMenagment(Model model){

        model.addAttribute("isAuthenticated",userContextService.isAuthetnticated());

        return "menagment";
    }
}
