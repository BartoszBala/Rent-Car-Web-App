package com.example.rentcar.repository;

import com.example.rentcar.Entity.OrderEntity;
import com.example.rentcar.Entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<OrderEntity, Long> {

    List<OrderEntity> findAllByUserEntity(UserEntity userEntity);


}
