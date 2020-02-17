package com.example.rentcar.controller;

import com.example.rentcar.Entity.UserEntity;
import com.example.rentcar.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("api/public")
public class PublicRestApiRestController {

    UserRepository userRepository;

    public PublicRestApiRestController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public List<UserEntity> users(){

        return getUsers();

    }

    public <T> List<T> getUsers() {   //fixme
        Iterator iterator = userRepository.findAll().iterator();
        List<T> cars = new ArrayList<>();

        while (iterator.hasNext()) {
            cars.add((T) iterator.next());
        }
        return cars;
    }

}
