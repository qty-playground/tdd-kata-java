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
    
    @Test
    void should_ReturnInvalidResult_When_PasswordContainsLessThan2Numbers() {
        // Arrange
        PasswordValidator validator = new PasswordValidator();
        String passwordWithoutNumbers = "password";
        
        // Act
        ValidationResult result = validator.validate(passwordWithoutNumbers);
        
        // Assert
        assertFalse(result.isValid());
        assertEquals("The password must contain at least 2 numbers", result.getErrorMessages());
    }
    
    @Test
    void should_ReturnMultipleErrorMessages_When_PasswordFailsMultipleValidations() {
        // Arrange
        PasswordValidator validator = new PasswordValidator();
        String invalidPassword = "pass";  // Too short and no numbers
        
        // Act
        ValidationResult result = validator.validate(invalidPassword);
        
        // Assert
        assertFalse(result.isValid());
        String expectedErrors = "Password must be at least 8 characters\nThe password must contain at least 2 numbers";
        assertEquals(expectedErrors, result.getErrorMessages());
    }
    
    @Test
    void should_ReturnInvalidResult_When_PasswordDoesNotContainCapitalLetter() {
        // Arrange
        PasswordValidator validator = new PasswordValidator();
        String passwordWithoutCapital = "password12";  // No capital letter
        
        // Act
        ValidationResult result = validator.validate(passwordWithoutCapital);
        
        // Assert
        assertFalse(result.isValid());
        assertEquals("password must contain at least one capital letter", result.getErrorMessages());
    }
    
    @Test
    void should_ReturnInvalidResult_When_PasswordDoesNotContainSpecialCharacter() {
        // Arrange
        PasswordValidator validator = new PasswordValidator();
        String passwordWithoutSpecialChar = "Password12";  // No special character
        
        // Act
        ValidationResult result = validator.validate(passwordWithoutSpecialChar);
        
        // Assert
        assertFalse(result.isValid());
        assertEquals("password must contain at least one special character", result.getErrorMessages());
    }
}