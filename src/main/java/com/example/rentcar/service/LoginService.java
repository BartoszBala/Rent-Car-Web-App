package com.example.rentcar.service;

import com.example.rentcar.Entity.UserEntity;
import com.example.rentcar.model.LoginForm;
import com.example.rentcar.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    UserRepository userRepository;


    @Autowired
    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean isCorrectUser(LoginForm loginForm) {

        UserEntity userEntity = userRepository.findByLogin(loginForm.getLogin());
        if (userEntity == null) {
            return false;
        }
        if (userEntity.getPassword().equals(loginForm.getPassword())) {
            return true;
        }

        return false;

    }
}
