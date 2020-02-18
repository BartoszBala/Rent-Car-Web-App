package com.example.rentcar.mapper;

import com.example.rentcar.Entity.UserEntity;
import com.example.rentcar.model.RegistrationForm;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MapperUser {


   private static PasswordEncoder passwordEncoder;   //fixme bo to już mam w klasie websecconfig


    public MapperUser(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }



    public static UserEntity mapToUserEntity(RegistrationForm registrationForm){



        return UserEntity.builder().login(registrationForm.getLogin())
                .password(passwordEncoder.encode(registrationForm.getPassword()))
                .firstName(registrationForm.getFirstName())
                .lastName(registrationForm.getLastName())
                .email(registrationForm.getEmail())
                .phoneNumber(registrationForm.getPhoneNumber())
                .postCode(registrationForm.getPostCode())
                .street(registrationForm.getStreet())
                .city(registrationForm.getCity())
                .actived(1)
                .roles("USER")
                .permissions("")
                .build();
    }


}
