package com.dms.beiam.restapi.errorhandler.manager;

import com.dms.beiam.restapi.config.ErrorHandlerConfig;
import com.dms.beiam.restapi.errorhandler.base.ErrorHandlerComponent;
import com.dms.beiam.restapi.errorhandler.exceptions.BusinessException;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.List;

import static com.dms.beiam.restapi.errorhandler.BeaimErrorCodes.INTERNAL_SERVER_ERROR;
import static com.dms.beiam.restapi.errorhandler.BeaimErrorCodes.SERVICE_UNAVAILABLE;
import static com.dms.beiam.restapi.errorhandler.BeaimErrorMessages.SOMETHING_WENT_WRONG;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {ErrorHandlerConfig.class})
class ErrorHandlerManagerTest {
    private final String TEST_MESSAGE = "Test message";
    private final String TEST_SQL_ERROR_MESSAGE = "Test sql error message";
    private final HttpStatus TEST_HTTP_STATUS = HttpStatus.BAD_REQUEST;
    private final String TEST_ERROR_CODE = "TEST_ERROR_CODE";

    @Autowired
    private ErrorHandlerManager errorHandlerManager;

    @Test
    @SneakyThrows
    void initializesComponents() {
        Field components = errorHandlerManager
                .getClass()
                .getDeclaredField("components");

        components.setAccessible(true);

        List<ErrorHandlerComponent> componentList = (List<ErrorHandlerComponent>) components.get(errorHandlerManager);
        assertFalse(componentList.isEmpty());
    }

    @Test
    @SneakyThrows
    void correctlyOrdersAndChainsComponents() {
        Field components = errorHandlerManager
                .getClass()
                .getDeclaredField("components");

        components.setAccessible(true);

        List<ErrorHandlerComponent> componentList = (List<ErrorHandlerComponent>) components.get(errorHandlerManager);

        ErrorHandlerComponent lastHandler = componentList
                .stream()
                .reduce((a, b) -> b)
                .get();

        assertNull(lastHandler.getNext());
        assertEquals(999, lastHandler.getClass().getAnnotation(Order.class).value());
        componentList
                .stream()
                .limit(componentList.size() - 1)
                .forEach(component -> assertNotNull(component.getNext()));
    }


    @Test
    void handlesCorrectBusinessException() {
        BusinessException businessException = new BusinessException(TEST_MESSAGE, TEST_HTTP_STATUS, TEST_ERROR_CODE);

        ProblemDetail result = errorHandlerManager.handle(businessException);

        assertEquals(TEST_MESSAGE, result.getDetail());
        assertEquals(TEST_HTTP_STATUS.value(), result.getStatus());
        assertEquals(TEST_ERROR_CODE, result.getTitle());
    }

    @Test
    void handlesCorrectConstraintViolationException() {
        SQLException sqlException = new SQLException(TEST_SQL_ERROR_MESSAGE);
        DataIntegrityViolationException exception = new DataIntegrityViolationException(TEST_MESSAGE, sqlException);

        ProblemDetail result = errorHandlerManager.handle(exception);

        assertEquals(SOMETHING_WENT_WRONG, result.getDetail());
        assertEquals(HttpStatus.SERVICE_UNAVAILABLE.value(), result.getStatus());
        assertEquals(SERVICE_UNAVAILABLE, result.getTitle());
    }

    @Test
    void returnsInternalErrorWhenNoHandlerFound() {
        Exception exception = new Exception(TEST_MESSAGE);

        ProblemDetail result = errorHandlerManager.handle(exception);

        assertEquals(TEST_MESSAGE, result.getDetail());
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), result.getStatus());
        assertEquals(INTERNAL_SERVER_ERROR, result.getTitle());
    }
}