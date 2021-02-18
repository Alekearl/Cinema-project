package com.dev.cinema.validation.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements
        ConstraintValidator<EmailValidatorConstraint, String> {
    private static final String REGEX_MAIL_VALIDATOR = "^(.+)@(.+)$";

    @Override
    public boolean isValid(String emailField,
                           ConstraintValidatorContext validatorContext) {
        return emailField != null && emailField.matches(REGEX_MAIL_VALIDATOR);
    }
}
