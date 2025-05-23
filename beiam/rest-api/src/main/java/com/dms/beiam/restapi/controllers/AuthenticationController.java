package com.dms.beiam.restapi.controllers;

import com.dms.beiam.restapi.ResultHandler;
import com.dms.beiam.restapi.adapters.AuthenticationAdapter;
import com.dms.beiam.restapi.operations.v1.register.RegisterIdentityInput;
import com.dms.beiam.restapi.operations.v1.register.RegisterIdentityResult;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.dms.beiam.restapi.config.RestApiRoutes.REGISTER_IDENTITY;

@RestController
@RequiredArgsConstructor
public class AuthenticationController {
    private final ResultHandler resultHandler;
    private final AuthenticationAdapter authenticationAdapter;

    @PostMapping(REGISTER_IDENTITY)
    public ResponseEntity<?> registerIdentity(@Valid @RequestBody RegisterIdentityInput input) {
        RegisterIdentityResult result = authenticationAdapter.registerIdentity(input);

        return resultHandler.handle(result);
    }
}
