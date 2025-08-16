package com.example.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.function.IntPredicate;

/**
 * Validates password strength based on defined security rules.
 * This class implements various password security checks including:
 * - Minimum length requirements
 * - Character type requirements (digits, uppercase letters)
 * - Special character requirements
 * - Composition rules
 */
public final class PasswordValidator {
    
    // Validation rule constants
    private static final int MINIMUM_PASSWORD_LENGTH = 8;
    private static final int MINIMUM_NUMBERS_COUNT = 2;
    
    // Validation error messages
    private static final String LENGTH_ERROR_MESSAGE = "Password must be at least 8 characters";
    private static final String NUMBERS_ERROR_MESSAGE = "The password must contain at least 2 numbers";
    private static final String CAPITAL_LETTER_ERROR_MESSAGE = "password must contain at least one capital letter";
    private static final String SPECIAL_CHARACTER_ERROR_MESSAGE = "password must contain at least one special character";
    
    // Special characters for password validation
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()_+-=[]{}|;:,.<>?";
    
    
    /**
     * Validates a password against the defined security rules.
     * <p>
     * The password is checked against the following rules:
     * <ul>
     *   <li>Must be at least 8 characters long</li>
     *   <li>Must contain at least 2 numbers</li>
     *   <li>Must contain at least one capital letter</li>
     *   <li>Must contain at least one special character</li>
     * </ul>
     * 
     * @param password The password to validate, must not be null
     * @return ValidationResult with validity status and any error messages
     * @throws NullPointerException if password is null
     */
    public ValidationResult validate(String password) {
        Objects.requireNonNull(password, "Password cannot be null");
        
        
        // Normal validation flow - collect all validation errors
        List<String> validationErrors = collectValidationErrors(password);
        
        // Return validation result based on errors found
        return validationErrors.isEmpty() 
            ? ValidationResult.valid() 
            : ValidationResult.invalid(validationErrors);
    }
    
    /**
     * Collects all validation errors for the given password.
     * 
     * @param password The password to validate
     * @return List of validation error messages
     */
    private List<String> collectValidationErrors(String password) {
        List<String> errorMessages = new ArrayList<>();
        
        // Normal validation flow - collect all validation errors
        applyValidationRule(errorMessages, password, this::hasMinimumLength, LENGTH_ERROR_MESSAGE);
        applyValidationRule(errorMessages, password, this::hasMinimumNumbers, NUMBERS_ERROR_MESSAGE);
        applyValidationRule(errorMessages, password, this::hasCapitalLetter, CAPITAL_LETTER_ERROR_MESSAGE);
        applyValidationRule(errorMessages, password, this::hasSpecialCharacter, SPECIAL_CHARACTER_ERROR_MESSAGE);
        
        return errorMessages;
    }
    
    /**
     * Applies a validation rule and adds the error message if validation fails.
     * 
     * @param errorMessages The list of error messages to add to
     * @param password The password to validate
     * @param validationRule The validation rule to apply
     * @param errorMessage The error message to add if validation fails
     */
    private void applyValidationRule(List<String> errorMessages, String password, 
                                     Predicate<String> validationRule, String errorMessage) {
        if (!validationRule.test(password)) {
            errorMessages.add(errorMessage);
        }
    }
    
    /**
     * Checks if the password meets the minimum length requirement.
     * 
     * @param password The password to check
     * @return true if the password meets the minimum length requirement
     */
    private boolean hasMinimumLength(String password) {
        return password.length() >= MINIMUM_PASSWORD_LENGTH;
    }
    
    /**
     * Checks if the password contains the minimum required number of digits.
     * 
     * @param password The password to check
     * @return true if the password contains at least the minimum required number of digits
     */
    private boolean hasMinimumNumbers(String password) {
        return countCharactersMatching(password, Character::isDigit) >= MINIMUM_NUMBERS_COUNT;
    }
    
    /**
     * Checks if the password contains at least one capital letter.
     * 
     * @param password The password to check
     * @return true if the password contains at least one capital letter
     */
    private boolean hasCapitalLetter(String password) {
        return password.chars().anyMatch(Character::isUpperCase);
    }
    
    /**
     * Checks if the password contains at least one special character.
     * 
     * @param password The password to check
     * @return true if the password contains at least one special character
     */
    private boolean hasSpecialCharacter(String password) {
        return password.chars()
                .mapToObj(c -> (char) c)
                .anyMatch(c -> SPECIAL_CHARACTERS.indexOf(c) >= 0);
    }
    
    /**
     * Counts the number of characters in a string that match a given predicate.
     * 
     * @param input The string to check
     * @param predicate The character predicate to apply
     * @return The count of characters matching the predicate
     */
    private long countCharactersMatching(String input, IntPredicate predicate) {
        return input.chars().filter(predicate).count();
    }
}