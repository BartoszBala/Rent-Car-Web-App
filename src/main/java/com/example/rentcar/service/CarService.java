package com.example.rentcar.service;

import com.example.rentcar.Entity.CarEntity;
import com.example.rentcar.model.CarDto;
import com.example.rentcar.repository.CarRepository;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    private CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public void addNewCarToDataBase(CarDto carDto){

        CarEntity carEntity =CarEntity.builder().millage(carDto.getMillage()).power(carDto.getPower()).price(carDto.getPrice())
                .vin(carDto.getVin()).model(carDto.getModel()).build();

        carRepository.save(carEntity);

    }
}
