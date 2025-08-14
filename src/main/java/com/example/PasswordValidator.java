package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PasswordValidator {
    public PasswordValidationResult validate(String password) {
        List<String> errors = new ArrayList<>();

        if (password.length() < 8) {
            errors.add("Password must be at least 8 characters");
        }

        int digitCount = 0;
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                digitCount++;
            }
        }
        if (digitCount < 2) {
            errors.add("The password must contain at least 2 numbers");
        }

        boolean hasCapitalLetter = false;
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasCapitalLetter = true;
                break;
            }
        }
        if (!hasCapitalLetter) {
            errors.add("password must contain at least one capital letter");
        }

        if (!errors.isEmpty()) {
            return new PasswordValidationResult(false, errors);
        } else {
            return new PasswordValidationResult(true, Collections.emptyList());
        }
    }
}
