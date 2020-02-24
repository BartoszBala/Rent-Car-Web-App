package com.example.rentcar.controller;


import com.example.rentcar.Entity.CarEntity;
import com.example.rentcar.Entity.OrderEntity;
import com.example.rentcar.Entity.UserEntity;
import com.example.rentcar.model.OrderFormDto;
import com.example.rentcar.repository.CarRepository;
import com.example.rentcar.repository.OrderRepository;
import com.example.rentcar.repository.UserRepository;
import com.example.rentcar.service.OrderFormService;
import com.example.rentcar.service.OrderService;
import com.example.rentcar.service.UserContextService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import java.math.BigDecimal;

@Controller
public class AddOrderController {


    private OrderRepository orderRepository;
    private CarRepository carRepository;
    private UserRepository userRepository;
    private OrderService orderService;
    private OrderFormService orderFormService;
    private UserContextService userContextService;


    public AddOrderController(OrderRepository orderRepository, CarRepository carRepository, UserRepository userRepository, OrderService orderService, OrderFormService orderFormService, UserContextService userContextService) {
        this.orderRepository = orderRepository;
        this.carRepository = carRepository;
        this.userRepository = userRepository;
        this.orderService = orderService;
        this.orderFormService = orderFormService;
        this.userContextService = userContextService;
    }

    @PostMapping("/add-order")
    public String doOrder(OrderFormDto orderFormDto, CarEntity carEntity, Model model) {

        model.addAttribute("isAuthenticated", userContextService.isAuthetnticated());
        model.addAttribute("user",userContextService.getUserName());
        orderFormService.setOrderFormDto(orderFormDto);
        carEntity=carRepository.findById(carEntity.getId()).get();
        if (!orderFormService.pickUpDateIsCorrect()) {
            model.addAttribute("car", carEntity);
            model.addAttribute("orderFormDto", orderFormDto);
            model.addAttribute("errorStartDate", true);
            return "order";
        }

        if (orderFormService.areCorectDates()) {
            UserEntity userEntity = userRepository.findByLogin(userContextService.getUserName());

            OrderEntity orderEntity = orderService.createOrderEntity(orderFormDto, carEntity,userEntity);

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
