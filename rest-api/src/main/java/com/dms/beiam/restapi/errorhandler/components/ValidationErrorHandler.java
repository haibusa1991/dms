package com.dms.beiam.restapi.errorhandler.components;

import jakarta.validation.ConstraintViolation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;

import static com.dms.beiam.restapi.errorhandler.BeaimErrorCodes.BAD_REQUEST;
import static com.dms.beiam.restapi.errorhandler.BeaimErrorCodes.INPUT_CONSTRAINT_VIOLATION;

@Component
public class ValidationErrorHandler extends BaseErrorHandlerComponent {

    @Override
    public ProblemDetail handle(Throwable throwable) {

        if (!(throwable instanceof MethodArgumentNotValidException validationException)) {
            return getNext().handle(throwable);
        }

        List<String> errors = validationException
                .getBindingResult()
                .getAllErrors()
                .stream()
                .map(error -> error.unwrap(ConstraintViolation.class))
                .map(violation -> violation.getPropertyPath().toString() + " " + violation.getMessage())
                .toList();

        return getProblemDetail(HttpStatus.BAD_REQUEST, String.join("; ", errors), INPUT_CONSTRAINT_VIOLATION);
    }
}
