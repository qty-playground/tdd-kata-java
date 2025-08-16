package com.example.validation;

/**
 * Represents the result of a validation operation.
 */
public class ValidationResult {
    private boolean valid;
    private String errorMessages;
    
    public ValidationResult(boolean valid, String errorMessages) {
        this.valid = valid;
        this.errorMessages = errorMessages;
    }
    
    public boolean isValid() {
        return valid;
    }
    
    public String getErrorMessages() {
        return errorMessages;
    }
}