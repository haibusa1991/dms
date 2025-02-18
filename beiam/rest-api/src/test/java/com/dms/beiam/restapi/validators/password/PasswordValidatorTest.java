package com.dms.beiam.restapi.validators.password;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;

class PasswordValidatorTest {
    static Stream<Arguments> returnsFalseWhenPasswordInvalid() {
        String tooLong = "Qwerty123@".repeat(13);

        return Stream.of(
                Arguments.of("1234567890"),     // digits only
                Arguments.of("qwertyuiop"),     // lowercase only
                Arguments.of("QWERTYUIOP"),     // uppercase only
                Arguments.of("Aa1234!"),        // too short
                Arguments.of("Aa1222567!"),     // repeating characters
                Arguments.of("qwerty123@"),     // no uppercase
                Arguments.of("QWERTY123@"),     // no lowercase
                Arguments.of("Qwertyuio1"),     // no special characters
                Arguments.of("Qwertyuio@"),     // no digits
                Arguments.of("Qwerty123>"),     // unsupported special character
                Arguments.of(tooLong));         // too long
    }

    @ParameterizedTest
    @MethodSource
    void returnsFalseWhenPasswordInvalid(String password) {
        PasswordValidator validator = new PasswordValidator();
        assertFalse(validator.isValid(password, null));
    }
}