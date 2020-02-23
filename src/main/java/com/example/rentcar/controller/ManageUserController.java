package com.example.rentcar.controller;


import com.example.rentcar.Entity.CarEntity;
import com.example.rentcar.Entity.UserEntity;
import com.example.rentcar.repository.UserRepository;
import com.example.rentcar.service.UserContextService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ManageUserController {


   private UserRepository userRepository;
   private UserContextService userContextService;

    public ManageUserController(UserRepository userRepository, UserContextService userContextService) {
        this.userRepository = userRepository;
        this.userContextService = userContextService;
    }

    @GetMapping("/manage-users")
public String manageUserByAdmin(Model model){

    List<UserEntity> userEntities = new ArrayList<>();

    userRepository.findAll().forEach(x->userEntities.add(x));


    model.addAttribute("users",userEntities);
    model.addAttribute("isAuthenticated",userContextService.isAuthetnticated());
        model.addAttribute("user",userContextService.getUserName());

    return "manage-user";
}


}
