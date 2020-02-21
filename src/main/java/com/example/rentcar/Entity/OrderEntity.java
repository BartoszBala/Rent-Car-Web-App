package com.example.rentcar.Entity;


import com.example.rentcar.model.OrderStatus;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@ToString
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //sprawdzić co to oznacza
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY, optional=false)
    @JoinColumn(name="car_id", nullable = false)
    private CarEntity carEntity;
    @ManyToOne(fetch = FetchType.LAZY, optional=false)
    @JoinColumn(name="user_id", nullable = false)
    private UserEntity userEntity;
    private LocalDate dateOfOrder;
    private LocalDate dateOfStartRentCar;
    private LocalDate dateOfFinishRentCar;
    private String additionalInformation;
    private BigDecimal orderCost;
    private  boolean orderCompleted;
    private OrderStatus orderStatus;








}
