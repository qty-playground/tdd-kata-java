package com.example;

public class PasswordValidationService {
    
    private static final int MINIMUM_PASSWORD_LENGTH = 8;
    
    public PasswordValidationResult validate(String password) {
        if (password.length() < MINIMUM_PASSWORD_LENGTH) {
            return new PasswordValidationResult(false, "Password must be at least 8 characters");
        }
        return new PasswordValidationResult(true, "");
    }
}