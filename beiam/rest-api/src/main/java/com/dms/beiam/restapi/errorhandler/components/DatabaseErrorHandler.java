package com.dms.beiam.restapi.errorhandler.components;

import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.stereotype.Component;

import static com.dms.beiam.restapi.errorhandler.BeaimErrorCodes.SERVICE_UNAVAILABLE;
import static com.dms.beiam.restapi.errorhandler.BeaimErrorMessages.SOMETHING_WENT_WRONG;

@Component
@Slf4j
public class DatabaseErrorHandler extends BaseErrorHandlerComponent {
    @Override
    public ProblemDetail handle(Throwable throwable) {
        if (!(throwable instanceof DataIntegrityViolationException exception)) {
            return getNext().handle(throwable);
        }

        //Constraint violation errors get hidden behind a generic something went wrong message
        log.debug(exception.getMessage());


        ProblemDetail problemDetail = ProblemDetail
                .forStatusAndDetail(HttpStatus.SERVICE_UNAVAILABLE, SOMETHING_WENT_WRONG);

        problemDetail.setTitle(SERVICE_UNAVAILABLE);

        return problemDetail;
    }
}
