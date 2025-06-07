package com.dms.beiam.apiadapter.commands.system.v1.realm.register;

import com.dms.beiam.apiadapter.commandexecutor.base.CommandResult;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class BeiamRealmRegisterResult implements CommandResult {

    private UUID realmId;
}
