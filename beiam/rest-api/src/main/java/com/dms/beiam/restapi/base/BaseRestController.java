package com.dms.beiam.restapi.base;

import com.dms.beiam.restapi.models.RestApiError;
import io.vavr.control.Either;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public abstract class BaseRestController {

    protected ResponseEntity<?> handle(Either<RestApiError, ? extends RestApiResult> result, HttpStatus status) {
        if (result.isRight()) {
            return new ResponseEntity<>(result.get(), status);
        }

        RestApiError error = result.getLeft();
        return new ResponseEntity<>(error, error.getHttpStatus());
    }

    protected ResponseEntity<?> handle(Either<RestApiError, ? extends RestApiResult> result) {
        return handle(result, HttpStatus.OK);
    }

}
