package com.example.rentcar.repository;

import com.example.rentcar.Entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

    UserEntity findByLogin(String login);
    boolean existsByLogin(String login);
}
