package com.example;

public class PasswordValidationService {
    
    private static final int MINIMUM_PASSWORD_LENGTH = 8;
    private static final int MINIMUM_NUMBERS_REQUIRED = 2;
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()_+-=[]{}|;':\",./<>?";
    
    public PasswordValidationResult validate(String password) {
        StringBuilder errors = new StringBuilder();
        
        if (password.length() < MINIMUM_PASSWORD_LENGTH) {
            errors.append("Password must be at least 8 characters");
        }
        
        long numberCount = password.chars()
                .filter(Character::isDigit)
                .count();
        
        if (numberCount < MINIMUM_NUMBERS_REQUIRED) {
            if (errors.length() > 0) {
                errors.append("\n");
            }
            errors.append("The password must contain at least 2 numbers");
        }
        
        boolean hasCapitalLetter = password.chars()
                .anyMatch(Character::isUpperCase);
        
        if (!hasCapitalLetter) {
            if (errors.length() > 0) {
                errors.append("\n");
            }
            errors.append("password must contain at least one capital letter");
        }
        
        boolean hasSpecialCharacter = password.chars()
                .anyMatch(ch -> SPECIAL_CHARACTERS.indexOf(ch) >= 0);
        
        if (!hasSpecialCharacter) {
            if (errors.length() > 0) {
                errors.append("\n");
            }
            errors.append("password must contain at least one special character");
        }
        
        if (errors.length() > 0) {
            return new PasswordValidationResult(false, errors.toString());
        }
        
        return new PasswordValidationResult(true, "");
    }
}