package com.example;

import java.util.ArrayList;
import java.util.List;

public class PasswordValidator {

    private static final String MIN_LENGTH_ERROR = "Password must be at least 8 characters";
    private static final String MIN_DIGITS_ERROR = "The password must contain at least 2 numbers";
    private static final String CAPITAL_LETTER_ERROR = "password must contain at least one capital letter";
    private static final String SPECIAL_CHARACTER_ERROR = "password must contain at least one special character";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_=+[]{}|;:'\",.<>/?";

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
        boolean hasCapitalLetter = false;
        boolean hasSpecialChar = false;
        if (password != null) {
            for (char c : password.toCharArray()) {
                if (Character.isDigit(c)) {
                    digitCount++;
                } else if (Character.isUpperCase(c)) {
                    hasCapitalLetter = true;
                } else if (SPECIAL_CHARACTERS.indexOf(c) != -1) {
                    hasSpecialChar = true;
                }
            }
        }
        if (digitCount < 2) {
            errors.add(MIN_DIGITS_ERROR);
            isValid = false;
        }

        // Requirement 3: At least one capital letter
        if (!hasCapitalLetter) {
            errors.add(CAPITAL_LETTER_ERROR);
            isValid = false;
        }

        // Requirement 4: At least one special character
        if (!hasSpecialChar) {
            errors.add(SPECIAL_CHARACTER_ERROR);
            isValid = false;
        }

        return new ValidationResult(isValid, errors);
    }
}