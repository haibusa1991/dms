package com.dms.beiam.apiadapter.adapters;

import com.dms.beiam.apiadapter.commandexecutor.base.CommandExecutor;
import com.dms.beiam.apiadapter.commands.v1.register.RegisterIdentity;
import com.dms.beiam.apiadapter.mappers.AuthControllerMapper;
import com.dms.beiam.restapi.adapters.AuthenticationAdapter;
import com.dms.beiam.restapi.operations.v1.register.RegisterIdentityInput;
import com.dms.beiam.restapi.operations.v1.register.RegisterIdentityResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BeiamAuthenticationAdapter implements AuthenticationAdapter {
    private final CommandExecutor commandExecutor;

    //mappers
    private final AuthControllerMapper authControllerMapper;

    //commands
    private final RegisterIdentity registerIdentity;

    @Override
    public RegisterIdentityResult registerIdentity(RegisterIdentityInput input) {
        return commandExecutor.execute(input, authControllerMapper, registerIdentity);
    }
}
