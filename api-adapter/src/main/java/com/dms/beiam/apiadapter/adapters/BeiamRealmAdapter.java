package com.dms.beiam.apiadapter.adapters;

import com.dms.beiam.apiadapter.commandexecutor.base.CommandExecutor;
import com.dms.beiam.apiadapter.commands.system.v1.realm.register.RealmRegister;
import com.dms.beiam.apiadapter.commands.v1.register.RegisterIdentity;
import com.dms.beiam.apiadapter.mappers.AuthControllerMapper;
import com.dms.beiam.apiadapter.mappers.RealmRegisterMapper;
import com.dms.beiam.restapi.adapters.RealmAdapter;
import com.dms.beiam.restapi.operations.system.v1.realm.register.RealmRegisterInput;
import com.dms.beiam.restapi.operations.system.v1.realm.register.RealmRegisterResult;
import com.dms.beiam.restapi.operations.v1.register.RegisterIdentityInput;
import com.dms.beiam.restapi.operations.v1.register.RegisterIdentityResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BeiamRealmAdapter implements RealmAdapter {
    private final CommandExecutor commandExecutor;

    //mappers
    private final RealmRegisterMapper realmRegisterMapper;

    //commands
    private final RealmRegister realmRegister;


    @Override
    public RealmRegisterResult realmRegister(RealmRegisterInput input) {
        return commandExecutor.execute(input,realmRegisterMapper, realmRegister);
    }
}
