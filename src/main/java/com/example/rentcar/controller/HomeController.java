package com.example.rentcar.controller;

import com.example.rentcar.Entity.CarEntity;
import com.example.rentcar.model.Brand;
import com.example.rentcar.model.CarType;
import com.example.rentcar.model.FilterDto;
import com.example.rentcar.repository.CarRepository;
import com.example.rentcar.service.UserContextService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;


@Controller
public class HomeController {

    private UserContextService userContextService;
    private CarRepository carRepository;

    public HomeController(UserContextService userContextService, CarRepository carRepository) {
        this.userContextService = userContextService;
        this.carRepository = carRepository;
    }

    @GetMapping("/home")
    public String welcome(Model model) {

        List<CarEntity> cars = new ArrayList<>();

        carRepository.findAll().forEach(car->cars.add(car));

        CarType[] carTypes = CarType.values();
        Brand[] carBrands = Brand.values();

        model.addAttribute("carTypes", Arrays.asList(carTypes));
        model.addAttribute("carBrands", Arrays.asList(carBrands));
        model.addAttribute("selectedTypes", Arrays.asList(carTypes));
        model.addAttribute("selectedBrands", Arrays.asList(carBrands));
        FilterDto filterDto = new FilterDto();


        if ((model.getAttribute("filterDto")) != null) {
            List<String> types = ((FilterDto) model.getAttribute("filterDto")).getCarTypes();
            List<String> brands = ((FilterDto) model.getAttribute("filterDto")).getBrands();

            List<CarType> carTypeList = types.stream().map(t -> CarType.valueOf(t)).collect(Collectors.toList());
            List<Brand> brandTypeList = brands.stream().map(t -> Brand.valueOf(t)).collect(Collectors.toList());
            model.addAttribute("cars", carRepository.findByCarTypeInAndBrandIn(carTypeList, brandTypeList));
            model.addAttribute("selectedTypes", carTypeList);
            model.addAttribute("selectedBrands", brandTypeList);
        } else {
            model.addAttribute("cars", cars);
        }
        model.addAttribute("filterDto", filterDto);
        model.addAttribute("isAuthenticated", userContextService.isAuthetnticated());
        model.addAttribute("user", userContextService.getUserName());
        return "home";
    }


    @PostMapping("/home")
    public String doPost(FilterDto filterDto, Model model) {

        model.addAttribute("filterDto", filterDto);

        return welcome(model);
    }


}
