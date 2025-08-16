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
    
    @Test
    void should_return_error_when_password_has_no_capital_letter() {
        // Arrange
        PasswordValidationService passwordValidationService = new PasswordValidationService();
        String passwordWithoutCapital = "password12";
        
        // Act
        PasswordValidationResult validationResult = passwordValidationService.validate(passwordWithoutCapital);
        
        // Assert
        assertFalse(validationResult.isValid());
        assertEquals("password must contain at least one capital letter", validationResult.getErrorMessage());
    }
    
    @Test
    void should_return_error_when_password_has_no_special_character() {
        // Arrange
        PasswordValidationService passwordValidationService = new PasswordValidationService();
        String passwordWithoutSpecialChar = "Password12";
        
        // Act
        PasswordValidationResult validationResult = passwordValidationService.validate(passwordWithoutSpecialChar);
        
        // Assert
        assertFalse(validationResult.isValid());
        assertEquals("password must contain at least one special character", validationResult.getErrorMessage());
    }
    
    @Test
    void should_return_multiple_error_messages_when_password_fails_multiple_rules() {
        // Arrange
        PasswordValidationService passwordValidationService = new PasswordValidationService();
        String passwordWithMultipleErrors = "short";
        
        // Act
        PasswordValidationResult validationResult = passwordValidationService.validate(passwordWithMultipleErrors);
        
        // Assert
        assertFalse(validationResult.isValid());
        assertEquals("Password must be at least 8 characters\nThe password must contain at least 2 numbers", validationResult.getErrorMessage());
    }
}