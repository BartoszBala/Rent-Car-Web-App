package com.example.rentcar.mapper;

import com.example.rentcar.Entity.UserEntity;
import com.example.rentcar.model.RegistrationForm;

public class MapperUser {

    private MapperUser() {      // zabezpieczenie przed stworzeniem instancji klasy



    }
    public static UserEntity mapToUserEntity(RegistrationForm registrationForm){

        return UserEntity.builder().login(registrationForm.getLogin())
                .password(registrationForm.getPassword())
                .firstName(registrationForm.getFirstName())
                .lastName(registrationForm.getLastName())
                .email(registrationForm.getEmail())
                .phoneNumber(registrationForm.getPhoneNumber())
                .postCode(registrationForm.getPostCode())
                .street(registrationForm.getStreet())
                .city(registrationForm.getCity())
                .build();
    }


}
