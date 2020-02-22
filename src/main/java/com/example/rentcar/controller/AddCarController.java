package com.example.rentcar.controller;

import com.example.rentcar.Entity.CarEntity;
import com.example.rentcar.model.Brand;
import com.example.rentcar.model.CarDto;
import com.example.rentcar.model.RegistrationForm;
import com.example.rentcar.service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Arrays;

@Controller
public class AddCarController {

    private CarService carService;

    public AddCarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/add-car")
    public String addCarShowView(Model model) {

       Brand[] brands = Brand.values();
        CarDto carDto = new CarDto();
        model.addAttribute("carDto", carDto);
        model.addAttribute("brands", Arrays.asList(brands));

        return "add-car";
    }

    @PostMapping("/addCar")
    public String addCar(@Valid CarDto carDto, BindingResult bindingResult, Model model) {//dodanie Valid super działa z adnotacjami z klasy

        if (bindingResult.hasErrors()) {
            return "add-car";
        }

        carService.addNewCarToDataBase(carDto);

        return "redirect:/manage-cars";

    }


}
