package com.dms.beiam.restapi.operations.v1.register;

import com.dms.beiam.restapi.base.RestApiResult;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class RegisterIdentityResult implements RestApiResult {

    private UUID identityId;
}
