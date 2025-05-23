package com.dms.beiam.apiadapter.mappers;

import com.dms.beiam.apiadapter.commands.v1.register.BeiamRegisterIdentityInput;
import com.dms.beiam.apiadapter.commands.v1.register.BeiamRegisterIdentityResult;
import com.dms.beiam.restapi.operations.v1.register.RegisterIdentityInput;
import com.dms.beiam.restapi.operations.v1.register.RegisterIdentityResult;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class AuthControllerMapperTest {

    private final AuthControllerMapper mapper = Mappers.getMapper(AuthControllerMapper.class);
    private final String EMAIL = "email";
    private final String PASSWORD = "password";
    private final UUID IDENTITY_ID = UUID.fromString("00000000-0000-0000-0000-000000000000");


    @Test
    void registerIdentityInputConvertsCorrectToCoreInput() {
        RegisterIdentityInput input =
                RegisterIdentityInput
                        .builder()
                        .email(EMAIL)
                        .password(PASSWORD)
                        .build();

        BeiamRegisterIdentityInput coreInput = mapper.toCoreInput(input);

        assertEquals(EMAIL, coreInput.getEmail());
        assertEquals(PASSWORD, coreInput.getPassword());
    }

    @Test
    void registerIdentityInputConvertsCorrectToRestApiResult() {
        BeiamRegisterIdentityResult result = BeiamRegisterIdentityResult
                .builder()
                .identityId(IDENTITY_ID)
                .build();

        RegisterIdentityResult restApiResult = mapper.toRestApiResult(result);

        assertEquals(IDENTITY_ID, restApiResult.getIdentityId());
    }
}