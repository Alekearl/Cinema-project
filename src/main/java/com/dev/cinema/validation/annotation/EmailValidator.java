package com.dev.cinema.validation.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmailValidator implements
        ConstraintValidator<EmailValidatorConstraint, String> {
    private static final String REGEX_MAIL_VALIDATOR = "^(.+)@(.+)$";

    @Override
    public boolean isValid(String emailField,
                           ConstraintValidatorContext validatorContext) {
        return emailField != null && emailField.matches(REGEX_MAIL_VALIDATOR);
    }
}
