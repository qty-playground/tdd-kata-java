package com.example;

public class PasswordValidationService {
    
    public PasswordValidationResult validate(String password) {
        if (password.length() < 8) {
            return new PasswordValidationResult(false, "Password must be at least 8 characters");
        }
        return new PasswordValidationResult(true, "");
    }
}