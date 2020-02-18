package com.example.rentcar.controller;

import com.example.rentcar.model.LoginForm;
import com.example.rentcar.model.RegistrationForm;
import com.example.rentcar.repository.UserRepository;
import com.example.rentcar.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class LoginController {

    private UserRepository userRepository;
    private LoginService loginService;


    @Autowired
    public LoginController(UserRepository userRepository, LoginService loginService) {
        this.userRepository = userRepository;
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public String login(@Valid LoginForm loginForm, BindingResult bindingResult, Model model) {

//        if (bindingResult.hasErrors()) {
//            return "login";
//        }
//        else if(loginService.isCorrectUser(loginForm))
//        {
//            return "redirect:/home";
//        }else{
//            model.addAttribute("invalidLogin",true);
//            return "login";
//
//        }
        return "login";


    }

    @GetMapping("/login")
    public String loginGet(Model model) {


        LoginForm loginForm = new LoginForm();

        model.addAttribute("loginForm", loginForm);

        return "login";
    }
}
