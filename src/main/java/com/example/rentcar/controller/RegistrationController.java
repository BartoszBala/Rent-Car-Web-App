package com.example.rentcar.controller;


import com.example.rentcar.model.RegistrationForm;
import com.example.rentcar.repository.UserRepository;
import com.example.rentcar.service.RegistrationValidationService;
import org.springframework.beans.factory.annotation.Autowired;
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
    private RegistrationValidationService registrationValidationService;

@Autowired
    public RegistrationController(UserRepository userRepository, RegistrationValidationService registrationValidationService) {
        this.userRepository = userRepository;
        this.registrationValidationService = registrationValidationService;
    }

    @GetMapping("/register")
    public String registerForm(Model model){

        RegistrationForm registrationForm = new RegistrationForm();

        model.addAttribute("registrationForm", registrationForm);

        return "registration";
    }
    @PostMapping("/register")
    public String processRegistration(@Valid RegistrationForm registrationForm, BindingResult bindingResult, Model model){//dodanie Valid super działa z adnotacjami z klasy

       if(bindingResult.hasErrors())
       {
           return "registration";
       }else if(registrationValidationService.loginExist(registrationForm.getLogin()))
       {
           model.addAttribute("invalidUser",true);
           return "registration";
       }


registrationValidationService.tryToRegisterUser(registrationForm);
userRepository.findAll().forEach(System.out::println);
        return "redirect:/login";

    }
}
