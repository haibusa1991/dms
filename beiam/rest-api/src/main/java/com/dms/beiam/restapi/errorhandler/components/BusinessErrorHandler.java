package com.dms.beiam.restapi.errorhandler.components;

import com.dms.beiam.restapi.errorhandler.exceptions.BusinessException;
import org.springframework.http.ProblemDetail;
import org.springframework.stereotype.Component;

@Component
public class BusinessErrorHandler extends BaseErrorHandlerComponent {
    @Override
    public ProblemDetail handle(Throwable throwable) {

        if (!(throwable instanceof BusinessException businessException)) {
            return getNext().handle(throwable);
        }

        ProblemDetail problemDetail = ProblemDetail
                .forStatusAndDetail(businessException.getHttpStatus(), businessException.getMessage());

        problemDetail.setTitle(businessException.getErrorCode());

        return problemDetail;
    }
}
