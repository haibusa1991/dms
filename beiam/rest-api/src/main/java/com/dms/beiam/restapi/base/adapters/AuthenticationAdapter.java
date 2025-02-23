package com.dms.beiam.restapi.base.adapters;

import com.dms.beiam.restapi.models.RestApiError;
import com.dms.beiam.restapi.operations.v1.register.RegisterIdentityInput;
import com.dms.beiam.restapi.operations.v1.register.RegisterIdentityResult;
import io.vavr.control.Either;

public interface AuthenticationAdapter {
    Either<RestApiError, RegisterIdentityResult> registerIdentity(RegisterIdentityInput input);
}
