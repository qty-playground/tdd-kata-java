package com.example.tdd;

import java.util.List;
import java.util.ArrayList;

public class PasswordValidator {
    public static ValidationResult validate(String password) {
        List<String> errors = buildErrors(password);
        boolean isValid = errors.isEmpty();
        return new ValidationResult(isValid, errors);
    }

    // Structural refactor: extract error-building logic
    private static List<String> buildErrors(String password) {
        List<String> errors = new ArrayList<>();
        if (password == null || password.length() < 8) {
            errors.add("Password must be at least 8 characters");
        }
        int digits = 0;
        boolean hasUpper = false;
        boolean hasSpecial = false;
        if (password != null) {
            for (char c : password.toCharArray()) {
                if (Character.isDigit(c)) digits++;
                if (Character.isUpperCase(c)) hasUpper = true;
                if (!Character.isLetterOrDigit(c)) hasSpecial = true;
            }
        }
        if (digits < 2) {
            errors.add("The password must contain at least 2 numbers");
        }
        if (!hasUpper) {
            errors.add("Password must contain at least one capital letter");
        }
        if (!hasSpecial) {
            errors.add("password must contain at least one special character");
        }
        return errors;
    }

    public static class ValidationResult {
        public final boolean isValid;
        public final List<String> errors;
        public ValidationResult(boolean isValid, List<String> errors) {
            this.isValid = isValid;
            this.errors = errors;
        }
    }
}
