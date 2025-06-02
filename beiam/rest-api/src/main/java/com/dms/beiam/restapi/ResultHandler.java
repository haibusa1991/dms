package com.dms.beiam.restapi;

import com.dms.beiam.restapi.base.RestApiResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ResultHandler {

    public <RESULT extends RestApiResult> ResponseEntity<RESULT> handle(RESULT result) {
        return handle(result, HttpStatus.OK);
    }

    public <RESULT extends RestApiResult> ResponseEntity<RESULT> handle(RESULT result, HttpStatus status) {
        return new ResponseEntity<>(result, status);
    }
}
