package com.example.rentcar.controller;


import com.example.rentcar.Entity.CarEntity;
import com.example.rentcar.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class PrepareOrderController {

    CarRepository carRepository;

    @Autowired
    public PrepareOrderController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @PostMapping("/prepare-order")
    public String doOrder(Model model, CarEntity carEntity) {

        System.out.println(carEntity);
//        System.out.println((Long)model.getAttribute("id"));
CarEntity car = carRepository.findById(carEntity.getId()).get();
        System.out.println(car.getId());
        model.addAttribute("car",car );
        return "order";
    }

//    @GetMapping("/prepare-order")
//    public String doOrder(){
//
//        return "order";
//    }



}
