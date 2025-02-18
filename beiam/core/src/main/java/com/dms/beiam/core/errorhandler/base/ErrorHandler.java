package com.dms.beiam.core.errorhandler.base;

import com.dms.beiam.apiadapter.model.BeiamError;

public interface ErrorHandler {

    BeiamError handle(Throwable throwable);
}
