package com.example.rentcar.controller;


import com.example.rentcar.Entity.CarEntity;
import com.example.rentcar.Entity.OrderEntity;
import com.example.rentcar.Entity.UserEntity;
import com.example.rentcar.model.OrderFormDto;
import com.example.rentcar.repository.OrderRepository;
import com.example.rentcar.repository.UserRepository;
import com.example.rentcar.service.OrderFormService;
import com.example.rentcar.service.OrderService;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UpdateController {

    OrderFormService orderFormService;
    OrderRepository orderRepository;
    OrderService orderService;
    UserRepository userRepository;

    public UpdateController(OrderFormService orderFormService, OrderRepository orderRepository, OrderService orderService, UserRepository userRepository) {
        this.orderFormService = orderFormService;
        this.orderRepository = orderRepository;
        this.orderService = orderService;
        this.userRepository = userRepository;
    }

    @PostMapping("/update")
    public String updateOrder(OrderFormDto orderFormDto, @RequestParam(defaultValue = "1") Long id, Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        orderFormService.setOrderFormDto(orderFormDto);
        CarEntity carEntity = orderRepository.findById(id).get().getCarEntity();

        if (!orderFormService.pickUpDateIsCorrect()) {
            model.addAttribute("car", carEntity);
            model.addAttribute("orderFormDto", orderFormDto);
            model.addAttribute("errorStartDate", true);
            model.addAttribute("orderId",id);
            return "update-order";
        }

        if (orderFormService.areCorectDates()) {
           UserEntity userEntity = userRepository.findByLogin(authentication.getName());
           if(authentication.getName().equals("admin")){

               userEntity=orderRepository.findById(id).get().getUserEntity();
           }

            OrderEntity orderEntity = orderService.createOrderEntity(orderFormDto, carEntity,userEntity);

            if (orderEntity.getDateOfFinishRentCar() == null || orderEntity.getDateOfStartRentCar() == null) {
                model.addAttribute("car", carEntity);
                model.addAttribute("orderFormDto", orderFormDto);
                model.addAttribute("errorStartDate", true);
                model.addAttribute("errorDate", true);
                model.addAttribute("orderId",id);
                return "update-order";

            } else {
                BigDecimal costOfOrder = orderService.calculateCostOfOrder(orderFormDto, BigDecimal.valueOf(carEntity.getPrice()));
                orderEntity.setOrderCost(costOfOrder);
                orderEntity.setId(id);
                orderRepository.save(orderEntity).getId();

                if(authentication.getName().equals("admin")){
                    return "redirect:/admin";

                }

                return "redirect:/orders-history";
            }
        } else {

                model.addAttribute("car", carEntity);
                model.addAttribute("orderFormDto", orderFormDto);
                model.addAttribute("errorDate", true);
            model.addAttribute("orderId",id);

                return "update-order";
        }


       // całą tę logikę należało by poprawić
    }
}
