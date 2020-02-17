package com.example.rentcar.service;

import com.example.rentcar.model.RegistrationForm;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class RegistrationValidationService implements Validator {


    @Override
    public boolean supports(Class<?> paramClass) {
        return RegistrationForm.class.equals(paramClass);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"login","login.required");

        RegistrationForm registrationForm =(RegistrationForm) obj;

        if(registrationForm.getLogin().isEmpty()){
            errors.rejectValue("login","");
        }

    }
}
