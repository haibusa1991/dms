package com.dms.beiam.restapi.validators.password;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<Password,String> {

    // 10-128 characters
    // at least one uppercase letter
    // at least one lowercase letter
    // at least one digit
    // at least one special character
    // no more than 2 repeating characters
    // at least one of the special characters: '@', '$', '!', '%', '*', '?', '&', '^', '#'
    private final String VALIDATION_REGEX = "(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&^#])(?!.*(.)\\1{2})\\S{10,128}$";

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }

        return value.matches(VALIDATION_REGEX);
    }
}
