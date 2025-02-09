package com.dms.beiam.apiadapter.operations.v1.register;

import com.dms.beiam.apiadapter.base.processor.ProcessorInput;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class BeiamRegisterIdentityInput implements ProcessorInput {

    private String email;
    private String password;
}
