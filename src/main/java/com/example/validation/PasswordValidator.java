package com.example.validation;

/**
 * Validates password based on defined rules.
 */
public class PasswordValidator {
    
    private static final int MINIMUM_PASSWORD_LENGTH = 8;
    private static final String LENGTH_ERROR_MESSAGE = "Password must be at least 8 characters";
    
    /**
     * Validates a password against the defined rules.
     * 
     * @param password The password to validate
     * @return ValidationResult with validity status and any error messages
     */
    public ValidationResult validate(String password) {
        if (!hasMinimumLength(password)) {
            return new ValidationResult(false, LENGTH_ERROR_MESSAGE);
        }
        
        return new ValidationResult(true, "");
    }
    
    /**
     * Checks if the password meets the minimum length requirement.
     * 
     * @param password The password to check
     * @return true if the password meets the minimum length requirement
     */
    private boolean hasMinimumLength(String password) {
        return password.length() >= MINIMUM_PASSWORD_LENGTH;
    }
}