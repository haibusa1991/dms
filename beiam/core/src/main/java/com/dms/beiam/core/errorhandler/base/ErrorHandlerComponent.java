package com.dms.beiam.core.errorhandler.base;

import com.dms.beiam.apiadapter.model.BeiamError;

public interface ErrorHandlerComponent {

    BeiamError handle(Throwable throwable);

    void setNext(ErrorHandlerComponent next);

    ErrorHandlerComponent getNext();
}
