package com.example.rentcar.service;

import com.example.rentcar.mapper.MapperUser;
import com.example.rentcar.model.RegistrationForm;
import com.example.rentcar.repository.UserRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


@Service
@NoArgsConstructor
public class RegistrationValidationService {

    UserRepository userRepository;

    @Autowired
    public RegistrationValidationService(UserRepository userRep) {

        this.userRepository = userRep;
    }

    public boolean loginExist(String login) {

        return userRepository.existsByLogin(login);
    }


    public void tryToRegisterUser(RegistrationForm registrationForm) {

        try {
            userRepository.save(MapperUser.mapToUserEntity(registrationForm));

        } catch (Exception e) {

            e.printStackTrace();

        }


    }


}
