package com.example.rentcar.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccessDeniedController {

    @GetMapping("/accessDenied")
    public String accessControl(Model model){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        model.addAttribute("isAuthenticated",!(authentication instanceof AnonymousAuthenticationToken));

        return "accessDenied";
    }
}
