package com.example.rentcar.Entity;

import com.example.rentcar.model.Brand;
import com.example.rentcar.model.CarColour;
import com.example.rentcar.model.CarType;
import com.example.rentcar.model.OrderStatus;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@ToString
public class CarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String vin;
    private Brand brand;
    private String model;
    private CarType carType;
    private double enginePower;
    private double mileage;
    private CarColour carColour;
    private double price;
    private String imagePath;
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL )
    private List<OrderEntity> orderList;



}
