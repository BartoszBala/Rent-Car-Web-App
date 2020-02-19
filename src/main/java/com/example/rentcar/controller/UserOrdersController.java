package com.example.rentcar.controller;


import com.example.rentcar.Entity.CarEntity;
import com.example.rentcar.Entity.OrderEntity;
import com.example.rentcar.repository.OrderRepository;
import com.example.rentcar.repository.UserRepository;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserOrdersController {


 private OrderRepository orderRepository;
 private  UserRepository userRepository;

    public UserOrdersController(OrderRepository orderRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/orders-history")
    public String showUserOrders(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        List<OrderEntity> orderEntityList = new ArrayList<>();
        orderRepository.findAllByUserEntity(userRepository.findByLogin(authentication.getName())).forEach(order -> orderEntityList.add((OrderEntity) order));
        model.addAttribute("userOrders", orderEntityList);
        model.addAttribute("isAuthenticated",!(authentication instanceof AnonymousAuthenticationToken));


        return "user-orders";
    }
}
