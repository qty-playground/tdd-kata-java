package com.example;

import java.util.List;

public class PasswordValidationResult {
    private final boolean isValid;
    private final List<String> errors;

    public PasswordValidationResult(boolean isValid, List<String> errors) {
        this.isValid = isValid;
        this.errors = errors;
    }

    public boolean isValid() {
        return isValid;
    }

    public List<String> getErrors() {
        return errors;
    }
}
