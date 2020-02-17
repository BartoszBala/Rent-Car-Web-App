package com.example.rentcar.Entity;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //sprawdzić co to oznacza
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY, optional=false)
    @JoinColumn(name="car_id", nullable = false)
    private CarEntity carEntity;
    private LocalDate dateOfOrder;
    private LocalDate dateOfStartRentCar;
    private LocalDate dateOfFinishRentCar;








}
