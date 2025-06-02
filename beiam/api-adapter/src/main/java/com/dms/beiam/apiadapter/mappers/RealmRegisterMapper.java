package com.dms.beiam.apiadapter.mappers;

import com.dms.beiam.apiadapter.base.adapter.AdapterMapper;
import com.dms.beiam.apiadapter.commands.system.v1.realm.register.BeiamRealmRegisterInput;
import com.dms.beiam.apiadapter.commands.system.v1.realm.register.BeiamRealmRegisterResult;
import com.dms.beiam.apiadapter.commands.v1.register.BeiamRegisterIdentityInput;
import com.dms.beiam.apiadapter.commands.v1.register.BeiamRegisterIdentityResult;
import com.dms.beiam.restapi.operations.system.v1.realm.register.RealmRegisterInput;
import com.dms.beiam.restapi.operations.system.v1.realm.register.RealmRegisterResult;
import com.dms.beiam.restapi.operations.v1.register.RegisterIdentityInput;
import com.dms.beiam.restapi.operations.v1.register.RegisterIdentityResult;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RealmRegisterMapper extends AdapterMapper<RealmRegisterInput,
        BeiamRealmRegisterInput,
        BeiamRealmRegisterResult,
        RealmRegisterResult> {
}
