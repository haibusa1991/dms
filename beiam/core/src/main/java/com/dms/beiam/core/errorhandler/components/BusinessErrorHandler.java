package com.dms.beiam.core.errorhandler.components;

import com.dms.beiam.apiadapter.model.BeiamError;
import com.dms.beiam.core.errorhandler.exceptions.BusinessException;
import org.springframework.stereotype.Component;

@Component
public class BusinessErrorHandler extends BaseErrorHandlerComponent {
    @Override
    public BeiamError handle(Throwable throwable) {

        if(!(throwable instanceof BusinessException businessException)) {
            return getNext().handle(throwable);
        }

        return BeiamError
                .builder()
                .errorCode(businessException.getErrorCode())
                .httpStatus(businessException.getHttpStatus())
                .message(businessException.getMessage())
                .build();
    }
}
