package com.example;

public class PasswordValidator {
    private static final int MIN_PASSWORD_LENGTH = 8;
    private static final int MIN_NUMBERS_COUNT = 2;
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()_-+=<>?/{}~|";

    public ValidationResult validate(String password) {
        ValidationResult result = new ValidationResult();
        
        if (password == null) {
            result.addError("Password cannot be null");
            return result;
        }
        
        // Check password length
        if (password.length() < MIN_PASSWORD_LENGTH) {
            result.addError("Password must be at least " + MIN_PASSWORD_LENGTH + " characters");
        }
        
        // Check number of digits
        int digitCount = countDigits(password);
        if (digitCount < MIN_NUMBERS_COUNT) {
            result.addError("The password must contain at least " + MIN_NUMBERS_COUNT + " numbers");
        }
        
        // Check for capital letter
        if (!containsCapitalLetter(password)) {
            result.addError("Password must contain at least one capital letter");
        }
        
        // Check for special character
        if (!containsSpecialCharacter(password)) {
            result.addError("Password must contain at least one special character");
        }
        
        return result;
    }
    
    private int countDigits(String password) {
        return (int) password.chars()
                .filter(Character::isDigit)
                .count();
    }
    
    private boolean containsCapitalLetter(String password) {
        return password.chars()
                .anyMatch(Character::isUpperCase);
    }
    
    private boolean containsSpecialCharacter(String password) {
        return password.chars()
                .anyMatch(c -> SPECIAL_CHARACTERS.indexOf(c) >= 0);
    }
}