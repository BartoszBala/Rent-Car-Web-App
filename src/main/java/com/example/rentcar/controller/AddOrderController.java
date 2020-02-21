package com.example.rentcar.controller;


import com.example.rentcar.Entity.CarEntity;
import com.example.rentcar.Entity.OrderEntity;
import com.example.rentcar.model.OrderFormDto;
import com.example.rentcar.repository.CarRepository;
import com.example.rentcar.repository.OrderRepository;
import com.example.rentcar.repository.UserRepository;
import com.example.rentcar.service.OrderFormService;
import com.example.rentcar.service.OrderService;
import exception.InvalidDateFormatException;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AddOrderController {


    private OrderRepository orderRepository;
    private CarRepository carRepository;
    private UserRepository userRepository;
    private OrderService orderService;
    private OrderFormService orderFormService;


    public AddOrderController(OrderRepository orderRepository, CarRepository carRepository, UserRepository userRepository, OrderService orderService, OrderFormService orderFormService) {
        this.orderRepository = orderRepository;
        this.carRepository = carRepository;
        this.userRepository = userRepository;
        this.orderService = orderService;
        this.orderFormService = orderFormService;
    }

    @PostMapping("/add-order")
    public String doOrder(OrderFormDto orderFormDto, CarEntity carEntity, Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("isAuthenticated", !(authentication instanceof AnonymousAuthenticationToken));
        orderFormService.setOrderFormDto(orderFormDto);
        carEntity=carRepository.findById(carEntity.getId()).get();
        if (!orderFormService.pickUpDateIsCorrect()) {
            model.addAttribute("car", carEntity);
            model.addAttribute("orderFormDto", orderFormDto);
            model.addAttribute("errorStartDate", true);
            return "order";
        }

        if (orderFormService.areCorectDates()) {
            OrderEntity orderEntity = orderService.createOrderEntity(orderFormDto, carEntity);

            if (orderEntity.getDateOfFinishRentCar() == null || orderEntity.getDateOfStartRentCar() == null) {
                model.addAttribute("car", carEntity);
                model.addAttribute("orderFormDto", orderFormDto);
                model.addAttribute("errorStartDate", true);
                model.addAttribute("errorDate", true);
                return "order";

            } else {
                BigDecimal costOfOrder = orderService.calculateCostOfOrder(orderFormDto, BigDecimal.valueOf(carEntity.getPrice())); // fixme nie przekazuj całego obiektu a tylko price
                orderEntity.setOrderCost(costOfOrder);
                model.addAttribute("car", carEntity);
                model.addAttribute("cost", costOfOrder);
                model.addAttribute("orderNumber", orderRepository.save(orderEntity).getId());
                return "order-confirmation";
            }
        } else {

            model.addAttribute("car", carEntity);
            model.addAttribute("orderFormDto", orderFormDto);
            model.addAttribute("errorDate", true);

            return "order";
        }
    }

}
