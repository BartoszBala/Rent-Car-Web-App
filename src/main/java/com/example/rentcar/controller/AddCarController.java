package com.example.rentcar.controller;

import com.example.rentcar.model.Brand;
import com.example.rentcar.model.CarColour;
import com.example.rentcar.model.CarDto;
import com.example.rentcar.model.CarType;
import com.example.rentcar.service.CarService;
import com.example.rentcar.service.UserContextService;
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
    private UserContextService userContextService;

    public AddCarController(CarService carService, UserContextService userContextService) {
        this.carService = carService;
        this.userContextService = userContextService;
    }


    @GetMapping("/addcar")
    public String addCarShowView(Model model) {

       Brand[] brands = Brand.values();
       CarType[] types = CarType.values();
        CarColour[] carColours = CarColour.values();
        CarDto carDto = new CarDto();
        model.addAttribute("carDto", carDto);
        model.addAttribute("brands", Arrays.asList(brands));
        model.addAttribute("types", Arrays.asList(types));
        model.addAttribute("colours", Arrays.asList(carColours));
        model.addAttribute("isAuthenticated",userContextService.isAuthetnticated());

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
