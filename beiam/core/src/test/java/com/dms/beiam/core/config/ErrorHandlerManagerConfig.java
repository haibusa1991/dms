package com.dms.beiam.core.config;

import com.dms.beiam.core.errorhandler.components.BusinessErrorHandler;
import com.dms.beiam.core.errorhandler.components.InternalErrorHandler;
import com.dms.beiam.core.errorhandler.manager.ErrorHandlerManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ErrorHandlerManagerConfig {

    @Bean
    public BusinessErrorHandler businessErrorHandler() {
        return new BusinessErrorHandler();
    }

    @Bean
    public InternalErrorHandler internalErrorHandler() {
        return new InternalErrorHandler();
    }

    @Bean
    public ErrorHandlerManager errorHandlerManager(ApplicationContext applicationContext) {
        return new ErrorHandlerManager(applicationContext);
    }
}
