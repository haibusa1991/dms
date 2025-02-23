package com.dms.beiam.core.errorhandler.manager;

import com.dms.beiam.apiadapter.model.BeiamError;
import com.dms.beiam.core.config.ErrorHandlerManagerConfig;
import com.dms.beiam.core.errorhandler.base.ErrorHandlerComponent;
import com.dms.beiam.core.errorhandler.exceptions.BusinessException;
import lombok.SneakyThrows;
import org.hibernate.exception.ConstraintViolationException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {ErrorHandlerManagerConfig.class})
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

        BeiamError handle = errorHandlerManager.handle(businessException);

        assertEquals(TEST_MESSAGE, handle.getMessage());
        assertEquals(TEST_HTTP_STATUS, handle.getHttpStatus());
        assertEquals(TEST_ERROR_CODE, handle.getErrorCode());
    }

    @Test
    void handlesCorrectConstraintViolationException() {
        SQLException sqlException = new SQLException(TEST_SQL_ERROR_MESSAGE);
        DataIntegrityViolationException exception = new DataIntegrityViolationException(TEST_MESSAGE, sqlException);

        BeiamError handle = errorHandlerManager.handle(exception);

        assertEquals("Something went wrong", handle.getMessage());
        assertEquals(HttpStatus.SERVICE_UNAVAILABLE, handle.getHttpStatus());
        assertEquals("BEIAM-SU", handle.getErrorCode());
    }

    @Test
    void returnsInternalErrorWhenNoHandlerFound() {
        Exception exception = new Exception(TEST_MESSAGE);

        BeiamError handle = errorHandlerManager.handle(exception);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, handle.getHttpStatus());
        assertEquals("BEIAM-ISE", handle.getErrorCode());
        assertEquals(TEST_MESSAGE, handle.getMessage());
    }
}