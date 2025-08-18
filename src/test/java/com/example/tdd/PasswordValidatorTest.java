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

    @Test
    void shouldFailOnMinLength_Test2() {
        PasswordValidator.ValidationResult result = PasswordValidator.validate("Ab1!");
        // Red phase: expect invalid due to min length; test will fail until code is adjusted
        assertFalse(result.isValid, "Password shorter than 8 chars should be invalid");
        assertTrue(result.errors.contains("Password must be at least 8 characters"));
    }
}
