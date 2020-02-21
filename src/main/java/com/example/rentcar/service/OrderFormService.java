package com.example.rentcar.service;

import com.example.rentcar.model.OrderFormDto;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

@Service
public class OrderFormService {

    OrderFormDto orderFormDto;


    public void setOrderFormDto(OrderFormDto orderFormDto) {
        this.orderFormDto = orderFormDto;
    }

    public boolean areCorectDates() {
        try {
            if (orderFormDto.getDateOfStartRentCar().compareTo(orderFormDto.getDateOfFinishRentCar()) <= 0) {

                return true;
            }
        } catch (DateTimeParseException e) {

            e.printStackTrace();
        }
        return false;
    }

    public boolean pickUpDateIsCorrect() {
        try {
            if (LocalDate.parse(orderFormDto.getDateOfStartRentCar()).compareTo(LocalDate.now()) >= 0) {

                return true;
            }
        } catch (DateTimeParseException e) {
            e.printStackTrace();
        }
        return false;
    }
}
