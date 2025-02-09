package com.dms.beiam.apiadapter.base.error;

import org.springframework.http.HttpStatus;

public interface ProcessorError {

    HttpStatus getStatusCode();

    String getErrorCode();

    String getErrorMessage();

}
