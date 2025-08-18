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

    @Test
    void shouldFailOnUppercase_Test4_Red() {
        PasswordValidator.ValidationResult result = PasswordValidator.validate("abcdef12!");
        // Red phase: test expects uppercase error with a capitalized message
        // This string is intentionally different from the actual validator message to force Red
        assertFalse(result.isValid, "Expected invalid due to missing uppercase");
        assertTrue(result.errors.contains("Password must contain at least one capital letter"));
    }

    @Test
    void shouldFailOnSpecialCharacter_Test5_Red() {
        PasswordValidator.ValidationResult result = PasswordValidator.validate("Abcdef12");
        assertFalse(result.isValid, "Missing special character should be invalid");
        // Expect the uppercase variant now that the validator message is aligned
        assertTrue(result.errors.contains("Password must contain at least one special character"));
    }

    @Test
    void shouldReportMultipleErrors_Test6() {
        PasswordValidator.ValidationResult result = PasswordValidator.validate("abc");
        assertFalse(result.isValid, "Multiple errors should be reported");
        assertTrue(result.errors.contains("Password must be at least 8 characters"));
        assertTrue(result.errors.contains("The password must contain at least 2 numbers"));
        assertTrue(result.errors.contains("Password must contain at least one capital letter"));
        assertTrue(result.errors.contains("Password must contain at least one special character"));
    }

    @Test
    void shouldFailOnNumbersCount_Test3() {
        PasswordValidator.ValidationResult result = PasswordValidator.validate("Abcdefgh");
        // Expect invalid due to missing numbers; ensure specific error is present
        assertFalse(result.isValid, "Password missing numbers should be invalid");
        assertTrue(result.errors.contains("The password must contain at least 2 numbers"));
    }
}
