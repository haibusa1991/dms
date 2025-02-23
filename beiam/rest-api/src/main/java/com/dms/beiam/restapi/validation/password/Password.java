package com.dms.beiam.restapi.validation.password;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = PasswordValidator.class)
public @interface Password {
    /**
     * Password must be between 10 and 128 characters long. Should contain at least one uppercase letter, one lowercase
     * letter, one digit, one special character, and no more than 2 repeating characters. Special characters considered
     * valid are '@', '$', '!', '%', '*', '?', '&', '^', '#'. Null and empty strings are not considered valid.
     */

    String message() default "does not meet the requirements";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
