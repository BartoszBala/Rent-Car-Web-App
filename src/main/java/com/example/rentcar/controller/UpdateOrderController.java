package com.example.rentcar.controller;


import com.example.rentcar.repository.CarRepository;
import com.example.rentcar.repository.OrderRepository;
import com.example.rentcar.service.UserContextService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UpdateOrderController {


    private OrderRepository orderRepository;
    private UserContextService userContextService;

    public UpdateOrderController(OrderRepository orderRepository, UserContextService userContextService) {
        this.orderRepository = orderRepository;
        this.userContextService = userContextService;
    }

    @PostMapping("/updateOrder")
    public String updateOrder(Long orderId, Model model){

        model.addAttribute("orderId",orderId);
        model.addAttribute("car",orderRepository.findById(orderId).get().getCarEntity());
        model.addAttribute("isAuthenticated",userContextService.isAuthetnticated());

        return "update-order";
    }


}
