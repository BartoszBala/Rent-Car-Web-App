package com.example.rentcar.controller;


import com.example.rentcar.Entity.CarEntity;
import com.example.rentcar.Entity.OrderEntity;
import com.example.rentcar.model.OrderFormDto;
import com.example.rentcar.repository.CarRepository;
import com.example.rentcar.repository.OrderRepository;
import com.example.rentcar.repository.UserRepository;
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


    public AddOrderController(OrderRepository orderRepository, CarRepository carRepository, UserRepository userRepository, OrderService orderService) {
        this.orderRepository = orderRepository;
        this.carRepository = carRepository;
        this.userRepository = userRepository;
        this.orderService = orderService;
    }

    @PostMapping("/add-order")
    public String doOrder(OrderFormDto orderFormDto, CarEntity carEntity, Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("isAuthenticated",!(authentication instanceof AnonymousAuthenticationToken));
        if (!pickUpDateIsCorrect(orderFormDto)) {

            model.addAttribute("car", carRepository.findById(carEntity.getId()).get());
            model.addAttribute("orderFormDto", orderFormDto);
            model.addAttribute("errorStartDate", true);
            return "order";

        }


        if (areCorectDates(orderFormDto)) {
            OrderEntity orderEntity = createOrderEntity(orderFormDto, carEntity);

            if (orderEntity.getDateOfFinishRentCar() == null || orderEntity.getDateOfStartRentCar() == null) {
                model.addAttribute("car", carRepository.findById(carEntity.getId()).get());
                model.addAttribute("orderFormDto", orderFormDto);
                model.addAttribute("errorStartDate", true);
                model.addAttribute("errorDate", true);
                return "order";

            } else {


                BigDecimal costOfOrder = orderService.calculateCostOfOrder(orderFormDto, carRepository.findById(carEntity.getId()).get()); // fixme nie przekazuj całego obiektu a tylko price
                orderEntity.setOrderCost(costOfOrder);
                model.addAttribute("car", carRepository.findById(carEntity.getId()).get());
                model.addAttribute("cost", costOfOrder);
                model.addAttribute("orderNumber", orderRepository.save(orderEntity).getId());
                return "order-confirmation";
            }
        } else {

            model.addAttribute("car", carRepository.findById(carEntity.getId()).get());
            model.addAttribute("orderFormDto", orderFormDto);
            model.addAttribute("errorDate", true);

            return "order";
        }
    }

    private OrderEntity createOrderEntity(OrderFormDto orderFormDto, CarEntity carEntity) {

        OrderEntity orderEntity = null;

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        orderEntity = new OrderEntity();
        try {
            orderEntity.setDateOfStartRentCar(LocalDate.parse(orderFormDto.getDateOfStartRentCar()));
            orderEntity.setDateOfFinishRentCar(LocalDate.parse(orderFormDto.getDateOfFinishRentCar()));
        } catch (DateTimeParseException e) {
            e.printStackTrace();
        }

        orderEntity.setAdditionalInformation(orderFormDto.getAdditionalInformation());
        orderEntity.setDateOfOrder(LocalDate.now());
        orderEntity.setCarEntity(carRepository.findById(carEntity.getId()).get());
        orderEntity.setUserEntity(userRepository.findByLogin(authentication.getName()));


        return orderEntity;
    }


    private boolean areCorectDates(OrderFormDto orderFormDto) {
        try {
            if (orderFormDto.getDateOfStartRentCar().compareTo(orderFormDto.getDateOfFinishRentCar()) <= 0) {

                return true;
            }
        } catch (DateTimeParseException e) {

            e.printStackTrace();
        }
        return false;
    }

    private boolean pickUpDateIsCorrect(OrderFormDto orderFormDto) {
        try {
            if (LocalDate.parse(orderFormDto.getDateOfStartRentCar()).compareTo(LocalDate.now()) >= 0) {

                return true;
            }
        } catch (DateTimeParseException e) {
            e.printStackTrace();
        }
        return false;
    }
}
