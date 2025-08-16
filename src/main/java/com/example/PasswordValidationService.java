package com.example;

public class PasswordValidationService {
    
    private static final int MINIMUM_PASSWORD_LENGTH = 8;
    private static final int MINIMUM_NUMBERS_REQUIRED = 2;
    
    public PasswordValidationResult validate(String password) {
        if (password.length() < MINIMUM_PASSWORD_LENGTH) {
            return new PasswordValidationResult(false, "Password must be at least 8 characters");
        }
        
        long numberCount = password.chars()
                .filter(Character::isDigit)
                .count();
        
        if (numberCount < MINIMUM_NUMBERS_REQUIRED) {
            return new PasswordValidationResult(false, "The password must contain at least 2 numbers");
        }
        
        boolean hasCapitalLetter = password.chars()
                .anyMatch(Character::isUpperCase);
        
        if (!hasCapitalLetter) {
            return new PasswordValidationResult(false, "password must contain at least one capital letter");
        }
        
        String specialChars = "!@#$%^&*()_+-=[]{}|;':\",./<>?";
        boolean hasSpecialCharacter = password.chars()
                .anyMatch(ch -> specialChars.indexOf(ch) >= 0);
        
        if (!hasSpecialCharacter) {
            return new PasswordValidationResult(false, "password must contain at least one special character");
        }
        
        return new PasswordValidationResult(true, "");
    }
}