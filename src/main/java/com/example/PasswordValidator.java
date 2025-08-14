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

        if (!errors.isEmpty()) {
            return new PasswordValidationResult(false, errors);
        } else {
            return new PasswordValidationResult(true, Collections.emptyList());
        }
    }
}
