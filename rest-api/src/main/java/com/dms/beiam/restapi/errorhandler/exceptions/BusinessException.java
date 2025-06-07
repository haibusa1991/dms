package com.dms.beiam.restapi.errorhandler.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public class BusinessException extends RuntimeException {
    private final String message;
    private final HttpStatus httpStatus;
    private final String errorCode;
}
