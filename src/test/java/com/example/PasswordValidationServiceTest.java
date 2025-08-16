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
    
    @Test
    void should_return_error_when_password_has_less_than_2_numbers() {
        // Arrange
        PasswordValidationService passwordValidationService = new PasswordValidationService();
        String passwordWithoutNumbers = "password";
        
        // Act
        PasswordValidationResult validationResult = passwordValidationService.validate(passwordWithoutNumbers);
        
        // Assert
        assertFalse(validationResult.isValid());
        assertEquals("The password must contain at least 2 numbers", validationResult.getErrorMessage());
    }
}