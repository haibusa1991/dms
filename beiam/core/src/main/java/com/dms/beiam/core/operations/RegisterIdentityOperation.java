package com.dms.beiam.core.operations;

import com.dms.beiam.apiadapter.base.error.ProcessorError;
import com.dms.beiam.apiadapter.operations.v1.register.BeiamRegisterIdentityInput;
import com.dms.beiam.apiadapter.operations.v1.register.BeiamRegisterIdentityResult;
import com.dms.beiam.apiadapter.operations.v1.register.RegisterIdentity;
import io.vavr.control.Either;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RegisterIdentityOperation implements RegisterIdentity {
    @Override
    public Either<ProcessorError, BeiamRegisterIdentityResult> process(BeiamRegisterIdentityInput input) {
        return Either.right(BeiamRegisterIdentityResult
                .builder()
                .identityId(UUID.fromString("00000000-0000-0000-0000-000000000000"))
                .build());
    }
}
