package com.dms.beiam.apiadapter.operations.v1.register;

import com.dms.beiam.apiadapter.base.processor.ProcessorResult;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class BeiamRegisterIdentityResult implements ProcessorResult {

    private UUID identityId;
}
