package com.example.rentcar.model;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@Service
public class LoginForm {            //to jest taki trochę obiekt DTO

    @Size(min=5, max=30, message = "wymagany login ilość znaków pomiędzy 5 a 30")
    private String login;
    @Size(min=5, max=30,message = "wymagane hasło ilość znaków pomiędzy 5 a 30")
    private String password;
}
