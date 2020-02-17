package com.example.rentcar.model;

import com.example.rentcar.Entity.UserEntity;
import lombok.Data;


@Data
public class RegistrationForm {

    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String street;
    private String city;
    private String postCode;


}
