package com.example.rentcar.controller;

import com.example.rentcar.repository.OrderRepository;
import com.example.rentcar.service.UserContextService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CancelOrderController {


    private OrderRepository orderRepository;
    private UserContextService userContextService;

    public CancelOrderController(OrderRepository orderRepository, UserContextService userContextService) {
        this.orderRepository = orderRepository;
        this.userContextService = userContextService;
    }

    @PostMapping("/cancel")
    public String cancelOrder(Long orderId, Model model){


        model.addAttribute("isAuthenticated",userContextService.isAuthetnticated());
        model.addAttribute("user",userContextService.getUserName());
       orderRepository.delete(orderRepository.findById(orderId).get());
        System.out.println("test");
        if(userContextService.getUserName().equals("admin")){
            return "redirect:/admin";
        }
        return "redirect:/orders-history";
    }



}
