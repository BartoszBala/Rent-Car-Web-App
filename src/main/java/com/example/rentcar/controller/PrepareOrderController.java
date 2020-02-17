package com.example.rentcar.controller;


import com.example.rentcar.Entity.CarEntity;
import com.example.rentcar.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class PrepareOrderController {

    @Autowired
    CarRepository carRepository;

    @RequestMapping("/prepare-order")
    public String doOrder(Model model) {
        System.out.println((Long)model.getAttribute("id"));
CarEntity car = carRepository.findById((Long)model.getAttribute("id")).get();
        model.addAttribute("car",car );
        return "order";
    }

}
