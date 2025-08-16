package com.example.validation;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {
    
    @Test
    void should_ReturnInvalidResult_When_PasswordLengthIsLessThan8() {
        // Arrange
        PasswordValidator validator = new PasswordValidator();
        String shortPassword = "short";
        
        // Act
        ValidationResult result = validator.validate(shortPassword);
        
        // Assert
        assertFalse(result.isValid());
        assertEquals("Password must be at least 8 characters", result.getErrorMessages());
    }
}