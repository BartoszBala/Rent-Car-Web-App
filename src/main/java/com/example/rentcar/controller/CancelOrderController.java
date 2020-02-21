package com.example.rentcar.controller;

import com.example.rentcar.repository.OrderRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CancelOrderController {


    private OrderRepository orderRepository;

    public CancelOrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @PostMapping("/cancel")
    public String cancelOrder(Long orderId){

       orderRepository.delete(orderRepository.findById(orderId).get());
        System.out.println("test");

        return "redirect:/orders-history";
    }



}
