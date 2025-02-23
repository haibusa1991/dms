package com.dms.beiam.apiadapter.mappers;

import com.dms.beiam.apiadapter.model.BeiamError;
import com.dms.beiam.restapi.models.RestApiError;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ModelMapperTest {
    private final ModelMapper mapper = Mappers.getMapper(ModelMapper.class);
    private final String MESSAGE = "message";
    private final String ERROR_CODE = "error_code";
    private final HttpStatus HTTP_STATUS = HttpStatus.BAD_REQUEST;

    @Test
    void toRestApiError() {
        BeiamError beiamError = BeiamError
                .builder()
                .message(MESSAGE)
                .errorCode(ERROR_CODE)
                .httpStatus(HTTP_STATUS)
                .build();

        RestApiError restApiError = mapper.toRestApiError(beiamError);

        assertEquals(1, restApiError.getMessage().size());
        assertEquals(MESSAGE, restApiError.getMessage().getFirst());
        assertEquals(ERROR_CODE, restApiError.getErrorCode());
        assertEquals(HTTP_STATUS, restApiError.getHttpStatus());
    }
}