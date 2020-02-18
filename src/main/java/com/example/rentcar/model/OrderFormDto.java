package com.example.rentcar.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;


@Service
@Getter
@NoArgsConstructor
@Data
public class OrderFormDto {

    private String dateOfStartRentCar;
    private String dateOfFinishRentCar;
    private String additionalInformation;

}
