package com.example;

import org.junit.jupiter.api.Test;
import java.util.List;
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

    @Test
    void should_ReturnInvalidAndErrorMessage_When_PasswordContainsLessThan2Numbers() {
        // Arrange
        PasswordValidator validator = new PasswordValidator();
        String password = "passwordA1";
        String expectedErrorMessage = "The password must contain at least 2 numbers";

        // Act
        PasswordValidationResult result = validator.validate(password);

        // Assert
        assertFalse(result.isValid());
        assertTrue(result.getErrors().contains(expectedErrorMessage));
    }

    @Test
    void should_ReturnInvalidAndErrorMessage_When_PasswordContainsNoCapitalLetter() {
        // Arrange
        PasswordValidator validator = new PasswordValidator();
        String password = "password12";
        String expectedErrorMessage = "password must contain at least one capital letter";

        // Act
        PasswordValidationResult result = validator.validate(password);

        // Assert
        assertFalse(result.isValid());
        assertTrue(result.getErrors().contains(expectedErrorMessage));
    }

    @Test
    void should_ReturnInvalidAndErrorMessage_When_PasswordContainsNoSpecialCharacter() {
        // Arrange
        PasswordValidator validator = new PasswordValidator();
        String password = "Password12";
        String expectedErrorMessage = "password must contain at least one special character";

        // Act
        PasswordValidationResult result = validator.validate(password);

        // Assert
        assertFalse(result.isValid());
        assertTrue(result.getErrors().contains(expectedErrorMessage));
    }

    @Test
    void should_ReturnValid_When_PasswordMeetsAllRequirements() {
        // Arrange
        PasswordValidator validator = new PasswordValidator();
        String password = "Password12!";

        // Act
        PasswordValidationResult result = validator.validate(password);

        // Assert
        assertTrue(result.isValid());
        assertTrue(result.getErrors().isEmpty());
    }

    @Test
    void should_ReturnMultipleErrorMessages_When_PasswordViolatesMultipleRules() {
        // Arrange
        PasswordValidator validator = new PasswordValidator();
        String password = "somepassword";
        List<String> expectedErrors = List.of(
                "Password must be at least 8 characters",
                "The password must contain at least 2 numbers",
                "password must contain at least one capital letter",
                "password must contain at least one special character"
        );

        // Act
        PasswordValidationResult result = validator.validate(password);

        // Assert
        assertFalse(result.isValid());
        assertEquals(expectedErrors.size(), result.getErrors().size());
        assertTrue(result.getErrors().containsAll(expectedErrors));
    }
}
