package com.example.rentcar.repository;

import com.example.rentcar.Entity.CarEntity;
import com.example.rentcar.model.Brand;
import com.example.rentcar.model.CarType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends CrudRepository<CarEntity,Long> {

    List<CarEntity> findByCarTypeIn(List<CarType> types);
List<CarEntity> findByCarTypeInAndBrandIn(List<CarType> types, List<Brand> brands);


}
