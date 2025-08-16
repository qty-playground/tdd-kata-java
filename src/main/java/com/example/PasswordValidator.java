package com.example;

import java.util.ArrayList;
import java.util.List;

public class PasswordValidator {

    private static final String MIN_LENGTH_ERROR = "Password must be at least 8 characters";

    public ValidationResult validate(String password) {
        List<String> errors = new ArrayList<>();
        boolean isValid = true;

        // Requirement 1: Minimum length
        if (password == null || password.length() < 8) {
            errors.add(MIN_LENGTH_ERROR);
            isValid = false;
        }

        // For now, we only implement the first requirement.
        // Other validations will be added in subsequent Green Phases.

        return new ValidationResult(isValid, errors);
    }
}
