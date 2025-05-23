package com.dms.beiam.apiadapter.commands.v1.register;

import com.dms.beiam.apiadapter.base.processor.CommandResult;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class BeiamRegisterIdentityResult implements CommandResult {

    private UUID identityId;
}
