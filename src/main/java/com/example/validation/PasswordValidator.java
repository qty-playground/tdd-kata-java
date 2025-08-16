package com.example.validation;

/**
 * Validates password based on defined rules.
 */
public class PasswordValidator {
    
    /**
     * Validates a password against the defined rules.
     * 
     * @param password The password to validate
     * @return ValidationResult with validity status and any error messages
     */
    public ValidationResult validate(String password) {
        // Minimal implementation to pass the first test
        if (password.length() < 8) {
            return new ValidationResult(false, "Password must be at least 8 characters");
        }
        
        return new ValidationResult(true, "");
    }
}