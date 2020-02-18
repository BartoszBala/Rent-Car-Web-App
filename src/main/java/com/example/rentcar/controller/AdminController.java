package com.example.rentcar.controller;


import com.example.rentcar.Entity.OrderEntity;
import com.example.rentcar.repository.OrderRepository;
import com.example.rentcar.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AdminController {

    private OrderRepository orderRepository;

    @Autowired
    public AdminController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }



    @GetMapping("/admin")
    public String forwardToAdminPage(Model model){

        List<OrderEntity> orders = new ArrayList<>();

        orderRepository.findAll().forEach(order->orders.add(order));
        model.addAttribute("orders",orders);

        return "admin";
    }
}
