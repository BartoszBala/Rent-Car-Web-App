package com.example.rentcar.service;

import com.example.rentcar.Entity.OrderEntity;
import com.example.rentcar.repository.CarRepository;
import com.example.rentcar.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.time.LocalDate;

@Service
public class OrderService {

    private OrderRepository orderRepo;
    private CarRepository carRepository;

    public void createOrder(Model model){

        OrderEntity orderEntity =OrderEntity.builder()
                .carEntity(carRepository.findById((Long) model
                        .getAttribute("id")).get()).dateOfOrder(LocalDate.now()).build(); //fixme

        orderRepo.save(orderEntity);



    }


}
