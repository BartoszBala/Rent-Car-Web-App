package com.example.rentcar.controller;

import com.example.rentcar.Entity.CarEntity;
import com.example.rentcar.model.Car;
import com.example.rentcar.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


@Controller
public class HomeController {

    @Autowired
    private CarRepository carRepository;

    @GetMapping("/home")
    public String welcome(Model model) {


        List<CarEntity> cars = getCarEntities();


        model.addAttribute("cars", cars);
        return "home";
    }






   private <T> List<T> getCarEntities() {   //fixme
        Iterator iterator = carRepository.findAll().iterator();
        List<T> cars = new ArrayList<>();

        while (iterator.hasNext()) {
            cars.add((T) iterator.next());
        }
        return cars;
    }
}
