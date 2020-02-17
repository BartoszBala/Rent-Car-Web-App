package com.example.rentcar.model;

import com.example.rentcar.Entity.UserEntity;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Data
public class RegistrationForm {


   @Size(min=5, max=30, message = "wymagany login ilość znaków pomiędzy 5 a 30")
    private String login;
   @Size(min=5, max=30,message = "wymagane hasło ilość znaków pomiędzy 5 a 30")
    private String password;
   @NotBlank(message = "pole nie może być puste")
    private String firstName;
    @NotBlank(message = "pole nie może być puste")
    private String lastName;
    @NotBlank(message = "pole nie może być puste")
    private String email;
    @NotBlank(message = "pole nie może być puste")
    private String phoneNumber;
    @NotBlank(message = "pole nie może być puste")
    private String street;
    @NotBlank(message = "pole nie może być puste")
    private String city;
    @NotBlank(message = "pole nie może być puste")
    private String postCode;


}
