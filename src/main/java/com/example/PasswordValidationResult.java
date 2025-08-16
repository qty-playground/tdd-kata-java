package com.example;

public class PasswordValidationResult {
    private final boolean valid;
    private final String errorMessage;
    
    public PasswordValidationResult(boolean valid, String errorMessage) {
        this.valid = valid;
        this.errorMessage = errorMessage;
    }
    
    public boolean isValid() {
        return valid;
    }
    
    public String getErrorMessage() {
        return errorMessage;
    }
}