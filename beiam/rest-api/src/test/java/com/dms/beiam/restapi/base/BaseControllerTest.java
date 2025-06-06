package com.dms.beiam.restapi.base;

import com.dms.beiam.restapi.ResultHandler;
import com.dms.beiam.restapi.adapters.RealmAdapter;
import com.dms.beiam.restapi.config.BootConfig;
import com.dms.beiam.restapi.config.ErrorHandlerConfig;
import com.dms.beiam.restapi.config.SecurityConfig;
import com.dms.beiam.restapi.controllers.RealmController;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

@Import({
        ResultHandler.class,
        ErrorHandlerConfig.class,
        SecurityConfig.class
})
@WebMvcTest(controllers = RealmController.class)
@ContextConfiguration(classes = BootConfig.class)
public class BaseControllerTest {

    @Autowired
    protected MockMvc mockMvc;

    protected final ObjectMapper objectMapper = new ObjectMapper();

    @MockitoBean
    protected RealmAdapter realmAdapter;
}
