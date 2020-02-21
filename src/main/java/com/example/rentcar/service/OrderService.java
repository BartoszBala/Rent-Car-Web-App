package com.example.rentcar.service;

import com.example.rentcar.Entity.CarEntity;

import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

import com.example.rentcar.Entity.OrderEntity;
import com.example.rentcar.model.OrderFormDto;

import com.example.rentcar.repository.CarRepository;
import com.example.rentcar.repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;


@Service
public class OrderService {

    private CarRepository carRepository;
    private UserRepository userRepository;

    public OrderService(CarRepository carRepository, UserRepository userRepository) {
        this.carRepository = carRepository;
        this.userRepository = userRepository;
    }

    public BigDecimal calculateCostOfOrder(OrderFormDto orderFormDto, BigDecimal price) {

        long days = DAYS.between( LocalDate.parse(orderFormDto.getDateOfStartRentCar()),LocalDate.parse(orderFormDto.getDateOfFinishRentCar()));

        return BigDecimal.valueOf(days).multiply((price));

    }

    public OrderEntity createOrderEntity(OrderFormDto orderFormDto, CarEntity carEntity) {

        OrderEntity orderEntity;

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        orderEntity = new OrderEntity();
        try {
            orderEntity.setDateOfStartRentCar(LocalDate.parse(orderFormDto.getDateOfStartRentCar()).plusDays(1));
            orderEntity.setDateOfFinishRentCar(LocalDate.parse(orderFormDto.getDateOfFinishRentCar()).plusDays(1));
        } catch (DateTimeParseException e) {
            e.printStackTrace();
        }

        orderEntity.setAdditionalInformation(orderFormDto.getAdditionalInformation());
        orderEntity.setDateOfOrder(LocalDate.now());
        orderEntity.setCarEntity(carEntity);
        orderEntity.setUserEntity(userRepository.findByLogin(authentication.getName()));


        return orderEntity;
    }


}
