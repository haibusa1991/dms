package com.dms.beiam.apiadapter.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
@Builder
public class BeiamError {

    private String message;
    private String errorCode;
    private HttpStatus httpStatus;
}
