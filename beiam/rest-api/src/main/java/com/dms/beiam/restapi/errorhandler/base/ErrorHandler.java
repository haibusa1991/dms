package com.dms.beiam.restapi.errorhandler.base;


import org.springframework.http.ProblemDetail;

public interface ErrorHandler {

    ProblemDetail handle(Throwable throwable);
}
