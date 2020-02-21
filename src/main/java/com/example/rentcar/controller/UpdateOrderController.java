package com.example.rentcar.controller;


import com.example.rentcar.repository.CarRepository;
import com.example.rentcar.repository.OrderRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UpdateOrderController {


    private OrderRepository orderRepository;

    public UpdateOrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;

    }

    @PostMapping("/updateOrder")
    public String updateOrder(Long orderId, Model model){

        model.addAttribute("orderId",orderId);
        model.addAttribute("car",orderRepository.findById(orderId).get().getCarEntity());

        return "update-order";
    }
}
