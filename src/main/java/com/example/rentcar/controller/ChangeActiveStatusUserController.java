package com.example.rentcar.controller;

import com.example.rentcar.Entity.UserEntity;
import com.example.rentcar.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ChangeActiveStatusUserController {

    UserRepository userRepository;

    public ChangeActiveStatusUserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @GetMapping("disactiveUser/{id}")
    public String changeStatusOfUser(@PathVariable("id") long id)
    {
  UserEntity userEntity = userRepository.findById(id).orElseThrow(()-> new RuntimeException());
  userEntity.setActived(0);
  userRepository.save(userEntity);

        return "redirect:/manage-users";
    }

    @GetMapping("activeUser/{id}")
    public String changeStatusOfUserForActive(@PathVariable("id") long id)
    {
        UserEntity userEntity = userRepository.findById(id).orElseThrow(()-> new RuntimeException());
        userEntity.setActived(1);
        userRepository.save(userEntity);

        return "redirect:/manage-users";
    }
}
