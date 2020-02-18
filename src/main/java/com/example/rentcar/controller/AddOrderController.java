package com.example.rentcar.controller;


import com.example.rentcar.Entity.CarEntity;
import com.example.rentcar.Entity.OrderEntity;
import com.example.rentcar.repository.CarRepository;
import com.example.rentcar.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;

@Controller
public class AddOrderController {


    private OrderRepository orderRepository;


    @Autowired
    public AddOrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    @PostMapping("/add-order")
    public String doOrder(OrderEntity orderEntity, Model model){

        orderEntity.setDateOfOrder(LocalDate.now());
        orderEntity.setCarEntity((CarEntity) model.getAttribute("car"));
orderRepository.save(orderEntity);

        return "redirect:/home";
    }
}
