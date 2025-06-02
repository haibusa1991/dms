package com.dms.beiam.restapi.adapters;

import com.dms.beiam.restapi.operations.system.v1.realm.register.RealmRegisterInput;
import com.dms.beiam.restapi.operations.system.v1.realm.register.RealmRegisterResult;

public interface RealmAdapter {

    RealmRegisterResult realmRegister(RealmRegisterInput input);
}
