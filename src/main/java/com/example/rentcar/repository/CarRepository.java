package com.example.rentcar.repository;

import com.example.rentcar.Entity.CarEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends CrudRepository<CarEntity,Long> {
}
