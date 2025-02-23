package com.dms.beiam.core.errorhandler.components;

import com.dms.beiam.apiadapter.model.BeiamError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import static com.dms.beiam.core.errorhandler.BeaimErrorCodes.SERVICE_UNAVAILABLE;
import static com.dms.beiam.core.errorhandler.BeaimErrorMessages.SOMETHING_WENT_WRONG;

@Component
@Slf4j
public class DatabaseErrorHandler extends BaseErrorHandlerComponent {
    @Override
    public BeiamError handle(Throwable throwable) {
        if (!(throwable instanceof DataIntegrityViolationException exception)) {
            return getNext().handle(throwable);
        }

        //Constraint violation errors get hidden behind a generic something went wrong message
        log.debug(exception.getMessage());

        return BeiamError
                .builder()
                .errorCode(SERVICE_UNAVAILABLE)
                .httpStatus(HttpStatus.SERVICE_UNAVAILABLE)
                .message(SOMETHING_WENT_WRONG)
                .build();
    }
}
