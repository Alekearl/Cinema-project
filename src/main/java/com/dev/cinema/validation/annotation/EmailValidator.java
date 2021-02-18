package com.dev.cinema.validation.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmailValidator implements
        ConstraintValidator<EmailValidatorConstraint, String> {
    @Override
    public void initialize(EmailValidatorConstraint emailValidatorConstraint) {
    }

    @Override
    public boolean isValid(String contactField,
                           ConstraintValidatorContext cxt) {
        return contactField != null && contactField.matches("[0-9]+")
                && (contactField.length() > 8) && (contactField.length() < 14);
    }

}
