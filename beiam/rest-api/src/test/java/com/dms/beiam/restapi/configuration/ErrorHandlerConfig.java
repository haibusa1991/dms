package com.dms.beiam.restapi.configuration;

import com.dms.beiam.restapi.errorhandler.components.BusinessErrorHandler;
import com.dms.beiam.restapi.errorhandler.components.DatabaseErrorHandler;
import com.dms.beiam.restapi.errorhandler.components.InternalErrorHandler;
import com.dms.beiam.restapi.errorhandler.components.ValidationErrorHandler;
import com.dms.beiam.restapi.errorhandler.manager.ErrorHandlerManager;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class ErrorHandlerConfig {

    @Bean
    public BusinessErrorHandler businessErrorHandler() {
        return new BusinessErrorHandler();
    }

    @Bean
    public DatabaseErrorHandler databaseErrorHandler() {
        return new DatabaseErrorHandler();
    }

    @Bean
    public InternalErrorHandler internalErrorHandler() {
        return new InternalErrorHandler();
    }

    @Bean
    public ValidationErrorHandler validationErrorHandler() {
        return new ValidationErrorHandler();
    }

    @Bean
    public ErrorHandlerManager errorHandlerManager(ApplicationContext applicationContext) {
        return new ErrorHandlerManager(applicationContext);
    }

}
