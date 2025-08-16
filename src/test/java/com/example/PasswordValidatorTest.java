package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {

    @Test
    void should_returnError_when_passwordIsShorterThan8Characters() {
        // Arrange
        PasswordValidator validator = new PasswordValidator();
        String password = "short"; // 5 characters
        String expectedError = "Password must be at least 8 characters";

        // Act
        ValidationResult result = validator.validate(password);

        // Assert
        assertTrue(result.getErrors().contains(expectedError), "Error message for short password not found.");
        assertFalse(result.isValid(), "Password should be invalid due to length.");
    }

    @Test
    void should_returnError_when_passwordHasLessThan2Numbers() {
        // Arrange
        PasswordValidator validator = new PasswordValidator();
        String password = "Password1"; // Only 1 number
        String expectedError = "The password must contain at least 2 numbers";

        // Act
        ValidationResult result = validator.validate(password);

        // Assert
        assertTrue(result.getErrors().contains(expectedError), "Error message for insufficient numbers not found.");
        assertFalse(result.isValid(), "Password should be invalid due to insufficient numbers.");
    }

    // This test is for multiple errors, but we'll focus on implementing one rule at a time.
    // It will fail until all rules are implemented.
    @Test
    void should_returnMultipleErrors_when_passwordIsInvalid() {
        // Arrange
        PasswordValidator validator = new PasswordValidator();
        String password = "pass"; // Too short, no numbers, no capital, no special char
        String expectedError1 = "Password must be at least 8 characters";
        String expectedError2 = "The password must contain at least 2 numbers";
        String expectedError3 = "password must contain at least one capital letter";
        String expectedError4 = "password must contain at least one special character";

        // Act
        ValidationResult result = validator.validate(password);

        // Assert
        assertTrue(result.getErrors().contains(expectedError1));
        assertTrue(result.getErrors().contains(expectedError2));
        assertTrue(result.getErrors().contains(expectedError3));
        assertTrue(result.getErrors().contains(expectedError4));
        assertFalse(result.isValid(), "Password should be invalid due to multiple errors.");
    }
}