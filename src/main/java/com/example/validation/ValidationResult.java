package com.example.validation;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Represents the result of a validation operation.
 * This class is immutable and provides information about validation success 
 * and any error messages in case of validation failure.
 */
public final class ValidationResult {
    private final boolean valid;
    private final String errorMessages;
    
    /**
     * Creates a new validation result.
     * 
     * @param valid whether the validation passed
     * @param errorMessages error messages if validation failed, empty string otherwise
     * @throws NullPointerException if errorMessages is null
     */
    public ValidationResult(boolean valid, String errorMessages) {
        this.valid = valid;
        this.errorMessages = Objects.requireNonNull(errorMessages, "Error messages cannot be null");
    }
    
    /**
     * Creates a new validation result with multiple error messages.
     * The error messages will be joined with newline characters.
     * 
     * @param valid whether the validation passed
     * @param errorMessagesList list of error messages
     * @throws NullPointerException if errorMessagesList is null
     */
    public ValidationResult(boolean valid, List<String> errorMessagesList) {
        this.valid = valid;
        Objects.requireNonNull(errorMessagesList, "Error messages list cannot be null");
        
        if (errorMessagesList.isEmpty()) {
            this.errorMessages = "";
        } else {
            this.errorMessages = String.join("\n", errorMessagesList);
        }
    }
    
    /**
     * Creates a valid validation result with no error messages.
     * 
     * @return a validation result indicating success
     */
    public static ValidationResult valid() {
        return new ValidationResult(true, "");
    }
    
    /**
     * Creates an invalid validation result with the specified error message.
     * 
     * @param errorMessage the error message
     * @return a validation result indicating failure with the given message
     * @throws NullPointerException if errorMessage is null
     */
    public static ValidationResult invalid(String errorMessage) {
        return new ValidationResult(false, errorMessage);
    }
    
    /**
     * Creates an invalid validation result with the specified error messages.
     * 
     * @param errorMessages the error messages
     * @return a validation result indicating failure with the given messages
     * @throws NullPointerException if errorMessages is null
     */
    public static ValidationResult invalid(List<String> errorMessages) {
        return new ValidationResult(false, errorMessages);
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
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ValidationResult that = (ValidationResult) o;
        return valid == that.valid && Objects.equals(errorMessages, that.errorMessages);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(valid, errorMessages);
    }
    
    @Override
    public String toString() {
        return "ValidationResult{" +
                "valid=" + valid +
                ", errorMessages='" + errorMessages + '\'' +
                '}';
    }
}