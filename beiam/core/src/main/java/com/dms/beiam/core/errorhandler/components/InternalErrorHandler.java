package com.dms.beiam.core.errorhandler.components;

import com.dms.beiam.apiadapter.model.BeiamError;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import static com.dms.beiam.core.errorhandler.BeaimErrorCodes.INTERNAL_SERVER_ERROR;

@Component
@Order(999) // this should be the very last handler
public class InternalErrorHandler extends BaseErrorHandlerComponent {

    @Override
    public BeiamError handle(Throwable throwable) {
        return BeiamError
                .builder()
                .errorCode(INTERNAL_SERVER_ERROR)
                .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                .message(throwable.getMessage())
                .build();
    }
}
