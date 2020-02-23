package com.example.rentcar.controller;


import com.example.rentcar.Entity.CarEntity;
import com.example.rentcar.Entity.OrderEntity;
import com.example.rentcar.model.OrderFormDto;
import com.example.rentcar.repository.CarRepository;
import com.example.rentcar.service.UserContextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PrepareOrderController {

    CarRepository carRepository;
    OrderFormDto orderFormDto;
    UserContextService userContextService;

    public PrepareOrderController(CarRepository carRepository, OrderFormDto orderFormDto, UserContextService userContextService) {
        this.carRepository = carRepository;
        this.orderFormDto = orderFormDto;
        this.userContextService = userContextService;
    }

    @PostMapping("/prepare-order")
    public String doOrder(Model model, CarEntity carEntity) {
        model.addAttribute("isAuthenticated",userContextService.isAuthetnticated());
        model.addAttribute("user",userContextService.getUserName());

        model.addAttribute("orderFormDto", orderFormDto);
        CarEntity car = carRepository.findById(carEntity.getId()).get();
        model.addAttribute("car", car);
        return "order";
    }



}
