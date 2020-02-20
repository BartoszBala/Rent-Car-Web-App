package com.example.rentcar.controller;


import com.example.rentcar.repository.CarRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ShowCarController {

    private CarRepository carRepository;

    public ShowCarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @RequestMapping("/show-car")
    public String showProduct(@RequestParam(defaultValue = "1") Long id, Model model) {

        model.addAttribute("car", carRepository.findById(id).get());

        return "product-card";
    }
}
