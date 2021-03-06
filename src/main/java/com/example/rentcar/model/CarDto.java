package com.example.rentcar.model;


import com.example.rentcar.Entity.OrderEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Data
@NoArgsConstructor
@Service
public class CarDto {

    @Size(min = 15, max =17, message = "pole musi zawierać 17 znaków")
    private String vin;
    @NotBlank(message = "wprowadz model")
    private String model;
    @DecimalMax(value = "500.00",message = "wprowadz wartosc z przedziału 50.00 do 500.00")
    private double power;
    @Digits(integer = 6, fraction = 0, message = "wprowadz wartosc z przedziału 0 do 999999")
    private double millage;
    @DecimalMin(value="100.00",message = "wprowadz wartosc z przedziału 100.00 do 10000.00")
    private double price;
    @NotNull(message = "wybierz markę")
    private Brand brand;
    @NotNull(message = "wybierz typ")
    private CarType type;
    @NotNull(message = "wybierz kolor")
    private CarColour colour;

}
