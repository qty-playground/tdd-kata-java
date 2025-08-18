package com.example.tdd;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PasswordValidatorTest {
    @Test
    void shouldPassWhenPasswordMeetsAllRules() {
        PasswordValidator.ValidationResult result = PasswordValidator.validate("Abcdef12!");
        assertTrue(result.isValid, "Password should be valid for the test input");
        assertTrue(result.errors.isEmpty(), "Expected no errors");
    }
}

