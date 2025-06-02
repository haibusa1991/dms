package com.dms.beiam.restapi.errorhandler.base;


import org.springframework.http.ProblemDetail;

public interface ErrorHandlerComponent {

    ProblemDetail handle(Throwable throwable);

    void setNext(ErrorHandlerComponent next);

    ErrorHandlerComponent getNext();
}
