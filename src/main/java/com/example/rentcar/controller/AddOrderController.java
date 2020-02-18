package com.example.rentcar.controller;


import com.example.rentcar.Entity.CarEntity;
import com.example.rentcar.Entity.OrderEntity;
import com.example.rentcar.model.OrderFormDto;
import com.example.rentcar.repository.CarRepository;
import com.example.rentcar.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;

@Controller
public class AddOrderController {


    private OrderRepository orderRepository;
    private CarRepository carRepository;


    public AddOrderController(OrderRepository orderRepository, CarRepository carRepository) {
        this.orderRepository = orderRepository;
        this.carRepository = carRepository;
    }

    @PostMapping("/add-order")
    public String doOrder(OrderFormDto orderFormDto, CarEntity carEntity) {
        OrderEntity orderEntity = new OrderEntity();

        orderEntity.setDateOfStartRentCar(LocalDate.parse(orderFormDto.getDateOfStartRentCar()));
        orderEntity.setDateOfFinishRentCar(LocalDate.parse(orderFormDto.getDateOfFinishRentCar()));
        orderEntity.setAdditionalInformation(orderFormDto.getAdditionalInformation());
        orderEntity.setDateOfOrder(LocalDate.now());
       orderEntity.setCarEntity(carRepository.findById(carEntity.getId()).get());
        orderRepository.save(orderEntity);

        orderRepository.findAll().forEach(x-> System.out.println(x));

        return "redirect:/home";
    }
}
