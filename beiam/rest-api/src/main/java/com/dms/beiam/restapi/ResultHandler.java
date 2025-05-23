package com.dms.beiam.restapi;

import com.dms.beiam.restapi.base.RestApiResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ResultHandler {

    public ResponseEntity<? extends RestApiResult> handle(RestApiResult result) {
        return handle(result, HttpStatus.OK);
    }

    public ResponseEntity<? extends RestApiResult> handle(RestApiResult result, HttpStatus status) {
        return new ResponseEntity<>(result, status);
    }
}
