package com.example.rentcar.controller;

import com.example.rentcar.Entity.CarEntity;
import com.example.rentcar.repository.CarRepository;
import com.example.rentcar.service.UserContextService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class ManageCarController {

    private UserContextService userContextService;
    private CarRepository carRepository;

    public ManageCarController(UserContextService userContextService, CarRepository carRepository) {
        this.userContextService = userContextService;
        this.carRepository = carRepository;
    }


    @GetMapping("/manage-cars")
    public String manageCars(Model model) {

        List<CarEntity> cars = new ArrayList<>();
        carRepository.findAll().forEach(car -> cars.add(car));

        model.addAttribute("cars", cars);
        model.addAttribute("isAuthenticated", userContextService.isAuthetnticated());
        model.addAttribute("user",userContextService.getUserName());
        return "manage-cars";
    }

}
