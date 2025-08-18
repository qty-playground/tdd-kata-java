## Requirement

```
Password input field validation

Create a function that can be used as a validator for the password field of a user registration form. The validation function takes a string as an input and returns a validation result. The validation result should contain a boolean indicating if the password is valid or not, and also a field with the possible validation errors.

Requirements
1. The password must be at least 8 characters long. If it is not met, then the following error message should be returned: “Password must be at least 8 characters”

2. The password must contain at least 2 numbers. If it is not met, then the following error message should be returned: “The password must contain at least 2 numbers”

3. The validation function should handle multiple validation errors.

For example, “somepassword” should an error message: “Password must be at least 8 characters\nThe password must contain at least 2 numbers”
4. The password must contain at least one capital letter. If it is not met, then the following error message should be returned: “password must contain at least one capital letter”

5. The password must contain at least one special character. If it is not met, then the following error message should be returned: “password must contain at least one special character”
```

## Plan Backlog (Single-Test-Per-Cycle)

This backlog contains one backlog item per test scenario to drive the TDD cycle strictly one test at a time.

- [ ] Test 1: shouldPassWhenPasswordMeetsAllRules
  - Input: "Abcdef12!"
  - Expected: isValid = true; errors = []
  - Cycle: WRITING_FAILING_TEST → WRITING_PASSING_CODE → VERIFYING_ALL_TESTS

- [ ] Test 2: shouldFailOnMinLength
  - Input: "Ab1!"
  - Expected: isValid = false; errors contains "Password must be at least 8 characters"
  - Cycle: WRITING_FAILING_TEST → WRITING_PASSING_CODE → VERIFYING_ALL_TESTS

- [ ] Test 3: shouldFailOnNumbersCount
  - Input: "Abcdefgh"
  - Expected: isValid = false; errors contains "The password must contain at least 2 numbers"
  - Cycle: WRITING_FAILING_TEST → WRITING_PASSING_CODE → VERIFYING_ALL_TESTS

- [ ] Test 4: shouldFailOnUppercase
  - Input: "abcdef12!"
  - Expected: isValid = false; errors contains "password must contain at least one capital letter"
  - Cycle: WRITING_FAILING_TEST → WRITING_PASSING_CODE → VERIFYING_ALL_TESTS

- [ ] Test 5: shouldFailOnSpecialCharacter
  - Input: "Abcdef12"
  - Expected: isValid = false; errors contains "password must contain at least one special character"
  - Cycle: WRITING_FAILING_TEST → WRITING_PASSING_CODE → VERIFYING_ALL_TESTS

- [ ] Test 6: shouldReportMultipleErrors
  - Input: "abc" (too short + missing numbers + missing uppercase + missing special)
  - Expected: isValid = false; errors contains all four messages
  - Cycle: WRITING_FAILING_TEST → WRITING_PASSING_CODE → VERIFYING_ALL_TESTS
