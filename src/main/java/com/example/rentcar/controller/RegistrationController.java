package com.example.rentcar.controller;


import com.example.rentcar.model.RegistrationForm;
import com.example.rentcar.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class RegistrationController {
    private UserRepository userRepository;


    public RegistrationController(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    @GetMapping("/register")
    public String registerForm(Model model){

        RegistrationForm registrationForm = new RegistrationForm();

        model.addAttribute("registrationForm", registrationForm);

        return "registration";
    }
    @PostMapping("/register")
    public String processRegistration(@Valid RegistrationForm registrationForm, BindingResult bindingResult){//dodanie Valid super działa z adnotacjami z klasy

       if(bindingResult.hasErrors())
       {bindingResult.getModel().entrySet().stream().forEach(x-> System.out.println(x));
           return "registration";
       }

//        model.addAttribute("registrationForm",new RegistrationForm());
        return "redirect:/login";

    }
}
