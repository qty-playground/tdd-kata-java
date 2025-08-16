package com.example.validation;

/**
 * Represents the result of a validation operation.
 * This class is immutable.
 */
public class ValidationResult {
    private final boolean valid;
    private final String errorMessages;
    
    /**
     * Creates a new validation result.
     * 
     * @param valid whether the validation passed
     * @param errorMessages error messages if validation failed, empty string otherwise
     */
    public ValidationResult(boolean valid, String errorMessages) {
        this.valid = valid;
        this.errorMessages = errorMessages;
    }
    
    /**
     * @return true if the validation passed, false otherwise
     */
    public boolean isValid() {
        return valid;
    }
    
    /**
     * @return error messages if validation failed, empty string otherwise
     */
    public String getErrorMessages() {
        return errorMessages;
    }
}