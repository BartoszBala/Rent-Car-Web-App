package com.example.rentcar.service;

import com.example.rentcar.Entity.CarEntity;

import java.time.temporal.ChronoUnit;

import com.example.rentcar.model.OrderFormDto;

import org.springframework.stereotype.Service;


import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;


@Service
public class OrderService {


    public BigDecimal calculateCostOfOrder(OrderFormDto orderFormDto, CarEntity carEntity) {

        long days = DAYS.between( LocalDate.parse(orderFormDto.getDateOfStartRentCar()),LocalDate.parse(orderFormDto.getDateOfFinishRentCar()));

        return BigDecimal.valueOf(days).multiply(BigDecimal.valueOf(carEntity.getPrice()));


    }


}
