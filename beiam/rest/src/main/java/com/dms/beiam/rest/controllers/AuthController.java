package com.dms.beiam.rest.controllers;

import com.dms.beiam.apiadapter.AuthApiRestApiAdapter;
import com.dms.beiam.rest.base.BaseRestController;
import com.dms.beiam.restapi.models.RestApiError;
import com.dms.beiam.restapi.operations.v1.register.RegisterIdentityInput;
import com.dms.beiam.restapi.operations.v1.register.RegisterIdentityResult;
import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.dms.beiam.restapi.config.RestApiRoutes.REGISTER_IDENTITY;

@RestController
@RequiredArgsConstructor
public class AuthController extends BaseRestController {
    private final AuthApiRestApiAdapter authApiAdapter;

    @PostMapping(REGISTER_IDENTITY)
    public ResponseEntity<?> registerIdentity(@RequestBody RegisterIdentityInput input) {
        Either<RestApiError, RegisterIdentityResult> result = authApiAdapter.registerIdentity(input);

        return handle(result);
    }
}
