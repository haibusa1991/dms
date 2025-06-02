package com.dms.beiam.restapi.errorhandler.components;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.stereotype.Component;

import static com.dms.beiam.restapi.errorhandler.BeaimErrorCodes.INTERNAL_SERVER_ERROR;

@Component
@Order(999) // this should be the very last handler
public class InternalErrorHandler extends BaseErrorHandlerComponent {

    @Override
    public ProblemDetail handle(Throwable throwable) {

        ProblemDetail problemDetail = ProblemDetail
                .forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR, throwable.getLocalizedMessage());

        problemDetail.setTitle(INTERNAL_SERVER_ERROR);

        return problemDetail;
    }
}
