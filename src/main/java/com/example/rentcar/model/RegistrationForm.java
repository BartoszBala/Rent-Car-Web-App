package com.example.rentcar.model;

import com.example.rentcar.Entity.UserEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.validation.constraints.*;


@Data
@NoArgsConstructor
@Service
public class RegistrationForm {


    @Size(min=5, max=30, message = "wymagany login ilość znaków pomiędzy 5 a 30")
    private String login;
   @Size(min=5, max=30,message = "wymagane hasło ilość znaków pomiędzy 5 a 30")
    private String password;
   @NotBlank(message = "pole nie może być puste")
    private String firstName;
    @NotBlank(message = "pole nie może być puste")
    private String lastName;
    @Email(message = "nieprawidłowy format email wprowadź w formacie example@email.com")
    private String email;
    @Pattern(regexp = "(\\+[0-9]{2}|0)[0-9]{9}", message = "numer telefonu w nieprawidłowym formacie, wprowadź w formacie +48500500500")
    private String phoneNumber;
    @NotBlank(message = "pole nie może być puste")
    private String street;
    @NotBlank(message = "pole nie może być puste")
    private String city;
    @NotBlank(message = "pole nie może być puste")
    private String postCode;


}
