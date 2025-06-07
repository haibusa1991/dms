package com.dms.beiam.restapi.adapters;

import com.dms.beiam.restapi.operations.v1.register.RegisterIdentityInput;
import com.dms.beiam.restapi.operations.v1.register.RegisterIdentityResult;

public interface AuthenticationAdapter {

    RegisterIdentityResult registerIdentity(RegisterIdentityInput input);
}
