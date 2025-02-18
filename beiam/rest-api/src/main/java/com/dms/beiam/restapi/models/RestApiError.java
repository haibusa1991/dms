package com.dms.beiam.restapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class RestApiError {
    private String message;
    private String errorCode;

    @JsonIgnore
    private HttpStatus httpStatus;
}
