package com.dev.cinema.model.dto;

import com.dev.cinema.validation.annotation.EmailValidatorConstraint;
import com.dev.cinema.validation.annotation.FieldsValueMatch;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@FieldsValueMatch.List({
        @FieldsValueMatch(
                field = "password",
                fieldMatch = "verifyPassword",
                message = "Passwords do not match!"
        ),
        @FieldsValueMatch(
                field = "email",
                fieldMatch = "verifyEmail",
                message = "Email addresses do not match!"
        )
})
public class UserRegistrationDto {
    @NotNull
    @Min(4)
    private String password;
    @NotNull
    @Min(4)
    private String verifyPassword;
    @NotNull
    @EmailValidatorConstraint
    private String email;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordCheck() {
        return verifyPassword;
    }

    public void setPasswordCheck(String passwordCheck) {
        this.verifyPassword = verifyPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
