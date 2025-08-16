package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PasswordValidatorTest {

    @Test
    public void should_ReturnInvalid_When_PasswordIsTooShort() {
        // Arrange
        PasswordValidator validator = new PasswordValidator();
        String shortPassword = "short";
        
        // Act
        ValidationResult result = validator.validate(shortPassword);
        
        // Assert
        assertFalse(result.isValid());
        assertTrue(result.getErrors().contains("Password must be at least 8 characters"));
    }
    
    @Test
    public void should_ReturnInvalid_When_PasswordIsNull() {
        // Arrange
        PasswordValidator validator = new PasswordValidator();
        
        // Act
        ValidationResult result = validator.validate(null);
        
        // Assert
        assertFalse(result.isValid());
        assertTrue(result.getErrors().contains("Password cannot be null"));
    }
    
    @Test
    public void should_ReturnInvalid_When_PasswordHasLessThanTwoNumbers() {
        // Arrange
        PasswordValidator validator = new PasswordValidator();
        String passwordWithOneNumber = "password1";
        
        // Act
        ValidationResult result = validator.validate(passwordWithOneNumber);
        
        // Assert
        assertFalse(result.isValid());
        assertTrue(result.getErrors().contains("The password must contain at least 2 numbers"));
    }
    
    @Test
    public void should_ReturnValid_When_PasswordHasAllRequirements() {
        // Arrange
        PasswordValidator validator = new PasswordValidator();
        String validPassword = "Password12!";  // Has length, numbers, capital letter, and special character
        
        // Act
        ValidationResult result = validator.validate(validPassword);
        
        // Assert
        assertTrue(result.isValid());
        assertTrue(result.getErrors().isEmpty());
    }
    
    @Test
    public void should_ReturnInvalid_When_PasswordHasNoCapitalLetter() {
        // Arrange
        PasswordValidator validator = new PasswordValidator();
        String passwordWithoutCapital = "password12";
        
        // Act
        ValidationResult result = validator.validate(passwordWithoutCapital);
        
        // Assert
        assertFalse(result.isValid());
        assertTrue(result.getErrors().contains("Password must contain at least one capital letter"));
    }
    
    @Test
    public void should_NotHaveCapitalLetterError_When_PasswordHasCapitalLetter() {
        // Arrange
        PasswordValidator validator = new PasswordValidator();
        String passwordWithCapital = "Password12";
        
        // Act
        ValidationResult result = validator.validate(passwordWithCapital);
        
        // Assert
        assertFalse(result.getErrors().contains("Password must contain at least one capital letter"));
    }
    
    @Test
    public void should_ReturnInvalid_When_PasswordHasNoSpecialCharacter() {
        // Arrange
        PasswordValidator validator = new PasswordValidator();
        String passwordWithoutSpecial = "Password12";
        
        // Act
        ValidationResult result = validator.validate(passwordWithoutSpecial);
        
        // Assert
        assertFalse(result.isValid());
        assertTrue(result.getErrors().contains("Password must contain at least one special character"));
    }
    
    @Test
    public void should_NotHaveSpecialCharacterError_When_PasswordHasSpecialCharacter() {
        // Arrange
        PasswordValidator validator = new PasswordValidator();
        String passwordWithSpecial = "Password12!";
        
        // Act
        ValidationResult result = validator.validate(passwordWithSpecial);
        
        // Assert
        assertFalse(result.getErrors().contains("Password must contain at least one special character"));
    }
    
    @Test
    public void should_ReturnMultipleErrors_When_PasswordViolatesMultipleRules() {
        // Arrange
        PasswordValidator validator = new PasswordValidator();
        String invalidPassword = "pwd"; // Too short, not enough numbers, no capital, no special char
        
        // Act
        ValidationResult result = validator.validate(invalidPassword);
        
        // Assert
        assertFalse(result.isValid());
        assertEquals(4, result.getErrors().size());
        assertTrue(result.getErrors().contains("Password must be at least 8 characters"));
        assertTrue(result.getErrors().contains("The password must contain at least 2 numbers"));
        assertTrue(result.getErrors().contains("Password must contain at least one capital letter"));
        assertTrue(result.getErrors().contains("Password must contain at least one special character"));
    }
}