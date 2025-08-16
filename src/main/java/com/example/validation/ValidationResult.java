package com.example.validation;

import java.util.ArrayList;
import java.util.List;

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
     * Creates a new validation result with multiple error messages.
     * 
     * @param valid whether the validation passed
     * @param errorMessagesList list of error messages
     */
    public ValidationResult(boolean valid, List<String> errorMessagesList) {
        this.valid = valid;
        
        if (errorMessagesList == null || errorMessagesList.isEmpty()) {
            this.errorMessages = "";
        } else {
            this.errorMessages = String.join("\n", errorMessagesList);
        }
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