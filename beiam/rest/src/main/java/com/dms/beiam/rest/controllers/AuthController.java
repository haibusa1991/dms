package com.dms.beiam.rest.controllers;

import com.dms.beiam.apiadapter.AuthApiAdapter;
import com.dms.beiam.restapi.operations.v1.register.RegisterIdentityInput;
import com.dms.beiam.restapi.operations.v1.register.RegisterIdentityResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.dms.beiam.restapi.config.RestApiRoutes.REGISTER_IDENTITY;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthApiAdapter authApiAdapter;


    @PostMapping(REGISTER_IDENTITY)
    public String registerIdentity(@RequestBody RegisterIdentityInput input) {
        RegisterIdentityResult result = authApiAdapter.registerIdentity(input);
        return result.getIdentityId().toString();
    }
}
