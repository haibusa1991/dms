package com.dms.beiam.apiadapter.commands.system.v1.realm.register;

import com.dms.beiam.apiadapter.commandexecutor.base.CommandInput;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class BeiamRealmRegisterInput implements CommandInput {

    private String realmName;
    private String realmAdminEmail;
}
