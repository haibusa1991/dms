package com.dms.beiam.restapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.List;

@Getter
@Setter
@Builder
public class RestApiError {
    private List<String> message;
    private String errorCode;

    @JsonIgnore
    private HttpStatus httpStatus;
}
