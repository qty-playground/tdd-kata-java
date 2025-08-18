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
    void shouldFailOnMinLength_Test2_Skeleton() {
        // Red phase skeleton: this test intentionally asserts the opposite
        // of the intended green behavior to force a failure before
        // implementing the actual Test 2 requirements.
        PasswordValidator.ValidationResult result = PasswordValidator.validate("Ab1!");
        assertTrue(result.isValid, "Skeleton should fail to pass with short password");
    }
}
