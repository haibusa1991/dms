package com.dms.beiam.apiadapter;

import com.dms.beiam.apiadapter.base.error.ProcessorError;
import com.dms.beiam.apiadapter.mappers.AuthControllerMapper;
import com.dms.beiam.apiadapter.operations.v1.register.BeiamRegisterIdentityInput;
import com.dms.beiam.apiadapter.operations.v1.register.BeiamRegisterIdentityResult;
import com.dms.beiam.apiadapter.operations.v1.register.RegisterIdentity;
import com.dms.beiam.restapi.operations.v1.register.RegisterIdentityInput;
import com.dms.beiam.restapi.operations.v1.register.RegisterIdentityResult;
import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthApiAdapter {

    private final RegisterIdentity registerIdentity;
    private final AuthControllerMapper mapper;

    public RegisterIdentityResult registerIdentity(RegisterIdentityInput input) {
        BeiamRegisterIdentityInput coreInput = mapper.toCoreInput(input);

        Either<ProcessorError, BeiamRegisterIdentityResult> process = registerIdentity.process(coreInput);

        if(process.isRight()) {
            return mapper.toRestApiResult(process.get());
        } else {
            return RegisterIdentityResult.builder().build(); // TODO: properly handle error
        }
    }
}
