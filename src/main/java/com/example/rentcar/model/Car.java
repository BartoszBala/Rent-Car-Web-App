package com.example.rentcar.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class Car {

    private String vin;
    private String brand;
    private String model;
    private CarType carType;
    private double millage;
    private CarColour carColour;
    private double price;
    private String imagePath;


}
