package com.example.rentcar.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


public class UserContextService {


    Authentication authentication;

    public UserContextService() {
        this.authentication = SecurityContextHolder.getContext().getAuthentication();
    }

    @Bean
    public boolean isAuthetnticated() {

        if (authentication!=null&&authentication.isAuthenticated()) {

            return true;

        }
        return false;
    }
}
