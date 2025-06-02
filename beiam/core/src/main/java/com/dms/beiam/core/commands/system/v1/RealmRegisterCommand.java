package com.dms.beiam.core.commands.system.v1;

import com.dms.beiam.apiadapter.commands.system.v1.realm.register.BeiamRealmRegisterInput;
import com.dms.beiam.apiadapter.commands.system.v1.realm.register.BeiamRealmRegisterResult;
import com.dms.beiam.apiadapter.commands.system.v1.realm.register.RealmRegister;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RealmRegisterCommand implements RealmRegister {
    @Override
    public BeiamRealmRegisterResult execute(BeiamRealmRegisterInput input) {
        return BeiamRealmRegisterResult
                .builder()
                .realmId(UUID.fromString("00000000-0000-0000-0000-000000000000"))
                .build();
    }
}
