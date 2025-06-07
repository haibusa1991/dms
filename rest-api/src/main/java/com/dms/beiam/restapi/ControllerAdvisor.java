package com.dms.beiam.restapi;

import com.dms.beiam.restapi.errorhandler.base.ErrorHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@RequiredArgsConstructor
public class ControllerAdvisor {
    private final ErrorHandler errorHandler;

    @ExceptionHandler(Exception.class)
    public ProblemDetail handleException(Exception e) {
        return errorHandler.handle(e);
    }
}
