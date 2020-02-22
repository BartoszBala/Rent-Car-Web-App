package com.example.rentcar.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


@Service
public class UserContextService {






    public boolean isAuthetnticated() {
Authentication authentication=SecurityContextHolder.getContext().getAuthentication();       //fixme
        if (!authentication.getPrincipal().equals("anonymousUser")) {

            return true;

        }
        return false;
    }

    public String getUserName(){
        Authentication authentication=SecurityContextHolder.getContext().getAuthentication(); //fixme
        return authentication.getName();
    }
}
