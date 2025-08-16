package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PasswordValidationServiceTest {
    
    @Test
    void should_return_error_when_password_is_shorter_than_8_characters() {
        // Arrange
        PasswordValidationService passwordValidationService = new PasswordValidationService();
        String shortPassword = "short";
        
        // Act
        PasswordValidationResult validationResult = passwordValidationService.validate(shortPassword);
        
        // Assert
        assertFalse(validationResult.isValid());
        assertEquals("Password must be at least 8 characters", validationResult.getErrorMessage());
    }
}