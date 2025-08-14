package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {

    @Test
    void should_ReturnInvalidAndErrorMessage_When_PasswordIsLessThan8Characters() {
        // Arrange
        PasswordValidator validator = new PasswordValidator();
        String password = "short";
        String expectedErrorMessage = "Password must be at least 8 characters";

        // Act
        PasswordValidationResult result = validator.validate(password);

        // Assert
        assertFalse(result.isValid());
        assertTrue(result.getErrors().contains(expectedErrorMessage));
    }
}
