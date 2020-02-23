package com.example.rentcar.controller;


import com.example.rentcar.Entity.OrderEntity;
import com.example.rentcar.repository.OrderRepository;
import com.example.rentcar.repository.UserRepository;
import com.example.rentcar.service.UserContextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AdminController {

    private OrderRepository orderRepository;
    private UserContextService userContextService;

    public AdminController(OrderRepository orderRepository, UserContextService userContextService) {
        this.orderRepository = orderRepository;
        this.userContextService = userContextService;
    }

    @GetMapping("/admin")
    public String forwardToAdminPage(Model model){

        List<OrderEntity> orders = new ArrayList<>();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        orderRepository.findAll().forEach(order->orders.add(order));
        model.addAttribute("orders",orders);
        model.addAttribute("isAuthenticated",userContextService.isAuthetnticated());
        model.addAttribute("user",userContextService.getUserName());
        return "admin";
    }
}
