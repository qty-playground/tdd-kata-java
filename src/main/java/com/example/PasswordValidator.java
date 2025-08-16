package com.example;

import java.util.ArrayList;
import java.util.List;

public class PasswordValidator {

    private static final String MIN_LENGTH_ERROR = "Password must be at least 8 characters";
    private static final String MIN_DIGITS_ERROR = "The password must contain at least 2 numbers";

    public ValidationResult validate(String password) {
        List<String> errors = new ArrayList<>();
        boolean isValid = true;

        // Requirement 1: Minimum length
        if (password == null || password.length() < 8) {
            errors.add(MIN_LENGTH_ERROR);
            isValid = false;
        }

        // Requirement 2: At least 2 numbers
        int digitCount = 0;
        if (password != null) {
            for (char c : password.toCharArray()) {
                if (Character.isDigit(c)) {
                    digitCount++;
                }
            }
        }
        if (digitCount < 2) {
            errors.add(MIN_DIGITS_ERROR);
            isValid = false;
        }

        return new ValidationResult(isValid, errors);
    }
}